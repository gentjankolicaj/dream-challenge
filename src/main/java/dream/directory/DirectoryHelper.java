package dream.directory;

import javax.swing.*;
import java.io.File;

public class DirectoryHelper {

    public static String chooseDirectory(JPanel jPanel) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("user.directory"));
        jFileChooser.setDialogTitle("Choose file destination directory");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.setAcceptAllFileFilterUsed(false);

        jFileChooser.setApproveButtonText("Save");
        jFileChooser.setApproveButtonToolTipText("Save file at...");

        if (jFileChooser.showOpenDialog(jPanel) == JFileChooser.APPROVE_OPTION) {
            /**  System.out.println("Current directory "+jFileChooser.getCurrentDirectory());
             System.out.println("Selected file "+jFileChooser.getSelectedFile());
             System.out.println("Choose mode "+jFileChooser.getFileSelectionMode());
             */
            return jFileChooser.getSelectedFile().getPath();
        } else
            return null;
    }

}
