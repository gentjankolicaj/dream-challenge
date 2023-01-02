package dream.view.user.input;

import dream.Application;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class InputView extends JPanel {
    private final GridLayout gridLayout;
    private InputFieldView inputFieldView;
    private InputButtonView inputButtonView;

    public InputView() {
        super();
        this.gridLayout = new GridLayout(2, 1);
        this.inputFieldView = new InputFieldView(new FieldView("Nr choices :", Application.choiceNumber), new FieldView("Nr choice set :", Application.choiceSetNumber), new FieldView("Rand choice set :", Application.randomChoiceSetNumber));
        this.inputButtonView = new InputButtonView();

        this.add(inputFieldView);
        this.add(inputButtonView);
        this.setLayout(gridLayout);
    }

}
