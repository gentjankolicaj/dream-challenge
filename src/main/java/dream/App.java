package dream;

import dream.view.chance.ChanceView;
import dream.view.user.UserView;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 */
public class App {
    public static int choiceNumber = 3;
    public static int choiceSetNumber = 2;
    public static int randomChoiceSetNumber = 2;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        //Grid layout setting
        GridLayout gridLayout = new GridLayout(1, 2);
        jFrame.setLayout(gridLayout);

        UserView userView = new UserView(choiceNumber, choiceSetNumber);
        ChanceView chanceView = new ChanceView();

        //Add button listeners
        userView.addButtonListeners(chanceView);


        jFrame.add(userView);
        jFrame.add(chanceView);

        jFrame.setSize(new Dimension(900, 700));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
