package io.dream.challenge.view.user.input;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class InputFieldView extends JPanel {

  private final BoxLayout boxLayout;
  private final FieldView[] fieldViews;

  public InputFieldView(FieldView... fieldViews) {
    super();
    this.boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
    this.fieldViews = fieldViews;

    this.addFieldViews();
    this.setLayout(boxLayout);
  }

  private void addFieldViews() {
    if (fieldViews != null) {
      for (FieldView fieldView : fieldViews) {
        this.add(fieldView);
      }
    }
  }

  public FieldView[] getFieldViews() {
    return this.fieldViews;
  }

}
