package dream.view.user.print;

import javax.swing.*;

public class PrintView extends JPanel {
    private final BoxLayout boxLayout;
    private final JScrollPane jScrollPane;
    private final JTextArea textArea;


    public PrintView() {
        super();
        this.boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.textArea = new JTextArea();
        this.jScrollPane = new JScrollPane(textArea);

        this.add(jScrollPane);
        this.setLayout(boxLayout);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
