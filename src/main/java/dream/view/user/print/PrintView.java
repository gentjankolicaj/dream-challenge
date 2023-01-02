package dream.view.user.print;

import dream.view.ParentView;

import javax.swing.*;
import java.time.LocalDateTime;

public class PrintView extends ParentView {
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

    public void printText(String content) {
        textArea.append(LocalDateTime.now() + " : " + content + "\n");
    }
}
