package com.compfest.sea.exception;

public class ResourceNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String resource) {
    super(resource);
  }
}
