package dream.view.chance;

import dream.element.Choice;
import dream.element.ChoiceSet;

import javax.swing.*;
import java.awt.*;

public class ChanceAreaView extends JPanel {
    private final ChoiceSet choiceSet;
    private final GridLayout gridLayout;

    public ChanceAreaView(int choiceNumber) {
        super();
        this.gridLayout = new GridLayout(choiceNumber, choiceNumber);
        this.choiceSet = new ChoiceSet(true, choiceNumber);

        addChoiceSet();
        this.setLayout(gridLayout);
    }


    private void addChoiceSet() {
        Choice[][] choices = choiceSet.getChoices();
        for (Choice[] array : choices)
            for (Choice choice : array)
                this.add(choice);

    }

}
