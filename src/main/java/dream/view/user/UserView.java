package dream.view.user;


import dream.App;
import dream.view.chance.ChanceView;
import dream.view.listener.GenerateButtonListener;
import dream.view.listener.InputFieldListener;
import dream.view.listener.SearchButtonListener;
import dream.view.user.choice.ChoiceView;
import dream.view.user.input.InputView;
import dream.view.user.print.PrintView;

import javax.swing.*;
import java.awt.*;

public class UserView extends JPanel {
    private final GridLayout gridLayout;
    private final InputView inputView;
    private final PrintView printView;
    private ChoiceView choiceView;
    private JScrollPane scrollPane;

    private ChanceView chanceView;

    public UserView(int choiceNumber, int choiceSetNumber) {
        super();
        this.gridLayout = new GridLayout(3, 1);

        this.printView = new PrintView();
        this.inputView = new InputView();

        //Initial choice values are from static config
        this.choiceView = new ChoiceView(App.choiceNumber, App.choiceSetNumber);
        this.scrollPane = new JScrollPane(choiceView);

        this.add(inputView);
        this.add(scrollPane);
        this.add(printView);

        this.setLayout(gridLayout);
    }

    public void setChanceView(ChanceView chanceView) {
        this.chanceView = chanceView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public PrintView getPrintView() {
        return printView;
    }

    public ChoiceView getChoiceView() {
        return choiceView;
    }

    public ChanceView getChanceView() {
        return chanceView;
    }

    public void addInputListener() {
        JTextField choiceField = inputView.getInputFieldView().getFieldViews()[0].getTextField();
        JTextField choiceSetField = inputView.getInputFieldView().getFieldViews()[1].getTextField();

        //Create a key listener for input
        InputFieldListener inputFieldListener = new InputFieldListener(this, choiceField, choiceSetField);

        //Add listener to keys
        choiceField.addKeyListener(inputFieldListener);
        choiceSetField.addKeyListener(inputFieldListener);
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


    public void addButtonListeners() {
        addGenerateButtonListener();
        addExportButtonListener();
        addSearchButtonListener();
    }


    private void addSearchButtonListener() {
        JButton searchButton = this.inputView.getInputButtonView().getSearchButton();
        SearchButtonListener searchButtonListener = new SearchButtonListener(this);
        searchButton.addActionListener(searchButtonListener);
    }

    private void addExportButtonListener() {

    }

    private void addGenerateButtonListener() {
        JButton generateButton = this.inputView.getInputButtonView().getGenerateButton();
        GenerateButtonListener generateButtonListener = new GenerateButtonListener(this);
        generateButton.addActionListener(generateButtonListener);
    }


}
