package com.dnsimple.response;

import com.google.api.client.util.Key;

public class RejectPushResponse extends ApiResponse {
  @Key("data")
  private Object data;

  public Object getData() {
    return data;
  }
}
