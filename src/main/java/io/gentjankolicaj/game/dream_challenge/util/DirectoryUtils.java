package io.gentjankolicaj.game.dream_challenge.util;

import io.gentjankolicaj.game.dream_challenge.exception.ChoiceException;

import javax.swing.*;
import java.io.File;

public class DirectoryUtils {

    private DirectoryUtils() {
    }

    public static String chooseDirectory(JPanel jPanel) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("user.directory"));
        jFileChooser.setDialogTitle("Choose file destination directory");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.setAcceptAllFileFilterUsed(false);

        jFileChooser.setApproveButtonText("Save");
        jFileChooser.setApproveButtonToolTipText("Save file at...");

        if (jFileChooser.showOpenDialog(jPanel) == JFileChooser.APPROVE_OPTION) {
            return jFileChooser.getSelectedFile().getPath();
        } else
            throw new ChoiceException("Directory not chosen.");
    }

}
