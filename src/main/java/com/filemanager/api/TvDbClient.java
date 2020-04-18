package com.filemanager.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.filemanager.entity.request.LoginRequest;
import com.filemanager.entity.response.LoginResponse;
import com.filemanager.entity.response.SeriesEpisodesResponse;
import com.filemanager.entity.response.SeriesSearchResponse;
import kong.unirest.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/** The client wrapper for the TVDB API. */
public class TvDbClient implements AutoCloseable {

  /** The base URL for all TVDB APIs */
  public static final String BASE_URL = "https://api.thetvdb.com";

  /** URL to search for a series */
  public static final String SERIES_SEARCH_URL = BASE_URL + "/search/series";

  public static final String SERIES_EPISODES_URL = BASE_URL + "/series/{id}/episodes";

  /** API key */
  public static final String API_KEY = "875675dfae983c11bf2822d402e08641";

  /** Login URL */
  public static final String LOGIN_URL = BASE_URL + "/login";

  /** Amount of time the token is valid. 24 hours. */
  public static final int TOKEN_DURATION = 60 * 60 * 24;

  static {
    ToStringBuilder.setDefaultStyle(ToStringStyle.NO_CLASS_NAME_STYLE);
  }

  protected final Logger logger;

  /** The date/time when the bearer token will expire. */
  protected LocalDateTime expiration = LocalDateTime.MIN;

  /** The most recent bearer token. */
  protected String bearerToken;

  public TvDbClient() {
    logger = LoggerFactory.getLogger(getClass());
    Unirest.config()
        .setObjectMapper(
            new ObjectMapper() {
              final com.fasterxml.jackson.databind.ObjectMapper objectMapper =
                  new com.fasterxml.jackson.databind.ObjectMapper();

              @Override
              public <T> T readValue(String value, Class<T> valueType) {
                try {
                  return objectMapper.readValue(value, valueType);
                } catch (JsonProcessingException e) {
                  throw new UnirestException(e);
                }
              }

              @Override
              public String writeValue(Object value) {
                try {
                  return objectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                  throw new UnirestException(e);
                }
              }
            });
  }

  /**
   * Search for a series by name.
   *
   * @param seriesName The series name
   * @return The response containing the matching series. Because this search is done by the TVDB,
   *     there could be multiple results.
   */
  public SeriesSearchResponse seriesSearch(@NotNull String seriesName) {
    String token = getToken();

    HttpRequest<GetRequest> httpRequest =
        Unirest.get(SERIES_SEARCH_URL)
            .header("authorization", "Bearer " + token)
            .queryString("name", seriesName);

    logger.debug("URL: {}", httpRequest.getUrl());

    HttpResponse<SeriesSearchResponse> httpResponse =
        httpRequest.asObject(SeriesSearchResponse.class);

    if (!httpResponse.isSuccess()) {
      Optional<UnirestParsingException> optional = httpResponse.getParsingError();
      if (optional.isPresent()) {
        throw optional.get();
      }

      throw new UnsupportedOperationException(
          "Failed to search series: " + httpResponse.getStatusText());
    }

    SeriesSearchResponse seriesSearchResponse = httpResponse.getBody();
    logger.debug("{}", seriesSearchResponse);
    return seriesSearchResponse;
  }

  /**
   * Retrieves the list of episodes for a given series on the first page.
   *
   * @param seriesId The series ID
   * @return The response containing the list of episodes for the first page.
   * @see #seriesEpisodes(long, long)
   */
  public SeriesEpisodesResponse seriesEpisodes(@NotNull long seriesId) {
    return seriesEpisodes(seriesId, 1);
  }

  /**
   * Retrieves the list of episodes for a given series on a given page.
   *
   * @param seriesId The series ID
   * @param page The page of episodes to retrieve
   * @return The response containing the list of episodes for the given page.
   */
  public SeriesEpisodesResponse seriesEpisodes(@NotNull long seriesId, long page) {
    String token = getToken();
    HttpRequest<GetRequest> httpRequest =
        Unirest.get(SERIES_EPISODES_URL)
            .header("authorization", "Bearer " + token)
            .routeParam("id", Long.toString(seriesId))
            .queryString("page", page);

    logger.debug("URL: {}", httpRequest.getUrl());

    HttpResponse<SeriesEpisodesResponse> httpResponse =
        httpRequest.asObject(SeriesEpisodesResponse.class);

    if (!httpResponse.isSuccess()) {
      Optional<UnirestParsingException> optional = httpResponse.getParsingError();
      if (optional.isPresent()) {
        throw optional.get();
      }

      throw new UnsupportedOperationException(
          "Failed to get series episodes: " + httpResponse.getStatusText());
    }

    SeriesEpisodesResponse seriesEpisodesResponse = httpResponse.getBody();
    logger.debug("{}", seriesEpisodesResponse);
    return seriesEpisodesResponse;
  }

  /**
   * Retrieves the list of all episodes for a given series.
   *
   * @param seriesId The series ID.
   * @return The list of all episodes for a given series.
   * @see #seriesEpisodes(long, long)
   * @see #seriesSearch(String)
   */
  public List<SeriesEpisodesResponse.SeriesEpisodesResult> findAllSeriesEpisodes(
      @NotNull long seriesId) {
    LinkedList<SeriesEpisodesResponse.SeriesEpisodesResult> results = new LinkedList<>();
    Long next = 1l;
    do {
      SeriesEpisodesResponse response = seriesEpisodes(seriesId, next);
      next = response.getLinks().getNext();
      results.addAll(response.getData());
    } while (next != null);

    return results;
  }

  /**
   * Gets a valid token. If the current token is still valid then will return that. Otherwise will
   * retrieve a new one.
   *
   * @return A valid token to be used with the TVDB API.
   */
  protected String getToken() {
    if (LocalDateTime.now().isAfter(expiration)) {
      logger.debug("Retrieving new token");

      LoginRequest loginRequest = new LoginRequest();
      loginRequest.setApiKey(API_KEY);

      logger.debug("{}", loginRequest);

      HttpResponse<LoginResponse> httpResponse =
          Unirest.post(LOGIN_URL)
              .header("Content-Type", "application/json")
              .header("Accept", "application/json")
              .body(loginRequest)
              .asObject(LoginResponse.class);

      if (!httpResponse.isSuccess()) {
        throw new UnsupportedOperationException(
            "Unable to retrieve TVDB token: " + httpResponse.getStatusText());
      }

      LoginResponse loginResponse = httpResponse.getBody();
      logger.debug("{}", loginResponse);

      bearerToken = loginResponse.getToken();
      expiration = LocalDateTime.now().plusSeconds(TOKEN_DURATION);
    }

    logger.debug("Token: {}", bearerToken);
    return bearerToken;
  }

  @Override
  public void close() {
    Unirest.shutDown();
  }
}
