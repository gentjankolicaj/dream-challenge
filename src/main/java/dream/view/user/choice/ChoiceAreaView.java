package dream.view.user.choice;

import dream.element.Choice;
import dream.element.ChoiceSet;

import javax.swing.*;
import java.awt.*;

public class ChoiceAreaView extends JPanel {
    private final ChoiceSet choiceSet;
    private final GridLayout gridLayout;

    public ChoiceAreaView(int numberOfChoices) {
        super();
        this.gridLayout = new GridLayout(numberOfChoices, numberOfChoices);
        this.choiceSet = new ChoiceSet(false, numberOfChoices);

        addChoiceSet();
        this.setLayout(gridLayout);
    }


    private void addChoiceSet() {
        Choice[][] choices = choiceSet.getChoices();
        for (Choice[] array : choices)
            for (Choice choice : array)
                this.add(choice);

    }

    public ChoiceSet getChoiceSet() {
        return choiceSet;
    }
}
