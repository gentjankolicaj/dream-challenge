package io.gentjankolicaj.game.dream_challenge.search;

import io.gentjankolicaj.game.dream_challenge.element.Choice;
import io.gentjankolicaj.game.dream_challenge.element.ChoiceSet;
import io.gentjankolicaj.game.dream_challenge.exception.ChanceException;
import io.gentjankolicaj.game.dream_challenge.exception.ChoiceException;
import io.gentjankolicaj.game.dream_challenge.exception.MatrixException;
import io.gentjankolicaj.game.dream_challenge.view.chance.ChanceAreaView;
import io.gentjankolicaj.game.dream_challenge.view.chance.ChanceSubView;
import io.gentjankolicaj.game.dream_challenge.view.user.UserView;
import io.gentjankolicaj.game.dream_challenge.view.user.choice.ChoiceAreaView;
import io.gentjankolicaj.game.dream_challenge.view.user.choice.ChoiceView;
import io.gentjankolicaj.game.dream_challenge.view.user.print.PrintView;

import javax.swing.*;
import java.time.LocalDateTime;

public class MySearchAlgorithm<MyView> implements MySearch<MyView> {

    @SafeVarargs
    @Override
    public final void perform(MyView... args) {
        UserView userView = (UserView) args[0];
        ChanceSubView chanceSubView = userView.getChanceSubView();

        ChoiceView choiceView = userView.getChoiceView();
        PrintView printView = userView.getPrintView();

        if (choiceView != null && chanceSubView != null) {
            try {
                ChoiceSet[] userChoiceSets = getUserChoiceSet(choiceView);
                ChoiceSet[] randomChoiceSets = getRandomChoiceSet(chanceSubView);
                for (int i = 0; i < userChoiceSets.length; i++) {
                    Choice[][] userChoices = userChoiceSets[i].getChoices();
                    for (int j = 0; j < randomChoiceSets.length; j++) {
                        Choice[][] randomChoices = randomChoiceSets[j].getChoices();
                        boolean matchFlag = true;
                        if (isValidMatrix(userChoices, randomChoices)) {
                            //Check selection matches
                            Match_Loop:
                            for (int k = 0; k < userChoices.length; k++) {
                                for (int l = 0; l < userChoices[k].length; l++) {
                                    Choice userChoice = userChoices[k][l];
                                    Choice randChoice = randomChoices[k][l];
                                    if (userChoice.isSelected() != randChoice.isSelected()) {
                                        matchFlag = false;
                                        break Match_Loop;
                                    }
                                }
                            }
                        } else
                            throw new MatrixException("Matrix dimensions not matching.", userChoices, randomChoices);

                        if (matchFlag) {
                            print(printView, "--> Match found.User choice : " + i + " , Random choice : " + j);
                        }
                    }
                }

            } catch (ChoiceException choiceException) {
                String message = choiceException.getMessage();
                JOptionPane.showMessageDialog(userView, message, "Alert", JOptionPane.WARNING_MESSAGE);

            } catch (ChanceException chanceException) {
                String message = chanceException.getMessage();
                JOptionPane.showMessageDialog(userView, message, "Alert", JOptionPane.WARNING_MESSAGE);

            } catch (MatrixException matrixException) {
                String message = matrixException.getMessage();
                JOptionPane.showMessageDialog(userView, message, "Alert", JOptionPane.WARNING_MESSAGE);

            } catch (Exception e) {
                String message = e.getMessage();
                JOptionPane.showMessageDialog(userView, message, "Alert", JOptionPane.WARNING_MESSAGE);

            }

        } else
            print(printView, "Choice or Chance view is null.");

    }

    /**
     * Warning : Not safe against non-square arrays (non matrix) because there is no guarantee that 2d arrays are matrix
     * Use only when 2D array is matrix
     *
     * @param userChoices
     * @param randomChoices
     * @return
     */
    private boolean isValidMatrix(Choice[][] userChoices, Choice[][] randomChoices) {
        if (userChoices != null && randomChoices != null) {
            int userSize = userChoices.length * userChoices[0].length;
            int randSize = randomChoices.length * randomChoices[0].length;
            return userSize == randSize;
        } else
            return false;
    }


    private void print(PrintView printView, String str) {
        if (printView != null) {
            JTextArea jTextArea = printView.getTextArea();
            jTextArea.append(LocalDateTime.now() + " : " + str + "\n");
        }
    }

    private ChoiceSet[] getUserChoiceSet(ChoiceView choiceView) throws ChoiceException {
        ChoiceAreaView[] choiceAreaViews = choiceView.getChoiceAreaViews();
        if (choiceAreaViews != null && choiceAreaViews.length != 0) {
            int choiceAreasNumber = choiceAreaViews.length;
            ChoiceSet[] choiceSets = new ChoiceSet[choiceAreasNumber];
            for (int i = 0; i < choiceAreasNumber; i++)
                choiceSets[i] = choiceAreaViews[i].getChoiceSet();

            return choiceSets;

        } else
            throw new ChoiceException("Choice areas not found.");
    }

    private ChoiceSet[] getRandomChoiceSet(ChanceSubView chanceSubView) throws ChanceException {
        ChanceAreaView[] chanceAreaViews = chanceSubView.getChanceAreaViews();
        if (chanceAreaViews != null && chanceAreaViews.length != 0) {
            int chanceAreasNumber = chanceAreaViews.length;
            ChoiceSet[] choiceSets = new ChoiceSet[chanceAreasNumber];
            for (int j = 0; j < chanceAreasNumber; j++)
                choiceSets[j] = chanceAreaViews[j].getChoiceSet();

            return choiceSets;
        } else
            throw new ChanceException("Chance areas not found.");
    }

}
