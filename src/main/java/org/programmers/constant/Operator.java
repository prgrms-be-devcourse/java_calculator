package org.programmers.constant;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 10, (o1, o2) -> o1 + o2),

    MINUS("-", 10, (o1, o2) -> o2 - o1),

    MULTI("*", 1, (o1, o2) -> o1 * o2),

    DIVISION("/", 1, (o1, o2) -> {
        if (o1 == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다..");
        return o2 / o1;
    });

    private final String symbol;

    private final int priority;

    private final BiFunction<Double, Double, Double> expression;

    Operator(String symbol, int priority, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol;
        this.priority = priority;
        this.expression = expression;
    }
}
