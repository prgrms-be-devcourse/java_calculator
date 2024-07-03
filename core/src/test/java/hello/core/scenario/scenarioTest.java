package hello.core.scenario;

import hello.core.calculator.CalculatorServiceV0;
import hello.core.calculator.OperatorV0;
import hello.core.client.ClientV0;
import hello.core.repository.CalculatorRepositoryV0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class scenarioTest {
    @Test
    @DisplayName("1 + 2")
    public void 시나리오1 () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("1 + 2");
        Assertions.assertThat(result).isEqualTo(3);

    }

    @Test
    @DisplayName("1 + 2 * 3")
    public void 시나리오2 () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("1 + 2 * 3");
        Assertions.assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("1 + 2 * 3")
    public void 시나리오3 () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("3 - 2 * 2");
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("시나리오 계산 통합")
    public void 시나리오4 () {
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0());
        Double result = calculatorServiceV0.calculateExpression("1 + 2");
        Assertions.assertThat(result).isEqualTo(3);

        Double result2 = calculatorServiceV0.calculateExpression("1 + 2 * 3");
        Assertions.assertThat(result2).isEqualTo(7);

        Double result3 = calculatorServiceV0.calculateExpression("3 - 2 * 2");
        Assertions.assertThat(result3).isEqualTo(-1);
    }
}
