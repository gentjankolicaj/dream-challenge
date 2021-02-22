package dream.view.listener;

import dream.view.chance.ChanceAreaView;
import dream.view.chance.ChanceView;
import dream.view.user.input.FieldView;
import dream.view.user.input.InputView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateButtonListener implements ActionListener {
    private final ChanceView chanceView;
    private final InputView inputView;

    public GenerateButtonListener(ChanceView chanceView, InputView inputView) {
        this.chanceView = chanceView;
        this.inputView = inputView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
