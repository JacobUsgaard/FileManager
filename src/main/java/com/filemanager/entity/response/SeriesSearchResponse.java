package com.filemanager.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data"})
public class SeriesSearchResponse {

  @JsonProperty("data")
  private List<SeriesSearchResult> data;

  @JsonProperty("data")
  public List<SeriesSearchResult> getData() {
    return data;
  }

  @JsonProperty("data")
  public void setData(List<SeriesSearchResult> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonPropertyOrder({
    "aliases",
    "banner",
    "firstAired",
    "id",
    "image",
    "network",
    "overview",
    "poster",
    "seriesName",
    "slug",
    "status"
  })
  public static class SeriesSearchResult {

    @JsonProperty("aliases")
    private List<String> aliases;

    @JsonProperty("banner")
    private String banner;

    @JsonProperty("firstAired")
    private String firstAired;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("image")
    private String image;

    @JsonProperty("network")
    private String network;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("poster")
    private String poster;

    @JsonProperty("seriesName")
    private String seriesName;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("status")
    private String status;

    @JsonProperty("aliases")
    public List<String> getAliases() {
      return aliases;
    }

    @JsonProperty("aliases")
    public void setAliases(List<String> aliases) {
      this.aliases = aliases;
    }

    @JsonProperty("banner")
    public String getBanner() {
      return banner;
    }

    @JsonProperty("banner")
    public void setBanner(String banner) {
      this.banner = banner;
    }

    @JsonProperty("firstAired")
    public String getFirstAired() {
      return firstAired;
    }

    @JsonProperty("firstAired")
    public void setFirstAired(String firstAired) {
      this.firstAired = firstAired;
    }

    @JsonProperty("id")
    public Long getId() {
      return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
      this.id = id;
    }

    @JsonProperty("image")
    public String getImage() {
      return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
      this.image = image;
    }

    @JsonProperty("network")
    public String getNetwork() {
      return network;
    }

    @JsonProperty("network")
    public void setNetwork(String network) {
      this.network = network;
    }

    @JsonProperty("overview")
    public String getOverview() {
      return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
      this.overview = overview;
    }

    @JsonProperty("poster")
    public String getPoster() {
      return poster;
    }

    @JsonProperty("poster")
    public void setPoster(String poster) {
      this.poster = poster;
    }

    @JsonProperty("seriesName")
    public String getSeriesName() {
      return seriesName;
    }

    @JsonProperty("seriesName")
    public void setSeriesName(String seriesName) {
      this.seriesName = seriesName;
    }

    @JsonProperty("slug")
    public String getSlug() {
      return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
      this.slug = slug;
    }

    @JsonProperty("status")
    public String getStatus() {
      return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
      this.status = status;
    }

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this);
    }
  }
}
