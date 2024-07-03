package hello.core.unitcalculation;

import hello.core.calculator.CalculatorServiceV0;
import hello.core.calculator.OperatorV0;
import hello.core.repository.CalculatorRepositoryV0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testMultiplication {
    @Test
    @DisplayName("곱셈")
    public void Multiplication () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("4 * 2");
        Assertions.assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("곱셈 2자리수 이상 포함")
    public void MultiplicationUpScale () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("100 * 70");
        Assertions.assertThat(result).isEqualTo(7000);
    }
}
