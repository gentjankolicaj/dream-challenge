package dream.view.listener;

import dream.view.user.UserView;
import dream.view.user.print.PrintView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class SearchButtonListener implements ActionListener {
    private final UserView userView;

    public SearchButtonListener(UserView userView) {
        this.userView = userView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private void print(String str) {
        PrintView printView = userView.getPrintView();
        JTextArea jTextArea = printView.getTextArea();
        jTextArea.append(LocalDateTime.now() + " : " + str + "\n");
    }
}
