package calculator.model.operator.bracket;

import calculator.model.operand.Operand;
import calculator.model.operator.Operator;
import calculator.model.operator.OperatorType;
import calculator.model.token.Tokenizationable;

public class OpenBracketOperator implements Operator {
    private final OperatorType type;
    public OpenBracketOperator() {
        type = OperatorType.CLOSED_BRACKET;
    }

    @Override
    public boolean couldOtherTokenComeNext(Tokenizationable other) {
        return other instanceof Operand || other instanceof OpenBracketOperator;
    }

    @Override
    public String getValue(String value) {
        return type.getSymbol();
    }
}
