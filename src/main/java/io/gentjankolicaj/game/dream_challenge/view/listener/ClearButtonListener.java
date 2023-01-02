package io.gentjankolicaj.game.dream_challenge.view.listener;

import io.gentjankolicaj.game.dream_challenge.view.user.UserView;
import io.gentjankolicaj.game.dream_challenge.view.user.print.PrintView;

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
