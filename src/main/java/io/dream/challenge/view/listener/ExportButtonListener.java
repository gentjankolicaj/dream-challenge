package io.dream.challenge.view.listener;

import io.dream.challenge.util.DirectoryUtils;
import io.dream.challenge.util.PdfUtils;
import io.dream.challenge.view.chance.ChanceAreaView;
import io.dream.challenge.view.chance.ChanceSubView;
import io.dream.challenge.view.chance.ChanceView;
import io.dream.challenge.view.user.UserView;
import io.dream.challenge.view.user.choice.ChoiceAreaView;
import io.dream.challenge.view.user.choice.ChoiceView;
import io.dream.challenge.view.user.input.InputFieldView;
import io.dream.challenge.view.user.input.InputView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExportButtonListener implements ActionListener {

  private final UserView userView;
  private final ChanceView chanceView;

  public ExportButtonListener(UserView userView, ChanceView chanceView) {
    this.userView = userView;
    this.chanceView = chanceView;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    perform();
  }


  private void perform() {
    int[] inputArray = getInputValues();
    ChoiceAreaView[] choiceAreaViews = getChoiceAreaViews();
    JTextArea printArea = userView.getPrintView().getTextArea();

    ChanceAreaView[] chanceAreaViews = getChanceAreaViews();

    String destinationDirectory = DirectoryUtils.chooseDirectory(userView);

    PdfUtils.exportToPdf(destinationDirectory, inputArray, printArea, choiceAreaViews,
        chanceAreaViews);
  }


  private ChanceAreaView[] getChanceAreaViews() {
    ChanceSubView chanceSubView = chanceView.getChanceSubView();
    return chanceSubView.getChanceAreaViews();
  }

  private ChoiceAreaView[] getChoiceAreaViews() {
    ChoiceView choiceView = userView.getChoiceView();
    return choiceView.getChoiceAreaViews();
  }

  private int[] getInputValues() {
    InputView inputView = userView.getInputView();
    InputFieldView inputFieldView = inputView.getInputFieldView();
    int[] inputArray = new int[3];
    try {
      JTextField choiceField = inputFieldView.getFieldViews()[0].getTextField();
      JTextField setField = inputFieldView.getFieldViews()[1].getTextField();
      JTextField randomField = inputFieldView.getFieldViews()[2].getTextField();

      inputArray[0] = getValue(choiceField);
      inputArray[1] = getValue(setField);
      inputArray[2] = getValue(randomField);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return inputArray;
  }

  private int getValue(JTextField jTextField) {
    try {
      return Integer.parseInt(jTextField.getText());
    } catch (Exception e) {
      return -1;
    }
  }


}
