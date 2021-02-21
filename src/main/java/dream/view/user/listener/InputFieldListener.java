package dream.view.user.listener;

import dream.App;
import dream.view.user.UserView;
import dream.view.user.input.InputView;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputFieldListener implements KeyListener {

    private final InputView inputView;
    private final UserView userView;

    private final JTextField choiceField;
    private final JTextField choiceSetField;

    public InputFieldListener(UserView userView, InputView inputView) {
        super();
        this.userView = userView;
        this.inputView = inputView;

        //Get text fields
        this.choiceField = inputView.getInputFieldView().getFieldViews()[0].getTextField();
        this.choiceSetField = inputView.getInputFieldView().getFieldViews()[1].getTextField();

        //Add listener to text fields
        choiceField.addKeyListener(this);
        choiceSetField.addKeyListener(this);
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
