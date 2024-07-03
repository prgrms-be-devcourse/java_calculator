package hello.core.main;

import hello.core.AppConfig;
import hello.core.calculator.CalculatorServiceV0;
import hello.core.calculator.OperatorV0;
import hello.core.client.ClientV0;
import hello.core.repository.CalculatorRepositoryV0;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ClientV0 clientV0 = ac.getBean(ClientV0.class);
        clientV0.runCalculator();
    }
}
