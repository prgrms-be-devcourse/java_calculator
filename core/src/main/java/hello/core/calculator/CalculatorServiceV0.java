package hello.core.calculator;

import hello.core.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CalculatorServiceV0 implements CalculatorService{

    private CalculatorRepository memory;
    private List<String> tmpMemoryOperator = new ArrayList<>();
    private List<Double> tmpMemoryOperand = new ArrayList<>();
    private Operator operatorInstance;
    @Autowired
    public CalculatorServiceV0(Operator operatorInstance, CalculatorRepository memory) {
        this.operatorInstance = operatorInstance;
        this.memory = memory;
    }

    @Override
    public void showHistory() {
        memory.getHistory();
    }

    @Override
    public Double calculateExpression(String expression) {
        setExpreesion(expression); // tmp에 데이터 적재
        firstCalculate(); // 곱, 나눗셈 처리
        secondCalculate(); // 뺄셈, 덧셈 처리
        Double result = tmpMemoryOperand.get(0);
        tmpMemoryOperand.clear();
        tmpMemoryOperator.clear();
        memory.putHistory(expression, result);
        return result;
    }

    private void secondCalculate() {
        for (int i=0; i<tmpMemoryOperator.size(); i++) {
            String operator = tmpMemoryOperator.remove(i);
            Double operandFront = tmpMemoryOperand.get(i);
            Double operandLast = tmpMemoryOperand.get(i+1);
            Double result = unitCalculate(operator, operandFront, operandLast);
            tmpMemoryOperand.add(i, result);
        }
    }

    private void firstCalculate() {
        for (int i=0; i<tmpMemoryOperator.size(); i++) {
            if (tmpMemoryOperator.get(i).equals("*") | tmpMemoryOperator.get(i).equals("/")) {
                String operator = tmpMemoryOperator.remove(i);
                Double operandFront = tmpMemoryOperand.get(i);
                Double operandLast = tmpMemoryOperand.get(i+1);
                tmpMemoryOperand.remove(i);
                tmpMemoryOperand.remove(i);
                Double result = unitCalculate(operator, operandFront, operandLast);
                tmpMemoryOperand.add(i, result);

            }
        }
    }

    private Double unitCalculate(String operator, Double operandFront, Double operandLast) {
        switch (operator) {
            case "+" -> {
                return operatorInstance.Add(operandFront, operandLast);
            }
            case "-" -> {
                return operatorInstance.Subtract(operandFront, operandLast);
            }
            case "*" -> {
                return operatorInstance.Multiple(operandFront, operandLast);
            }
            case "/" -> {
                return operatorInstance.Divide(operandFront, operandLast);
            }
        }
        //예외 발생시켜서 예외 처리 하면 좋을 것 같음.
        return 0.0;
    }

    private void setExpreesion(String expression) {
        String[] expressionArray = expression.split(" ");
        for (String oper : expressionArray) {
            if (operatorInstance.getOperator().contains(oper)) {
                tmpMemoryOperator.add(oper);
            } else if (isParsableAsDouble(oper)) {
                tmpMemoryOperand.add(Double.parseDouble(oper));
            } else {
                throw new IllegalArgumentException();
            }

        }
    }

    private boolean isParsableAsDouble(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
