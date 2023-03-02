public class StringToInteger {

    static int[] stringToInt(String[] values) {

        int num1 = Integer.parseInt(values[0]);
        int num2 = Integer.parseInt(values[2]);
        Calc.check(num1);
        Calc.check(num2);

        try {
            return new int[]{Integer.parseInt(values[0]), Integer.parseInt(values[2])};
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Выражение не верно");
        }
    }
}