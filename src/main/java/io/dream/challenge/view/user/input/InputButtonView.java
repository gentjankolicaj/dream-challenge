package io.dream.challenge.view.user.input;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import lombok.Getter;

@Getter
public class InputButtonView extends JPanel {

  private final GridLayout gridLayout;
  private final JButton generateButton;
  private final JButton searchButton;
  private final JButton exportButton;
  private final JButton clearButton;

  public InputButtonView() {
    super();
    this.gridLayout = new GridLayout(2, 4);
    this.gridLayout.setHgap(5);
    this.gridLayout.setVgap(5);
    this.setLayout(gridLayout);

    this.generateButton = new JButton("Generate sets");
    this.searchButton = new JButton("Search match");
    this.exportButton = new JButton("Export results");
    this.clearButton = new JButton("Clear console");

    this.add(generateButton);
    this.add(searchButton);
    this.add(exportButton);
    this.add(clearButton);

  }
}
