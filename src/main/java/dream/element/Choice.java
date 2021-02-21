package dream.element;

import javax.swing.*;

public class Choice extends JRadioButton {
    private boolean isClicked;

    public Choice() {
    }

    public Choice(boolean isClicked) {
        super();
        this.isClicked = isClicked;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
