package io.dream.challenge.view.listener;

import io.dream.challenge.view.chance.ChanceView;
import io.dream.challenge.view.user.UserView;
import io.dream.challenge.view.user.input.FieldView;
import io.dream.challenge.view.user.input.InputView;
import io.dream.challenge.view.user.print.PrintView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GenerateButtonListener implements ActionListener {

  private final UserView userView;

  public GenerateButtonListener(UserView userView) {
    this.userView = userView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    perform();
  }

  private void perform() {
    //Get views
    InputView inputView = userView.getInputView();
    ChanceView chanceView = userView.getChanceView();

    FieldView[] fieldViews = inputView.getInputFieldView().getFieldViews();
    JTextField choiceField = fieldViews[0].getTextField();
    JTextField randChoiceSetField = fieldViews[2].getTextField();

    String choiceContent = choiceField.getText();
    String randSetContent = randChoiceSetField.getText();

    int choiceNumber = 0;
    int randSetNumber = 0;
    try {
      choiceNumber = Integer.parseInt(choiceContent);
      randSetNumber = Integer.parseInt(randSetContent);
      if (choiceNumber > 0 && randSetNumber > 0) {
        chanceView.updateView(choiceNumber, randSetNumber);
        print("--> Generated [ " + randSetNumber + " ] random sets.");
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  private void print(String str) {
    PrintView printView = userView.getPrintView();
    JTextArea jTextArea = printView.getTextArea();
    jTextArea.append(LocalDateTime.now() + " : " + str + "\n");
  }

}
