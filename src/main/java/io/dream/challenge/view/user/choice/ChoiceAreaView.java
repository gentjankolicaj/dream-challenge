package io.dream.challenge.view.user.choice;

import io.dream.challenge.element.Choice;
import io.dream.challenge.element.ChoiceSet;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ChoiceAreaView extends JPanel {

  private final ChoiceSet choiceSet;
  private final GridLayout gridLayout;
  private final Border border;

  public ChoiceAreaView(int numberOfChoices) {
    super();
    this.gridLayout = new GridLayout(numberOfChoices, numberOfChoices);
    this.choiceSet = new ChoiceSet(false, numberOfChoices);
    this.border = BorderFactory.createLineBorder(Color.black);
    this.setBorder(border);

    this.addChoiceSet();
    this.setLayout(gridLayout);
  }


  private void addChoiceSet() {
    io.dream.challenge.element.Choice[][] choices = choiceSet.getChoices();
    for (io.dream.challenge.element.Choice[] array : choices) {
      for (Choice choice : array) {
        this.add(choice);
      }
    }

  }

  public ChoiceSet getChoiceSet() {
    return choiceSet;
  }
}
