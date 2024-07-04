package hello.core.unitcalculation;

import hello.core.calculator.CalculatorServiceV0;
import hello.core.calculator.OperatorV0;
import hello.core.repository.CalculatorRepositoryV0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testSubtraction {
    @Test
    @DisplayName("뺄셈")
    public void Subtraction () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("4 - 2");
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("뺄셈 2자리수 이상 포함")
    public void SubtractionUpScale () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("250 - 70");
        Assertions.assertThat(result).isEqualTo(180);
    }
}
