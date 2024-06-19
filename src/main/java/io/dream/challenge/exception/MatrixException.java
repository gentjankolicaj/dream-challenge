package io.dream.challenge.exception;

import io.dream.challenge.element.Choice;

public class MatrixException extends RuntimeException {

  private final Choice[][] userChoices;
  private final Choice[][] randomChoices;

  public MatrixException(String s, Choice[][] userChoices, Choice[][] randomChoices) {
    super(s);
    this.userChoices = userChoices;
    this.randomChoices = randomChoices;
  }

  @Override
  public String getMessage() {
    String message = super.getMessage();
    message =
        message + " Choice matrix dim : [" + userChoices.length + "," + userChoices[0].length + "]";
    message =
        message + " Rand matrix dim : [" + randomChoices.length + "," + randomChoices[0].length
            + "]";
    return message;
  }
}
