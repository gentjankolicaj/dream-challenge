package dream.view.user;


import dream.App;
import dream.view.user.choice.ChoiceView;
import dream.view.user.input.InputView;
import dream.view.user.listener.InputFieldListener;
import dream.view.user.print.PrintView;

import javax.swing.*;
import java.awt.*;

public class UserView extends JPanel {
    private final GridLayout gridLayout;
    private final InputView inputView;
    private final PrintView printView;
    private ChoiceView choiceView;
    private JScrollPane scrollPane;

    public UserView(JFrame jframe, int choiceNumber, int choiceSetNumber) {
        super();
        this.gridLayout = new GridLayout(3, 1);

        this.printView = new PrintView();
        this.inputView = new InputView();

        //Initial choice values are from static config
        this.choiceView = new ChoiceView(App.choiceNumber, App.choiceSetNumber);
        this.scrollPane = new JScrollPane(choiceView);

        //Create a key listener for input
        new InputFieldListener(this, inputView);

        this.add(inputView);
        this.add(scrollPane);
        this.add(printView);

        this.setLayout(gridLayout);
    }

    public void revalidateUserView(int choiceNumber, int choiceSetNumber) {
        //Remove components
        this.remove(scrollPane);
        this.remove(printView);

        //Create new components with new values
        this.choiceView = new ChoiceView(choiceNumber, choiceSetNumber);
        this.scrollPane = new JScrollPane(choiceView);

        //Add new components
        this.add(scrollPane);
        this.add(printView);

        //We need to revalidate the component tree because of changes
        this.validate();
    }

}
