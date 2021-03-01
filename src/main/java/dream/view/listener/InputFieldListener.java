package dream.view.listener;

import dream.App;
import dream.view.user.UserView;

import javax.swing.*;
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
            App.choiceNumber = nrChoices;
        } catch (Exception ex) {
            App.choiceNumber = 0;
        }

        String content1 = choiceSetField.getText();
        try {
            nrChoiceSet = Integer.parseInt(content1);
            App.choiceSetNumber = nrChoiceSet;
        } catch (Exception ex) {
            App.choiceSetNumber = 0;
        }
        userView.revalidateView(nrChoices, nrChoiceSet);
    }


}
