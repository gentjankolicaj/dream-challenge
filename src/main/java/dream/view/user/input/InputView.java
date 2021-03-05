package dream.view.user.input;

import dream.App;

import javax.swing.*;
import java.awt.*;

public class InputView extends JPanel {
    private final GridLayout gridLayout;
    private InputFieldView inputFieldView;
    private InputButtonView inputButtonView;

    public InputView() {
        super();
        this.gridLayout = new GridLayout(2, 1);
        this.inputFieldView = new InputFieldView(new FieldView("Nr choices :", App.choiceNumber), new FieldView("Nr choice set :", App.choiceSetNumber), new FieldView("Rand choice set :", App.randomChoiceSetNumber));
        this.inputButtonView = new InputButtonView();

        this.add(inputFieldView);
        this.add(inputButtonView);
        this.setLayout(gridLayout);
    }


    public InputFieldView getInputFieldView() {
        return inputFieldView;
    }

    public void setInputFieldView(InputFieldView inputFieldView) {
        this.inputFieldView = inputFieldView;
    }

    public InputButtonView getInputButtonView() {
        return inputButtonView;
    }

    public void setInputButtonView(InputButtonView inputButtonView) {
        this.inputButtonView = inputButtonView;
    }
}
