package hello.core.calculator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperatorV0 implements Operator{
    private final List<String> operator = List.of("+", "-", "*", "/");

    @Override
    public List<String> getOperator() {
        return operator;
    }

    @Override
    public double Add(double numberFront, double numberLast) {
        return numberFront + numberLast;
    }

    @Override
    public double Subtract(double numberFront, double numberLast) {
        return numberFront - numberLast;
    }

    @Override
    public double Divide(double numberFront, double numberLast) {
        if (numberLast == 0.0) {
            throw new ArithmeticException();
        }
        return numberFront / numberLast;
    }

    @Override
    public double Multiple(double numberFront, double numberLast) {
        return numberFront * numberLast;
    }
}
