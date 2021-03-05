package dream.view.user.input;

import javax.swing.*;
import java.awt.*;

public class FieldView extends JPanel {
    private final GridLayout gridLayout;
    private JLabel label;
    private JTextField textField;

    public FieldView(String labelText, int defaultValue) {
        super();
        this.gridLayout = new GridLayout(2, 1);
        this.label = new JLabel(labelText);
        this.textField = new JTextField();

        //Initial default value is 2
        this.textField.setText(String.valueOf(defaultValue));


        this.add(label);
        this.add(textField);

        this.setLayout(gridLayout);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }


}
