package hello.core.unitcalculation;

import hello.core.calculator.CalculatorServiceV0;
import hello.core.calculator.OperatorV0;
import hello.core.repository.CalculatorRepositoryV0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testAddition {
    @Test
    @DisplayName("덧셈")
    public void Addition () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("4 + 2");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("덧셈 2자리수 이상 포함")
    public void AdditionUpScale () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("40 + 288");
        Assertions.assertThat(result).isEqualTo(328);
    }
}
