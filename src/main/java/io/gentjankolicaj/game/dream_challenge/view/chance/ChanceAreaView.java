package io.gentjankolicaj.game.dream_challenge.view.chance;

import io.gentjankolicaj.game.dream_challenge.element.Choice;
import io.gentjankolicaj.game.dream_challenge.element.ChoiceSet;

import javax.swing.*;
import java.awt.*;

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
        Choice[][] choices = choiceSet.getChoices();
        for (Choice[] array : choices)
            for (Choice choice : array) {
                //Set horizontal alignment for radio buttons
                choice.setHorizontalAlignment(JRadioButton.CENTER);
                this.add(choice);
            }

    }


    public ChoiceSet getChoiceSet() {
        return choiceSet;
    }
}
