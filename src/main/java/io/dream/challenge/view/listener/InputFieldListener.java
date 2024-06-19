package io.dream.challenge.view.listener;

import io.dream.challenge.Application;
import io.dream.challenge.view.user.UserView;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InputFieldListener implements DocumentListener {

  private final UserView userView;
  private final JTextField choiceField;
  private final JTextField choiceSetField;

  public InputFieldListener(UserView userView, JTextField choiceField, JTextField choiceSetField) {
    super();
    this.userView = userView;
    this.choiceField = choiceField;
    this.choiceSetField = choiceSetField;

  }

  @Override
  public void insertUpdate(DocumentEvent e) {
    performUpdate();
  }

  @Override
  public void removeUpdate(DocumentEvent e) {
    performUpdate();
  }

  @Override
  public void changedUpdate(DocumentEvent e) {
    performUpdate();
  }


  private void performUpdate() {
    String content0 = choiceField.getText();
    int nrChoices = 0;
    int nrChoiceSet = 0;
    try {
      nrChoices = Integer.parseInt(content0);
      Application.choiceNumber = nrChoices;
    } catch (Exception ex) {
      Application.choiceNumber = 0;
    }

    String content1 = choiceSetField.getText();
    try {
      nrChoiceSet = Integer.parseInt(content1);
      Application.choiceSetNumber = nrChoiceSet;
    } catch (Exception ex) {
      Application.choiceSetNumber = 0;
    }
    userView.revalidateView(nrChoices, nrChoiceSet);
  }


}
