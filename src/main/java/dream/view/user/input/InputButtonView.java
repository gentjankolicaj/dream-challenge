package dream.view.user.input;

import javax.swing.*;

public class InputButtonView extends JPanel {
    private final BoxLayout boxLayout;
    private final JComponent[] components;

    public InputButtonView(JComponent... jComponents) {
        super();
        this.boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.components = jComponents;

        addCurrentComponents();

        this.setLayout(boxLayout);

    }

    private void addCurrentComponents() {
        if (components != null && components.length != 0) {
            for (JComponent jComponent : components)
                this.add(jComponent);
        }
    }

    public JComponent[] getComponents() {
        return components;
    }


}
