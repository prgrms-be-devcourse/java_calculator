import model.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void 정상_입력() {
        //given
        String plusOperation = "+";
        String minusOperation = "-";
        String multiplyOperation = "*";
        String divideOperation = "/";
        //when
        Operator plus = Operator.parse(plusOperation);
        Operator minus = Operator.parse(minusOperation);
        Operator multiply = Operator.parse(multiplyOperation);
        Operator divide = Operator.parse(divideOperation);
        //then
        Assertions.assertThat(plus.calculate(1, 2)).isEqualTo(3.0);
        Assertions.assertThat(minus.calculate(1, 2)).isEqualTo(-1.0);
        Assertions.assertThat(multiply.calculate(5, 222)).isEqualTo(1110.0);
        Assertions.assertThat(divide.calculate(66, 5)).isEqualTo(13.2);
    }
}