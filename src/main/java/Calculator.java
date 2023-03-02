import java.util.Scanner;

public class Calculator {
    public boolean evenOddNumber(int n) {
        if (n == 0) {
            throw new ArithmeticException("Number is Zero");
        }

        return n % 2 == 0;
    }

    public boolean numberInInterval(int n) {
        return n >= 25 && n <= 100;
    }
}
