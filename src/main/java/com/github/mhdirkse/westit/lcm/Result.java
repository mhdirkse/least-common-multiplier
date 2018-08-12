package com.github.mhdirkse.westit.lcm;

public class Result {

  public String message;

  public Result() {};

  public Result(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
