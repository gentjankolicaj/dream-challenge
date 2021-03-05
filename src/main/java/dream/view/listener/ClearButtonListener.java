package dream.view.listener;

import dream.view.user.UserView;
import dream.view.user.print.PrintView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
