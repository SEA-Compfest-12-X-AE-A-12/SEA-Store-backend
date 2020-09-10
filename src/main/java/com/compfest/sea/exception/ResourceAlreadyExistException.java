package com.compfest.sea.exception;

public class ResourceAlreadyExistException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ResourceAlreadyExistException(String resource) {
    super(resource);
  }
}
