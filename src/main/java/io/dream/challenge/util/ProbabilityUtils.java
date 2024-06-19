package io.dream.challenge.util;

public class ProbabilityUtils {

  private ProbabilityUtils() {
  }

  public static boolean isSelected() {
    int maxBorder = (int) (Math.random() * 10);
    int randVal = (int) (Math.random() * 10);
    return randVal >= 0 && randVal <= maxBorder;
  }
}
