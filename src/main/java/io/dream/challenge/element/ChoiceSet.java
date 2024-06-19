package io.dream.challenge.element;


import io.dream.challenge.util.ProbabilityUtils;

public class ChoiceSet {

  private final Choice[][] choices;

  public ChoiceSet(boolean randChoice, int choiceNumber) {
    super();
    if (randChoice) {
      this.choices = produceRandomChoices(choiceNumber);
    } else {
      this.choices = produceChoices(choiceNumber);
    }
  }


  public Choice[][] getChoices() {
    return this.choices;
  }

  private Choice[][] produceChoices(int numberOfChoices) {
    Choice[][] array = new Choice[numberOfChoices][numberOfChoices];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        array[i][j] = new Choice(false);
      }
    }
    return array;
  }

  private Choice[][] produceRandomChoices(int numberOfChoices) {
    Choice[][] array = new Choice[numberOfChoices][numberOfChoices];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        array[i][j] = new Choice(ProbabilityUtils.isSelected());

        //make radio button not enabled
        array[i][j].setEnabled(false);
      }
    }
    return array;
  }
}
