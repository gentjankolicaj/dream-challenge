package dream.view.chance;

import dream.view.ParentView;

import javax.swing.*;
import java.awt.*;

public class ChanceView extends ParentView {
    private ChanceSubView chanceSubView;
    private JScrollPane jScrollPane;

    public ChanceView(int choiceNumber, int randSetNumber) {
        super();
        //Initial chance components
        this.chanceSubView = new ChanceSubView(choiceNumber, randSetNumber);
        this.jScrollPane = new JScrollPane(chanceSubView);
        this.jScrollPane.setPreferredSize(new Dimension(450, 650));
        this.add(jScrollPane, BorderLayout.CENTER);
    }

    //update chance view with new components
    public void updateView(int choiceNumber, int randSetNumber) {
        this.remove(jScrollPane);

        this.chanceSubView = new ChanceSubView(choiceNumber, randSetNumber);
        this.jScrollPane = new JScrollPane(chanceSubView);
        this.jScrollPane.setPreferredSize(new Dimension(450, 650));

        this.add(jScrollPane, BorderLayout.CENTER);
        this.validate();
    }


    public ChanceSubView getChanceSubView() {
        return chanceSubView;
    }


}
