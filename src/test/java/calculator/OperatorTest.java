package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName("더하기 연산")
    @Test
    void add() {
        assertThat(calculator.add(1, 2)).isEqualTo(3);
    }

    @DisplayName("빼기 연산")
    @Test
    void subtract() {
        assertThat(calculator.subtract(3, 1)).isEqualTo(2);
    }

    @DisplayName("곱하기 연산")
    @Test
    void multiply() {
        assertThat(calculator.multiply(3, 5)).isEqualTo(15);
    }

    @DisplayName("나누기 연산")
    @Test
    void divide() {
        assertThat(calculator.divide(4, 2)).isEqualTo(2);
    }

    @DisplayName("나누기 연산시 0으로 나누게 되면 예외를 던진다.")
    @Test
    void subtract_numberTwoIsZero_throwException() {
        assertThatThrownBy(() -> calculator.divide(3, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Operator.ERROR_DIVIDE);
    }
}
