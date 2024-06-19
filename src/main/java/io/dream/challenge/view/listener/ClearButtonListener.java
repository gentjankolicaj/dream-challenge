package io.dream.challenge.view.listener;

import io.dream.challenge.view.user.UserView;
import io.dream.challenge.view.user.print.PrintView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class ClearButtonListener implements ActionListener {

  private final UserView userView;

  public ClearButtonListener(UserView userView) {
    this.userView = userView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    perform();
  }

  private void perform() {
    PrintView printView = userView.getPrintView();
    JTextArea jTextArea = printView.getTextArea();
    jTextArea.setText("");
  }
}
