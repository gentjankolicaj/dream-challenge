package dream.prob;

public class ProbUtil {

    public static boolean isSelected() {
        int maxBorder = (int) (Math.random() * 10);
        int randVal = (int) (Math.random() * 10);
        return randVal >= 0 && randVal <= maxBorder;
    }
}
