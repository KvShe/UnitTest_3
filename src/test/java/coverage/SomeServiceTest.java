package coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SomeServiceTest {
    private SomeService someService;

    @BeforeEach
    void SetUp() {
        someService = new SomeService();
    }

    /**
     * Разбить большой метод под номером 3 и проверить покрытие (должно быть 100%)
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    void testDiscountAmountIncorrect(int discountAmount) {
        assertThatThrownBy(() -> someService.calculatingDiscount(100, discountAmount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void testPurchaseAmountIncorrect() {
        assertThatThrownBy(() -> someService.calculatingDiscount(-1, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void testCalculatingDiscount() {
        assertThat(someService.calculatingDiscount(100, 50)).isEqualTo(50);
    }

}