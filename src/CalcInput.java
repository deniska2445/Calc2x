import java.util.Scanner;

public class CalcInput {

    public static String calculator() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение в формате \"a + b\"." +
                "\nВведите строку для калькулятора: ");
        String str = in.nextLine();
        System.out.println(Calc.calculator(str));
        return Calc.calculator(str);
    }
}