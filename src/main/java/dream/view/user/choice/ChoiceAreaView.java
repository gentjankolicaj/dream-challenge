package dream.view.user.choice;

import dream.element.Choice;
import dream.element.ChoiceSet;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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
        Choice[][] choices = choiceSet.getChoices();
        for (Choice[] array : choices)
            for (Choice choice : array)
                this.add(choice);

    }

    public ChoiceSet getChoiceSet() {
        return choiceSet;
    }
}
