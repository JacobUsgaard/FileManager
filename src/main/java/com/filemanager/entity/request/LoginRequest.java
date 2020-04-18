package com.filemanager.entity.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginRequest {

  private String apiKey;

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
