package com.step.exception;

public class UnequalMatricesDimensionException extends Exception {
  private String message;

  public UnequalMatricesDimensionException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
