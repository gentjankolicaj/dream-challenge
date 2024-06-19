package io.dream.challenge.view.chance;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;


public class ChanceSubView extends JPanel {

  private final ChanceAreaView[] chanceAreaViews;
  private GridLayout gridLayout;

  public ChanceSubView(int choiceNumber, int randSetNumber) {
    this.chanceAreaViews = new ChanceAreaView[randSetNumber];
    for (int i = 0; i < randSetNumber; i++) {
      this.chanceAreaViews[i] = new ChanceAreaView(choiceNumber);
    }

    this.addChanceAreas();
  }

  private static int getRows(ChanceAreaView[] chanceAreaViews) {
    if (chanceAreaViews != null && chanceAreaViews.length != 0) {
      int length = chanceAreaViews.length;
      int sqrt = (int) Math.sqrt(length);
      while ((sqrt * sqrt) <= (length)) {
        sqrt = sqrt + 1;
      }
      return sqrt;
    } else {
      return 0;
    }

  }

  private static int getColumns(ChanceAreaView[] chanceAreaViews) {
    if (chanceAreaViews != null && chanceAreaViews.length != 0) {
      return (int) Math.sqrt(chanceAreaViews.length);
    } else {
      return 0;
    }
  }

  private void addChanceAreas() {
    int rows = getRows(chanceAreaViews);
    int columns = getColumns(chanceAreaViews);
    this.gridLayout = new GridLayout(rows, columns);
    this.gridLayout.setVgap(5);
    this.gridLayout.setHgap(5);
    this.setLayout(gridLayout);
    for (ChanceAreaView chanceAreaView : this.chanceAreaViews) {
      this.add(chanceAreaView, BorderLayout.CENTER);
    }
  }

  public ChanceAreaView[] getChanceAreaViews() {
    return chanceAreaViews;
  }

}
