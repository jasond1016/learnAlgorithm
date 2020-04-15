package recursion;

/**
 * @author Jason
 * @date 2020/4/15
 */
public class Q1 {
    public static int getRow(int n) {
        if (n == 1) {
            return 1;
        }
        return getRow(n - 1) + 1;
    }

    public static int getStepSolutionCount(int step) {
        if (step == 1) {
            return 1;
        }

        if (step == 2) {
            return 2;
        }

        return getStepSolutionCount(step - 1) + getStepSolutionCount(step - 2);
    }

    public static void main(String[] args) {
        System.out.println(getRow(5));
        System.out.println(getStepSolutionCount(1));
        System.out.println(getStepSolutionCount(2));
        System.out.println(getStepSolutionCount(3));
        System.out.println(getStepSolutionCount(4));
        System.out.println(getStepSolutionCount(5));
    }
}
