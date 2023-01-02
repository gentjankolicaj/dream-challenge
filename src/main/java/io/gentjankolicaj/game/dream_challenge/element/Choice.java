package io.gentjankolicaj.game.dream_challenge.element;

import javax.swing.*;

public class Choice extends JRadioButton {

    public Choice() {
        super();
        setSelected(false);
    }

    public Choice(boolean isClicked) {
        super();
        setSelected(isClicked);
    }
}
