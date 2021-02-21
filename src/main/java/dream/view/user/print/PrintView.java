package dream.view.user.print;

import javax.swing.*;

public class PrintView extends JPanel {
    private final BoxLayout boxLayout;

    private final JScrollPane jScrollPane;
    private final JTextArea jTextArea;
    private final JLabel nullLabel;

    public PrintView() {
        super();
        this.boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.jTextArea = new JTextArea();
        this.jScrollPane = new JScrollPane(jTextArea);

        this.nullLabel = new JLabel();

        this.add(jScrollPane);
        this.add(nullLabel);

        this.setLayout(boxLayout);
    }
}
