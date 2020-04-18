package com.filemanager.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"first", "last", "next", "prev"})
public class Links {

  @JsonProperty("first")
  private Long first;

  @JsonProperty("last")
  private Long last;

  @JsonProperty("next")
  private Long next;

  @JsonProperty("prev")
  private Long previous;

  @JsonProperty("first")
  public Long getFirst() {
    return first;
  }

  @JsonProperty("first")
  public void setFirst(Long first) {
    this.first = first;
  }

  @JsonProperty("last")
  public Long getLast() {
    return last;
  }

  @JsonProperty("last")
  public void setLast(Long last) {
    this.last = last;
  }

  @JsonProperty("next")
  public Long getNext() {
    return next;
  }

  @JsonProperty("next")
  public void setNext(Long next) {
    this.next = next;
  }

  @JsonProperty("prev")
  public Long getPrevious() {
    return previous;
  }

  @JsonProperty("prev")
  public void setPrevious(Long previous) {
    this.previous = previous;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
