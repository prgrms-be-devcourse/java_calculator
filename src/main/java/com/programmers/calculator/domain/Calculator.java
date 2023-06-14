package com.programmers.calculator.domain;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {

    private Expression expression;

    public Calculator(Expression expression) {
        this.expression = expression;
    }

    public BigDecimal calculate(String inputExpression) {
        List<String> postfixTokens = expression.convertToPostfix(expression.parseToTokens(inputExpression));
        BigDecimal result = expression.evaluatePostfix(postfixTokens);
        return result;
    }
}
