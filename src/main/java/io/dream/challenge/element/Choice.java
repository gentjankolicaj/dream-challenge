package io.dream.challenge.element;

import javax.swing.JRadioButton;

public class Choice extends JRadioButton {

  public Choice() {
    super();
    setSelected(false);
  }

  public Choice(boolean isClicked) {
    super();
    setSelected(isClicked);
  }
}
