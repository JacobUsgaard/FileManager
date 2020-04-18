package com.filemanager.entity.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginResponse {

  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
