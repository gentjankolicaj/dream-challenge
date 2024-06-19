package io.dream.challenge.view.user.print;

import io.dream.challenge.view.ParentView;
import java.time.LocalDateTime;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
