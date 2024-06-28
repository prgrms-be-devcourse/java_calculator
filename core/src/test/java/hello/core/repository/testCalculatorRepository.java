package hello.core.repository;

import hello.core.calculator.CalculatorServiceV0;
import hello.core.calculator.OperatorV0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class testCalculatorRepository {

    @Test
    @DisplayName("저장 확인")
    void checkGoodSave() {
        CalculatorRepositoryV0 calculatorRepositoryV0 = new CalculatorRepositoryV0();
        CalculatorServiceV0 calculatorServiceV0 = new CalculatorServiceV0(new OperatorV0(), calculatorRepositoryV0);
        calculatorServiceV0.calculateExpression("1 + 1");
        calculatorServiceV0.calculateExpression("2 + 2");
        Set<Map.Entry<String, Double>> history = calculatorRepositoryV0.getHistory();
        List<String> testList = new ArrayList<>();
        for (Map.Entry<String, Double> stringDoubleEntry : history) {
            testList.add(stringDoubleEntry.getKey());
        }

        Assertions.assertThat(testList.get(0)).isEqualTo("1 + 1");
        Assertions.assertThat(testList.get(1)).isEqualTo("2 + 2");
    }



}
