import java.util.List;

public class RomanToArabic {
    public static int romanToArabic(String input) {
        String romanNumber = input.toUpperCase();
        int result = 0;

        List<RomanEnum> romanNumbers = RomanEnum.getReverseSortedValues();

        int i = 0;

        while ((romanNumber.length() > 0) && (i < romanNumbers.size())) {
            RomanEnum symbol = romanNumbers.get(i);
            if (romanNumber.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumber.length() > 0) {
            throw new IllegalArgumentException(input + " не римское число");
        }

        Calc.check(result);

        return result;
    }

    public static String arabicToRoman(int num) {

        List<RomanEnum> romanNumbers = RomanEnum.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((num > 0) && (i < romanNumbers.size())) {
            RomanEnum currentSymbol = romanNumbers.get(i);
            if (currentSymbol.getValue() <= num) {
                sb.append(currentSymbol.name());
                num -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}