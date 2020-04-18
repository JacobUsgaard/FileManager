package com.filemanager.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "id",
  "airedSeason",
  "airedSeasonID",
  "airedEpisodeNumber",
  "episodeName",
  "firstAired",
  "guestStars",
  "directors",
  "writers",
  "overview",
  "language",
  "productionCode",
  "showUrl",
  "lastUpdated",
  "dvdDiscid",
  "dvdSeason",
  "dvdEpisodeNumber",
  "dvdChapter",
  "absoluteNumber",
  "filename",
  "seriesId",
  "lastUpdatedBy",
  "airsAfterSeason",
  "airsBeforeSeason",
  "airsBeforeEpisode",
  "imdbId",
  "contentRating",
  "thumbAuthor",
  "thumbAdded",
  "thumbWidth",
  "thumbHeight",
  "siteRating",
  "siteRatingCount",
  "isMovie"
})
public class SeriesEpisodesResponse {

  @JsonProperty("data")
  private List<SeriesEpisodesResult> data;

  @JsonProperty("errors")
  private Errors errors;

  @JsonProperty("links")
  private Links links;

  @JsonProperty("data")
  public List<SeriesEpisodesResult> getData() {
    return data;
  }

  @JsonProperty("data")
  public void setData(List<SeriesEpisodesResult> data) {
    this.data = data;
  }

  @JsonProperty("errors")
  public Errors getErrors() {
    return errors;
  }

  @JsonProperty("errors")
  public void setErrors(Errors errors) {
    this.errors = errors;
  }

  @JsonProperty("links")
  public Links getLinks() {
    return links;
  }

  @JsonProperty("links")
  public void setLinks(Links links) {
    this.links = links;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  public static class SeriesEpisodesResult {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("airedSeason")
    private Long airedSeason;

    @JsonProperty("airedSeasonID")
    private Long airedSeasonId;

    @JsonProperty("airedEpisodeNumber")
    private Long airedEpisodeNumber;

    @JsonProperty("episodeName")
    private String episodeName;

    @JsonProperty("firstAired")
    private String firstAired;

    @JsonProperty("guestStars")
    private List<String> guestStars;

    @JsonProperty("directors")
    private List<String> directors;

    @JsonProperty("writers")
    private List<String> writers;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("language")
    private Language language;

    @JsonProperty("productionCode")
    private String productionCode;

    @JsonProperty("showUrl")
    private String showUrl;

    @JsonProperty("lastUpdated")
    private Long lastUpdated;

    @JsonProperty("dvdDiscid")
    private String dvdDiscId;

    @JsonProperty("dvdSeason")
    private Long dvdSeason;

    @JsonProperty("dvdEpisodeNumber")
    private Long dvdEpisodeNumber;

    @JsonProperty("dvdChapter")
    private Long dvdChapter;

    @JsonProperty("absoluteNumber")
    private Long absoluteNumber;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("seriesId")
    private Long seriesId;

    @JsonProperty("lastUpdatedBy")
    private Long lastUpdatedBy;

    @JsonProperty("airsAfterSeason")
    private Long airsAfterSeason;

    @JsonProperty("airsBeforeSeason")
    private Long airsBeforeSeason;

    @JsonProperty("airsBeforeEpisode")
    private Long airsBeforeEpisode;

    @JsonProperty("imdbId")
    private String imdbId;

    @JsonProperty("contentRating")
    private String contentRating;

    @JsonProperty("thumbAuthor")
    private Long thumbAuthor;

    @JsonProperty("thumbAdded")
    private String thumbAdded;

    @JsonProperty("thumbWidth")
    private String thumbWidth;

    @JsonProperty("thumbHeight")
    private String thumbHeight;

    @JsonProperty("siteRating")
    private Double siteRating;

    @JsonProperty("siteRatingCount")
    private Long siteRatingCount;

    @JsonProperty("isMovie")
    private Long isMovie;

    @JsonProperty("id")
    public Long getId() {
      return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
      this.id = id;
    }

    @JsonProperty("airedSeason")
    public Long getAiredSeason() {
      return airedSeason;
    }

    @JsonProperty("airedSeason")
    public void setAiredSeason(Long airedSeason) {
      this.airedSeason = airedSeason;
    }

    @JsonProperty("airedSeasonID")
    public Long getAiredSeasonId() {
      return airedSeasonId;
    }

    @JsonProperty("airedSeasonID")
    public void setAiredSeasonId(Long airedSeasonId) {
      this.airedSeasonId = airedSeasonId;
    }

    @JsonProperty("airedEpisodeNumber")
    public Long getAiredEpisodeNumber() {
      return airedEpisodeNumber;
    }

    @JsonProperty("airedEpisodeNumber")
    public void setAiredEpisodeNumber(Long airedEpisodeNumber) {
      this.airedEpisodeNumber = airedEpisodeNumber;
    }

    @JsonProperty("episodeName")
    public String getEpisodeName() {
      return episodeName;
    }

    @JsonProperty("episodeName")
    public void setEpisodeName(String episodeName) {
      this.episodeName = episodeName;
    }

    @JsonProperty("firstAired")
    public String getFirstAired() {
      return firstAired;
    }

    @JsonProperty("firstAired")
    public void setFirstAired(String firstAired) {
      this.firstAired = firstAired;
    }

    @JsonProperty("guestStars")
    public List<String> getGuestStars() {
      return guestStars;
    }

    @JsonProperty("guestStars")
    public void setGuestStars(List<String> guestStars) {
      this.guestStars = guestStars;
    }

    @JsonProperty("directors")
    public List<String> getDirectors() {
      return directors;
    }

    @JsonProperty("directors")
    public void setDirectors(List<String> directors) {
      this.directors = directors;
    }

    @JsonProperty("writers")
    public List<String> getWriters() {
      return writers;
    }

    @JsonProperty("writers")
    public void setWriters(List<String> writers) {
      this.writers = writers;
    }

    @JsonProperty("overview")
    public String getOverview() {
      return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
      this.overview = overview;
    }

    @JsonProperty("language")
    public Language getLanguage() {
      return language;
    }

    @JsonProperty("language")
    public void setLanguage(Language language) {
      this.language = language;
    }

    @JsonProperty("productionCode")
    public String getProductionCode() {
      return productionCode;
    }

    @JsonProperty("productionCode")
    public void setProductionCode(String productionCode) {
      this.productionCode = productionCode;
    }

    @JsonProperty("showUrl")
    public String getShowUrl() {
      return showUrl;
    }

    @JsonProperty("showUrl")
    public void setShowUrl(String showUrl) {
      this.showUrl = showUrl;
    }

    @JsonProperty("lastUpdated")
    public Long getLastUpdated() {
      return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(Long lastUpdated) {
      this.lastUpdated = lastUpdated;
    }

    @JsonProperty("dvdDiscid")
    public String getDvdDiscId() {
      return dvdDiscId;
    }

    @JsonProperty("dvdDiscid")
    public void setDvdDiscId(String dvdDiscId) {
      this.dvdDiscId = dvdDiscId;
    }

    @JsonProperty("dvdSeason")
    public Long getDvdSeason() {
      return dvdSeason;
    }

    @JsonProperty("dvdSeason")
    public void setDvdSeason(Long dvdSeason) {
      this.dvdSeason = dvdSeason;
    }

    @JsonProperty("dvdEpisodeNumber")
    public Long getDvdEpisodeNumber() {
      return dvdEpisodeNumber;
    }

    @JsonProperty("dvdEpisodeNumber")
    public void setDvdEpisodeNumber(Long dvdEpisodeNumber) {
      this.dvdEpisodeNumber = dvdEpisodeNumber;
    }

    @JsonProperty("dvdChapter")
    public Long getDvdChapter() {
      return dvdChapter;
    }

    @JsonProperty("dvdChapter")
    public void setDvdChapter(Long dvdChapter) {
      this.dvdChapter = dvdChapter;
    }

    @JsonProperty("absoluteNumber")
    public Long getAbsoluteNumber() {
      return absoluteNumber;
    }

    @JsonProperty("absoluteNumber")
    public void setAbsoluteNumber(Long absoluteNumber) {
      this.absoluteNumber = absoluteNumber;
    }

    @JsonProperty("filename")
    public String getFilename() {
      return filename;
    }

    @JsonProperty("filename")
    public void setFilename(String filename) {
      this.filename = filename;
    }

    @JsonProperty("seriesId")
    public Long getSeriesId() {
      return seriesId;
    }

    @JsonProperty("seriesId")
    public void setSeriesId(Long seriesId) {
      this.seriesId = seriesId;
    }

    @JsonProperty("lastUpdatedBy")
    public Long getLastUpdatedBy() {
      return lastUpdatedBy;
    }

    @JsonProperty("lastUpdatedBy")
    public void setLastUpdatedBy(Long lastUpdatedBy) {
      this.lastUpdatedBy = lastUpdatedBy;
    }

    @JsonProperty("airsAfterSeason")
    public Long getAirsAfterSeason() {
      return airsAfterSeason;
    }

    @JsonProperty("airsAfterSeason")
    public void setAirsAfterSeason(Long airsAfterSeason) {
      this.airsAfterSeason = airsAfterSeason;
    }

    @JsonProperty("airsBeforeSeason")
    public Long getAirsBeforeSeason() {
      return airsBeforeSeason;
    }

    @JsonProperty("airsBeforeSeason")
    public void setAirsBeforeSeason(Long airsBeforeSeason) {
      this.airsBeforeSeason = airsBeforeSeason;
    }

    @JsonProperty("airsBeforeEpisode")
    public Long getAirsBeforeEpisode() {
      return airsBeforeEpisode;
    }

    @JsonProperty("airsBeforeEpisode")
    public void setAirsBeforeEpisode(Long airsBeforeEpisode) {
      this.airsBeforeEpisode = airsBeforeEpisode;
    }

    @JsonProperty("imdbId")
    public String getImdbId() {
      return imdbId;
    }

    @JsonProperty("imdbId")
    public void setImdbId(String imdbId) {
      this.imdbId = imdbId;
    }

    @JsonProperty("contentRating")
    public String getContentRating() {
      return contentRating;
    }

    @JsonProperty("contentRating")
    public void setContentRating(String contentRating) {
      this.contentRating = contentRating;
    }

    @JsonProperty("thumbAuthor")
    public Long getThumbAuthor() {
      return thumbAuthor;
    }

    @JsonProperty("thumbAuthor")
    public void setThumbAuthor(Long thumbAuthor) {
      this.thumbAuthor = thumbAuthor;
    }

    @JsonProperty("thumbAdded")
    public String getThumbAdded() {
      return thumbAdded;
    }

    @JsonProperty("thumbAdded")
    public void setThumbAdded(String thumbAdded) {
      this.thumbAdded = thumbAdded;
    }

    @JsonProperty("thumbWidth")
    public String getThumbWidth() {
      return thumbWidth;
    }

    @JsonProperty("thumbWidth")
    public void setThumbWidth(String thumbWidth) {
      this.thumbWidth = thumbWidth;
    }

    @JsonProperty("thumbHeight")
    public String getThumbHeight() {
      return thumbHeight;
    }

    @JsonProperty("thumbHeight")
    public void setThumbHeight(String thumbHeight) {
      this.thumbHeight = thumbHeight;
    }

    @JsonProperty("siteRating")
    public Double getSiteRating() {
      return siteRating;
    }

    @JsonProperty("siteRating")
    public void setSiteRating(Double siteRating) {
      this.siteRating = siteRating;
    }

    @JsonProperty("siteRatingCount")
    public Long getSiteRatingCount() {
      return siteRatingCount;
    }

    @JsonProperty("siteRatingCount")
    public void setSiteRatingCount(Long siteRatingCount) {
      this.siteRatingCount = siteRatingCount;
    }

    @JsonProperty("isMovie")
    public Long getIsMovie() {
      return isMovie;
    }

    @JsonProperty("isMovie")
    public void setIsMovie(Long isMovie) {
      this.isMovie = isMovie;
    }

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this);
    }
  }
}
