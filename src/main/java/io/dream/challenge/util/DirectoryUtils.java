package io.dream.challenge.util;

import io.dream.challenge.exception.ChoiceException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

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
    } else {
      throw new ChoiceException("Directory not chosen.");
    }
  }

}
