package dream.view.user.input;

import javax.swing.*;
import java.awt.*;

public class InputButtonView extends JPanel {
    private final GridBagLayout gridBagLayout;
    private final GridBagConstraints gridBagConstraints;
    private final JButton generateButton;
    private final JButton searchButton;
    private final JButton exportButton;

    public InputButtonView() {
        super();
        this.gridBagLayout = new GridBagLayout();
        this.gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridBagLayout);

        this.generateButton = new JButton("Generate");
        this.exportButton = new JButton("Export to pdf");
        this.searchButton = new JButton("Search match");

        this.gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.gridBagConstraints.gridx = 0;
        this.gridBagConstraints.gridy = 0;
        this.add(generateButton, gridBagConstraints);

        this.gridBagConstraints.gridx = 1;
        this.gridBagConstraints.gridy = 0;
        this.add(searchButton, gridBagConstraints);


        this.gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.gridBagConstraints.gridx = 0;
        this.gridBagConstraints.gridy = 1;
        this.add(exportButton, gridBagConstraints);

    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JButton getExportDataButton() {
        return exportButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
