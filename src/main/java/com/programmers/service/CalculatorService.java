package com.programmers.service;

import com.programmers.domain.ExpressionValidator;
import com.programmers.domain.PostFixConverter;
import com.programmers.domain.SelectionValidator;
import com.programmers.io.Console;

import java.util.List;

public class CalculatorService {

    private final Console console;
    private final SelectionValidator selectionValidator = new SelectionValidator();
    private final ExpressionValidator expressionValidator = new ExpressionValidator();
    private final PostFixConverter postfixConverter = new PostFixConverter();

    public CalculatorService(Console console) {
        this.console = console;
    }

    public int getValidatedMenuSelection() {
        String selection = console.getSelection();

        try {
            selectionValidator.validate(selection);
            return Integer.parseInt(selection);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedMenuSelection();
        }
    }

    public List<String> getValidatedExpression() {
        String expression = console.getExpressionSpaceRemoved();

        try {
            return expressionValidator.validate(expression);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedExpression();
        }
    }

    public void calculate() {
        List<String> expression = getValidatedExpression();
        List<String> postfix = postfixConverter.convertInfixToPostfix(expression);

        for (String s : postfix) {
            System.out.print(s + " ");
        }
    }
}
