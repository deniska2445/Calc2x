public class Calc {

    public static String calculator(String str) throws Exception {
        String[] values = str.split(" ");
        if (values.length != 3)
            throw new IllegalArgumentException("Неверное выражение");

        boolean isRoman = isRoman(values);

        int[] numbers;
        if (isRoman) {
            numbers = new int[]{RomanToArabic.romanToArabic(values[0]), RomanToArabic.romanToArabic(values[2])};
        } else {
            numbers = StringToInteger.stringToInt(values);
        }
        int num1 = numbers[0], num2 = numbers[1];

        int result;
        switch (values[1]) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new Exception("Операция не поддерживается");
        }

        if (isRoman) return RomanToArabic.arabicToRoman(result);
        else return String.valueOf(result);
    }

    static void check(int num) {
        if (num > 10 || num < 1)
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10 включительно!");
    }
    private static boolean isRoman(String[] values) {
        try {
            Integer.parseInt(values[0]);
            Integer.parseInt(values[2]);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}