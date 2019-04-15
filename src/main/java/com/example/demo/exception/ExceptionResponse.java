package com.example.demo.exception;

public class ExceptionResponse {
//  private Date timestamp;
  private String message;
  private String details;
  private int httpCode;

  public ExceptionResponse(String message, String details, int httpCode) {
    super();
  //  this.timestamp = timestamp;
    this.message = message;
    this.details = details;
    this.httpCode = httpCode;
  }

  /*public Date getTimestamp() {
    return timestamp;
  }*/

  public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }

  public int getHttpCode() {
    return httpCode;
  }
}