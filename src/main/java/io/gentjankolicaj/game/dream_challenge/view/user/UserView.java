package io.gentjankolicaj.game.dream_challenge.view.user;


import io.gentjankolicaj.game.dream_challenge.Application;
import io.gentjankolicaj.game.dream_challenge.view.ParentView;
import io.gentjankolicaj.game.dream_challenge.view.chance.ChanceSubView;
import io.gentjankolicaj.game.dream_challenge.view.chance.ChanceView;
import io.gentjankolicaj.game.dream_challenge.view.listener.*;
import io.gentjankolicaj.game.dream_challenge.view.user.choice.ChoiceView;
import io.gentjankolicaj.game.dream_challenge.view.user.input.InputView;
import io.gentjankolicaj.game.dream_challenge.view.user.print.PrintView;

import javax.swing.*;
import java.awt.*;

public class UserView extends ParentView {
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
        this.choiceView = new ChoiceView(Application.choiceNumber, Application.choiceSetNumber);
        this.scrollPane = new JScrollPane(choiceView);

        this.add(inputView);
        this.add(scrollPane);
        this.add(printView);

        this.setLayout(gridLayout);
    }


    public ChanceView getChanceView() {
        return this.chanceView;
    }

    //View methods
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

    public ChanceSubView getChanceSubView() {
        return chanceView.getChanceSubView();
    }

    public void revalidateView(int choiceNumber, int choiceSetNumber) {
        //Remove components
        this.remove(scrollPane);
        this.remove(printView);

        //Create new components with new values
        this.choiceView = new ChoiceView(choiceNumber, choiceSetNumber);
        this.scrollPane = new JScrollPane(choiceView);

        //Add new components
        this.add(scrollPane);
        this.add(printView);
        this.printView.printText(" Choices & sets [ " + choiceNumber + "," + choiceSetNumber + " ]");

        //We need to revalidate the component tree because of changes
        this.validate();
    }


    //Listener methods
    public void addInputListener() {
        JTextField choiceField = inputView.getInputFieldView().getFieldViews()[0].getTextField();
        JTextField choiceSetField = inputView.getInputFieldView().getFieldViews()[1].getTextField();

        //Create a key listener for input
        InputFieldListener inputFieldListener = new InputFieldListener(this, choiceField, choiceSetField);

        //Add listener to documents
        choiceField.getDocument().addDocumentListener(inputFieldListener);
        choiceSetField.getDocument().addDocumentListener(inputFieldListener);
    }

    public void addButtonListeners() {
        addGenerateButtonListener();
        addExportButtonListener();
        addSearchButtonListener();
        addClearButtonListener();
    }


    private void addSearchButtonListener() {
        JButton searchButton = this.inputView.getInputButtonView().getSearchButton();
        SearchButtonListener searchButtonListener = new SearchButtonListener(this);
        searchButton.addActionListener(searchButtonListener);
    }

    private void addGenerateButtonListener() {
        JButton generateButton = this.inputView.getInputButtonView().getGenerateButton();
        GenerateButtonListener generateButtonListener = new GenerateButtonListener(this);
        generateButton.addActionListener(generateButtonListener);
    }

    private void addExportButtonListener() {
        JButton exportButton = this.inputView.getInputButtonView().getExportButton();
        ExportButtonListener exportButtonListener = new ExportButtonListener(this, chanceView);
        exportButton.addActionListener(exportButtonListener);
    }

    private void addClearButtonListener() {
        JButton clearButton = this.inputView.getInputButtonView().getClearButton();
        ClearButtonListener clearButtonListener = new ClearButtonListener(this);
        clearButton.addActionListener(clearButtonListener);
    }


}
