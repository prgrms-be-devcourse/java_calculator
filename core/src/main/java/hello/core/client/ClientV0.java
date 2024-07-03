package hello.core.client;

import hello.core.calculator.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ClientV0 implements Client{
    CalculatorService calculatorService;

    @Autowired
    public ClientV0(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public void runCalculator() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 조회");
            System.out.println("2. 계산");
            System.out.println(" ");
            System.out.print("선택 : ");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");

            if (choice == 1) {
                calculatorService.showHistory();
            } else if (choice == 2) {
                String expression = sc.nextLine();
                Double result = calculatorService.calculateExpression(expression);
                System.out.println(result.intValue());
            }
        }
    }
}
