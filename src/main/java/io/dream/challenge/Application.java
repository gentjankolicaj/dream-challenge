package io.dream.challenge;

import io.dream.challenge.view.chance.ChanceView;
import io.dream.challenge.view.user.UserView;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * @author Gentjan Kolicaj
 */
public class Application {

  public static int choiceNumber = 4;
  public static int choiceSetNumber = 5;
  public static int randomChoiceSetNumber = 23;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame();

    //Grid layout setting
    GridLayout gridLayout = new GridLayout(1, 2);
    jFrame.setLayout(gridLayout);

    UserView userView = new UserView(choiceNumber, choiceSetNumber);
    ChanceView chanceView = new ChanceView(choiceNumber, randomChoiceSetNumber);

    //Add button listeners
    userView.setChanceView(chanceView);
    userView.addInputListener();
    userView.addButtonListeners();

    jFrame.add(userView);
    jFrame.add(chanceView);

    jFrame.setTitle("Dream challenge");
    jFrame.setSize(new Dimension(900, 700));
    jFrame.setResizable(false);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setVisible(true);
  }
}
