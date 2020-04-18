package com.filemanager.api;

import com.filemanager.entity.response.SeriesEpisodesResponse;
import com.filemanager.entity.response.SeriesSearchResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TvDbClientTest {

  private TvDbClient tvDbClient;

  @BeforeEach
  public void setup() {
    tvDbClient = new TvDbClient();
  }

  @AfterEach
  public void teardown() {
    if (tvDbClient != null) {
      tvDbClient.close();
    }
  }

  @Test
  public void getTokenTest1() {
    String token = tvDbClient.getToken();
    assertNotNull(token);
  }

  @Test
  public void getTokenTest2() {
    String token1 = tvDbClient.getToken();
    String token2 = tvDbClient.getToken();
    assertEquals(token1, token2);
  }

  @Test
  public void searchSeriesTest1() {
    SeriesSearchResponse seriesSearchResponse = tvDbClient.seriesSearch("Naruto");
    assertNotNull(seriesSearchResponse);

    List<SeriesSearchResponse.SeriesSearchResult> seriesSearchResults =
        seriesSearchResponse.getData();
    assertNotNull(seriesSearchResults);
    assertFalse(seriesSearchResults.isEmpty());
  }

  @Test
  public void seriesEpisodesTest1() {
    SeriesEpisodesResponse seriesEpisodesResponse = tvDbClient.seriesEpisodes(79089);
    assertNotNull(seriesEpisodesResponse);

    List<SeriesEpisodesResponse.SeriesEpisodesResult> seriesEpisodesResults =
        seriesEpisodesResponse.getData();
    assertNotNull(seriesEpisodesResults);
    assertFalse(seriesEpisodesResults.isEmpty());
  }

  @Test
  public void findAllSeriesEpisodesTest1() {
    List<SeriesEpisodesResponse.SeriesEpisodesResult> seriesEpisodesResults =
        tvDbClient.findAllSeriesEpisodes(78490);
    assertEquals(130, seriesEpisodesResults.size());
  }
}
