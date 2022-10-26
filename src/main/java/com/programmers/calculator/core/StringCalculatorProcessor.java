package com.programmers.calculator.core;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class StringCalculatorProcessor implements CalculatorProcessor {

    @Override
    public Number calculate(Expression expression) {
        String[] expressionArray = expression.expressionSplitArray();

        Deque<String> deque = new ArrayDeque<>();

        Iterator<String> iterator = Arrays.stream(expressionArray).iterator();

        while (iterator.hasNext()) {
            String inputStr = iterator.next();

            if (Operator.isHigherPriorityOperator(inputStr) && !deque.isEmpty() && iterator.hasNext()) {
                double leftValue = Double.parseDouble(deque.pollLast());
                double rightValue = Double.parseDouble(iterator.next());

                Double result = Operator.calculate(inputStr, leftValue, rightValue);
                deque.addLast(result.toString());
                continue;
            }

            deque.addLast(inputStr);
        }

        while (deque.size() != 1) {
            String leftValue = deque.pollFirst();
            String operator = deque.pollFirst();
            String rightValue = deque.pollFirst();

            if (leftValue != null && rightValue != null) {
                deque.addFirst(Operator.calculate(operator, Double.parseDouble(leftValue), Double.parseDouble(rightValue)).toString());
            }

        }

        return Double.parseDouble(deque.pollFirst());
    }

}
