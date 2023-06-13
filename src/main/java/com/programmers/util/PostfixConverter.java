package com.programmers.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {
    private static final String SEPARATOR = " ";

    public static List<String> convert(String formula) {
        List<String> postfix = new ArrayList<>();
        String[] splitFormula = formula.split(SEPARATOR);
        Stack<String> stack = new Stack<>();
        checkEmptyFormula(splitFormula);

        for (int i = 0; i < splitFormula.length; i++) {
            String eachFormula = splitFormula[i];

            if (isOperatorCheck(i)) {
                putOperator(eachFormula, postfix, stack);
            } else {
                putOperand(eachFormula, postfix);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }

    private static void putOperator(String operator, List<String> postfix, Stack<String> stack) {
        if (!Operators.isOperator(operator))
            throw new IllegalArgumentException();

        if (stack.isEmpty() || Priority.getPriority(stack.peek()) < Priority.getPriority(operator)) {
            stack.push(operator);
            return;
        }

        while (!stack.isEmpty() && Priority.getPriority(stack.peek()) >= Priority.getPriority(operator)) {
            postfix.add(stack.pop());
        }

        stack.push(operator);
    }

    private static void putOperand(String operand, List<String> postfix) {
        if (!StringUtil.isNumber(operand)) {
            throw new NumberFormatException();
        }
        postfix.add(operand);
    }


    private static boolean isOperatorCheck(int i) {
        return (i + 1) % 2 == 0;
    }

    private static void checkEmptyFormula(String[] splitFormula) throws IllegalArgumentException {
        if (isEmptyFormula(splitFormula)) throw new IllegalArgumentException();
    }

    private static boolean isEmptyFormula(String[] splitFormula) {
        return splitFormula != null && splitFormula.length == 0;
    }
}
