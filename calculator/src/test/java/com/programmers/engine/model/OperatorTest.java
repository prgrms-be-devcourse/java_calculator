package com.programmers.engine.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class OperatorTest {

    @Test
    void 더하기_연산_테스트() {
        Integer result = Operator.getOperator("+").calculate(4, 2);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 빼기_연산_테스트() {
        Integer result = Operator.getOperator("-").calculate(4, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 곱하기_연산_테스트() {
        Integer result = Operator.getOperator("*").calculate(4, 2);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void 나누기_연산_테스트() {
        Integer result = Operator.getOperator("/").calculate(4, 2);
        assertThat(result).isEqualTo(2);
    }
}