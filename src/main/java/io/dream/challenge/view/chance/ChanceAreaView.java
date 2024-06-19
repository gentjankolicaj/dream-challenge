package io.dream.challenge.view.chance;

import io.dream.challenge.element.Choice;
import io.dream.challenge.element.ChoiceSet;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ChanceAreaView extends JPanel {

  private final ChoiceSet choiceSet;
  private final GridLayout gridLayout;

  public ChanceAreaView(int choiceNumber) {
    super();
    this.gridLayout = new GridLayout(choiceNumber, choiceNumber);
    this.choiceSet = new ChoiceSet(true, choiceNumber);
    this.setLayout(gridLayout);
    this.setBorder(BorderFactory.createLineBorder(Color.black));
    this.addChoiceSet();
  }


  private void addChoiceSet() {
    io.dream.challenge.element.Choice[][] choices = choiceSet.getChoices();
    for (io.dream.challenge.element.Choice[] array : choices) {
      for (Choice choice : array) {
        //Set horizontal alignment for radio buttons
        choice.setHorizontalAlignment(JRadioButton.CENTER);
        this.add(choice);
      }
    }

  }


  public ChoiceSet getChoiceSet() {
    return choiceSet;
  }
}
