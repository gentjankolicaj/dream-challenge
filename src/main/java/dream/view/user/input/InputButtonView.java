package dream.view.user.input;

import javax.swing.*;

public class InputButtonView extends JPanel {
    private final BoxLayout boxLayout;
    private JButton generateButton;
    private JButton exportDataButton;
    private JLabel nullLabel;

    public InputButtonView() {
        super();
        this.boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.generateButton = new JButton("Generate");
        this.exportDataButton = new JButton("Export data");
        this.nullLabel = new JLabel();

        this.add(generateButton);
        this.add(nullLabel);
        this.add(exportDataButton);

        this.setLayout(boxLayout);
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public void setGenerateButton(JButton generateButton) {
        this.generateButton = generateButton;
    }

    public JButton getExportDataButton() {
        return exportDataButton;
    }

    public void setExportDataButton(JButton exportDataButton) {
        this.exportDataButton = exportDataButton;
    }

    public JLabel getNullLabel() {
        return nullLabel;
    }

    public void setNullLabel(JLabel nullLabel) {
        this.nullLabel = nullLabel;
    }
}
