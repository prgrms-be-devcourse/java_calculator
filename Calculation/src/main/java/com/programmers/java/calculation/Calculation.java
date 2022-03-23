package com.programmers.java.calculation;

import com.programmers.java.calculation.calculate.Calculate;
import com.programmers.java.calculation.parse.Parsing;
import com.programmers.java.calculation.parse.ParsingImpl;
import com.programmers.java.calculation.parse.Validation;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Calculation {

    private final Parsing parsing;
    private final Validation validation;
    private final Calculate calculate;

    public Double calculationAndValidate(String input) {
        String result1 = parsing.removeSpase(input);
        boolean validateString = validation.validateString(result1);
        boolean validateContOp = validation.validateContOp(result1);
        boolean validateFirstOp = validation.validateFirstOp(result1);
        boolean validateLastOp = validation.validateLastOp(result1);

        if (validateTotal(validateString, validateContOp, validateFirstOp, validateLastOp)) {
            List<String> resultList = parsing.makeArray(result1);
            return calculate.cal(resultList);
        } else {
            return null;
        }
    }


    private boolean validateTotal(boolean validateString, boolean validateContOp, boolean validateFirstOp, boolean validateLastOp) {
        return validateString && validateContOp && validateFirstOp && validateLastOp;
    }


}
