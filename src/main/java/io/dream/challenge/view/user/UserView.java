package io.dream.challenge.view.user;


import io.dream.challenge.Application;
import io.dream.challenge.view.ParentView;
import io.dream.challenge.view.chance.ChanceSubView;
import io.dream.challenge.view.chance.ChanceView;
import io.dream.challenge.view.listener.ClearButtonListener;
import io.dream.challenge.view.listener.ExportButtonListener;
import io.dream.challenge.view.listener.GenerateButtonListener;
import io.dream.challenge.view.listener.InputFieldListener;
import io.dream.challenge.view.listener.SearchButtonListener;
import io.dream.challenge.view.user.choice.ChoiceView;
import io.dream.challenge.view.user.input.InputView;
import io.dream.challenge.view.user.print.PrintView;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import lombok.Getter;
import lombok.Setter;

public class UserView extends ParentView {

  private final GridLayout gridLayout;
  @Getter
  private final InputView inputView;
  @Getter
  private final PrintView printView;
  @Getter
  private ChoiceView choiceView;
  private JScrollPane scrollPane;

  //View methods
  @Setter
  @Getter
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
    InputFieldListener inputFieldListener = new InputFieldListener(this, choiceField,
        choiceSetField);

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
