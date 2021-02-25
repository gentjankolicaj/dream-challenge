package dream.view.listener;

import dream.App;
import dream.view.user.UserView;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputFieldListener implements KeyListener {
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
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
        String content0 = choiceField.getText();
        int nrChoices = 0;
        int nrChoiceSet = 0;
        try {
            nrChoices = Integer.parseInt(content0);
            App.choiceNumber = nrChoices;
            System.out.println("Nr choice : " + nrChoices);
        } catch (Exception ex) {
            App.choiceNumber = 0;
            ex.printStackTrace();
        }

        String content1 = choiceSetField.getText();
        try {
            nrChoiceSet = Integer.parseInt(content1);
            App.choiceSetNumber = nrChoiceSet;
            System.out.println("Nr choiceSet : " + nrChoiceSet);
        } catch (Exception ex) {
            App.choiceSetNumber = 0;
            ex.printStackTrace();
        }

        userView.revalidateUserView(nrChoices, nrChoiceSet);
    }


}
