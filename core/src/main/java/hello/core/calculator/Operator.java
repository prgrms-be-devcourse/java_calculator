package hello.core.calculator;

import java.util.List;

public interface Operator {
    double Add(double numberFront, double numberLast);
    double Subtract(double numberFront, double numberLast);
    double Divide(double numberFront, double numberLast);
    double Multiple(double numberFront, double numberLast);
    List<String> getOperator();
}
