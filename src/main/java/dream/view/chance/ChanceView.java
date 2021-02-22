package dream.view.chance;

import javax.swing.*;

public class ChanceView extends JPanel {
    private ChanceAreaView[] chanceAreaViews;

    public ChanceView() {
        super();
    }

    public void revalidateChanceView(ChanceAreaView[] chanceAreaViews) {
        if (this.chanceAreaViews != null) {
            for (ChanceAreaView chanceAreaView : this.chanceAreaViews)
                this.remove(chanceAreaView);
        }

        this.chanceAreaViews = chanceAreaViews;
        for (ChanceAreaView chanceAreaView : this.chanceAreaViews) {
            this.add(chanceAreaView);
            this.add(new JLabel());
        }

        this.validate();
    }

}
