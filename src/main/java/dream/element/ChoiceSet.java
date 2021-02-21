package dream.element;


public class ChoiceSet {
    private final Choice[][] choices;
    private int numberOfChoices;

    public ChoiceSet(int numberOfChoices) {
        super();
        this.choices = produceChoices(numberOfChoices);
    }

    private static Choice[][] produceChoices(int numberOfChoices) {
        Choice[][] array = new Choice[numberOfChoices][numberOfChoices];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Choice(false);
            }
        }
        return array;

    }

    public int getNumberOfChoices() {
        return this.numberOfChoices;
    }

    public Choice[][] getChoices() {
        return this.choices;
    }
}
