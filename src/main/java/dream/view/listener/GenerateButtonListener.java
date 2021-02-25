package dream.view.listener;

import dream.view.chance.ChanceAreaView;
import dream.view.chance.ChanceView;
import dream.view.user.UserView;
import dream.view.user.input.FieldView;
import dream.view.user.input.InputView;
import dream.view.user.print.PrintView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class GenerateButtonListener implements ActionListener {
    private final UserView userView;

    public GenerateButtonListener(UserView userView) {
        this.userView = userView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Get views
        InputView inputView = userView.getInputView();
        ChanceView chanceView = userView.getChanceView();

        FieldView[] fieldViews = inputView.getInputFieldView().getFieldViews();
        JTextField choiceField = fieldViews[0].getTextField();
        JTextField randChoiceSetField = fieldViews[2].getTextField();

        String choiceContent = choiceField.getText();
        String randChoiceSetContent = randChoiceSetField.getText();

        int choiceValue = 0;
        int randChoiceSetValue = 0;
        try {
            choiceValue = Integer.parseInt(choiceContent);
            randChoiceSetValue = Integer.parseInt(randChoiceSetContent);
            if (choiceValue > 0 && randChoiceSetValue > 0) {
                ChanceAreaView[] chanceAreaViews = new ChanceAreaView[randChoiceSetValue];
                for (int i = 0; i < randChoiceSetValue; i++) {
                    chanceAreaViews[i] = new ChanceAreaView(choiceValue);
                }
                //todo to fix clean up view bug.
                chanceView.revalidateChanceView(chanceAreaViews);
                print("'Generate' pressed. " + randChoiceSetValue + " random samples generated.");
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
