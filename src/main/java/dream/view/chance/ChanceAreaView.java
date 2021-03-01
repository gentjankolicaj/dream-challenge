package dream.view.chance;

import dream.element.Choice;
import dream.element.ChoiceSet;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ChanceAreaView extends JPanel {
    private final ChoiceSet choiceSet;
    private final GridLayout gridLayout;
    private final Border border;

    public ChanceAreaView(int choiceNumber) {
        super();
        this.gridLayout = new GridLayout(choiceNumber, choiceNumber);
        this.choiceSet = new ChoiceSet(true, choiceNumber);
        this.border = BorderFactory.createLineBorder(Color.black);
        this.setBorder(border);

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
