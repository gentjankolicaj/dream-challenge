package dream.view.user.choice;

import dream.view.MyView;

import javax.swing.*;

public class ChoiceView extends MyView {
    private ChoiceAreaView[] choiceAreaViews;


    public ChoiceView(int choiceNumber, int choiceSetNumber) {
        super();
        paintChoiceAreaView(choiceNumber, choiceSetNumber);
    }


    public void paintChoiceAreaView(int choiceNumber, int choiceSetNumber) {
        if (choiceNumber > 0 && choiceSetNumber > 0) {
            this.choiceAreaViews = new ChoiceAreaView[choiceSetNumber];
            for (int i = 0; i < choiceSetNumber; i++) {
                this.choiceAreaViews[i] = new ChoiceAreaView(choiceNumber);
                this.add(this.choiceAreaViews[i]);
                this.add(new JLabel());

            }
        }
    }

    public ChoiceAreaView[] getChoiceAreaViews() {
        return choiceAreaViews;
    }
}
