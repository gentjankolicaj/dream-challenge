package io.dream.challenge.view.user.input;

import io.dream.challenge.Application;
import java.awt.GridLayout;
import javax.swing.JPanel;
import lombok.Getter;

@Getter
public class InputView extends JPanel {

  private final GridLayout gridLayout;
  private final InputFieldView inputFieldView;
  private final InputButtonView inputButtonView;

  public InputView() {
    super();
    this.gridLayout = new GridLayout(2, 1);
    this.inputFieldView = new InputFieldView(
        new FieldView("Nr choices :", Application.choiceNumber),
        new FieldView("Nr choice set :", Application.choiceSetNumber),
        new FieldView("Rand choice set :", Application.randomChoiceSetNumber));
    this.inputButtonView = new InputButtonView();

    this.add(inputFieldView);
    this.add(inputButtonView);
    this.setLayout(gridLayout);
  }

}
