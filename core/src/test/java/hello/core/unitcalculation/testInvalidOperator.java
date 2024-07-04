package hello.core.unitcalculation;

import hello.core.calculator.CalculatorServiceV0;
import hello.core.calculator.OperatorV0;
import hello.core.repository.CalculatorRepositoryV0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testInvalidOperator {

    @Test
    @DisplayName("잘못된 연산자 테스트")
    public void InvalidOperatorTest () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculatorServiceV0.calculateExpression("250 $ 70"));
    }
}
