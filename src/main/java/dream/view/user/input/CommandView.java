package dream.view.user.input;

import javax.swing.*;

public class CommandView extends JPanel {
    private final BoxLayout boxLayout;
    private final JButton generateButton;
    private final JButton exportDataButton;
    private final JLabel nullLabel;

    public CommandView() {
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
}
