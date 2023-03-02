import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void SetUp() {
        calculator = new Calculator();
    }

    /**
     * Нужно покрыть тестами метод на 100%
     * Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false)
     * <p>
     * public boolean evenOddNumber(int n) {
     * if (n % 2 == 0) {
     * return true;
     * } else {
     * return false;
     * }
     * }
     */
    @Test
    void testEvenOddNumberTrue() {
        assertTrue(calculator.evenOddNumber(2));
    }

    @Test
    void testEvenOddNumberFalse() {
        assertFalse(calculator.evenOddNumber(3));
    }

    @Test
    void testEvenOddNumberByZero() {
        assertThatThrownBy(() -> calculator.evenOddNumber(0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Number is Zero");
    }

    /**
     * Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) возвращает true, если попадает и false - если нет, покрыть тестами метод на 100%
     * <p>
     * public boolean numberInInterval(int n) { … }
     */
    @ParameterizedTest
    @ValueSource(ints = {25, 100})
    void testNumberInIntervalTrue() {
        assertTrue(calculator.numberInInterval(25));
    }

    @ParameterizedTest
    @ValueSource(ints = {24, 101, -25, -100})
    void testNumberInIntervalFalse() {
        assertFalse(calculator.numberInInterval(101));
    }
}
