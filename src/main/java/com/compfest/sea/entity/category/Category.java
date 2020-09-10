package com.compfest.sea.entity.category;

public enum Category {
  AUTOMOTIVE,
  ELECTRONIC,
  FASHION,
  FNB,
  FURNITURE,
  HEALTH,
  SPORT,
  OTHERS;

  public static Boolean isValidCategory(String category) {
    try {
      Category.valueOf(category);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
