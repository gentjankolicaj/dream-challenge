package dream.view.user.input;

import javax.swing.*;
import java.awt.*;

public class InputButtonView extends JPanel {
    private final GridLayout gridLayout;
    private JButton generateButton;
    private final JButton searchMatchButton;
    private JButton exportDataButton;

    public InputButtonView() {
        super();
        this.gridLayout = new GridLayout(1, 3);
        this.gridLayout.setHgap(5);
        this.gridLayout.setVgap(40);
        this.generateButton = new JButton("Generate");
        this.exportDataButton = new JButton("Export");
        this.searchMatchButton = new JButton("Search match");

        this.add(generateButton);
        this.add(searchMatchButton);
        this.add(exportDataButton);

        this.setLayout(gridLayout);
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public void setGenerateButton(JButton generateButton) {
        this.generateButton = generateButton;
    }

    public JButton getExportDataButton() {
        return exportDataButton;
    }

    public void setExportDataButton(JButton exportDataButton) {
        this.exportDataButton = exportDataButton;
    }


}
