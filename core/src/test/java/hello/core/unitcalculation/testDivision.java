package hello.core.unitcalculation;

import hello.core.calculator.CalculatorServiceV0;
import hello.core.calculator.OperatorV0;
import hello.core.repository.CalculatorRepositoryV0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testDivision {
    @Test
    @DisplayName("나눗셈")
    public void Division () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("4 / 2");
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 2자리수 이상 포함")
    public void DivisionUpScale () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("100 / 5");
        Assertions.assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("나눗셈 소수점 계산 체크")
    public void DivisionDetail () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("12 / 5");
        Assertions.assertThat(result).isEqualTo(2.4);
    }

    @Test
    @DisplayName("0으로 나누기")
    public void ZeroDivision () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        org.junit.jupiter.api.Assertions.assertThrows(ArithmeticException.class,
                () -> calculatorServiceV0.calculateExpression("12 / 0"));
    }
}
