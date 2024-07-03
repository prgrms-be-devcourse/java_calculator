package hello.core.main;

import hello.core.calculator.CalculatorServiceV0;
import hello.core.calculator.OperatorV0;
import hello.core.client.ClientV0;
import hello.core.repository.CalculatorRepositoryV0;

public class Main {

    public static void main(String[] args) {
        ClientV0 clientV0 = new ClientV0(new CalculatorServiceV0(new OperatorV0(), new CalculatorRepositoryV0()));
        clientV0.runCalculator();
    }
}
