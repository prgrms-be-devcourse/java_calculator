package com.programmers.java.engine.calculator;

import com.programmers.java.application.exception.EmptyExpressionException;
import com.programmers.java.application.exception.WrongOrderOperatorException;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;

public interface Calculator {
    // 식으로 값 계산 (후위 연산 변환 + 계산)
    Answer calculate(Expression expression);

    // 후위연산으로 계산
    Answer getResult(String[] postTokens);

    // 후위 연산으로 변환
    String[] makePostfix(String[] tokens);

    // 사용자의 식을 Expression 으로 변환
    Expression parseExpression(String inputExpression) throws EmptyExpressionException, WrongOrderOperatorException, Exception;

}
