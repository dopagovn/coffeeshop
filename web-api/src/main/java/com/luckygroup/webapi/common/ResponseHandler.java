package com.luckygroup.webapi.common;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

  public static ResponseEntity<Object> generateResponse(
    HttpStatus code,
    String status,
    Object res
  ) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("status", status);
    map.put("code", code.value());
    map.put("message", code.name());
    map.put("data", res);

    return new ResponseEntity<Object>(map, code);
  }
}
