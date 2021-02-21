package dream;

import dream.view.chance.ChanceView;
import dream.view.user.UserView;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 */
public class App {
    public static int choiceNumber = 0;
    public static int choiceSetNumber = 0;
    public static int randomChoiceSetNumber = 2;

    public static void main(String[] args) {
        JFrame jframe = new JFrame();

        //Grid layout setting
        GridLayout gridLayout = new GridLayout(1, 2);
        jframe.setLayout(gridLayout);

        UserView userView = new UserView(jframe, choiceNumber, choiceSetNumber);
        ChanceView chanceView = new ChanceView(jframe);

        jframe.add(userView);
        jframe.add(chanceView);

        jframe.setSize(new Dimension(800, 600));
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}
