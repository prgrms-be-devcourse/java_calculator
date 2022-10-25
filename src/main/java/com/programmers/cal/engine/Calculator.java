package com.programmers.cal.engine;

import com.programmers.cal.engine.io.Input;
import com.programmers.cal.engine.io.Output;
import com.programmers.cal.engine.parse.Parse;
import com.programmers.cal.engine.validator.Validator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Calculator implements Runnable {

    private static final String PRINT_RECORD = "1";
    private static final String CALCULATE = "2";
    private static final String EXIT = "3";

    private Input input;
    private Output output;
    private Validator validator;
    private Parse parse;

    @Builder
    public Calculator(Input input, Output output, Validator validator, Parse parse) {
        this.input = input;
        this.output = output;
        this.validator = validator;
        this.parse = parse;
    }

    @Override
    public void run() {

        while (true) {

            output.requestInput();
            String inputString = input.inputOrder();

            switch (inputString) {
                case PRINT_RECORD:
                    printRecord();
                    break;
                case CALCULATE:
                    calculate();
                    break;
                case EXIT:
                    exit();
                    return;
                default:
                    output.printWrongOrder();
            }

        }
    }

    private void printRecord() {
        output.printRecord();
    }

    private void calculate() {

        //식을 입력받고
        String inputString = input.inputOrder();

        //validate(숫자, 연산자, 숫자 순인지)
        Boolean isExpression = validator.isExpression(inputString);

        //parse
        if(isExpression){
            List<String> tokens = parse.getTokenList(inputString);
        }else{
            output.printWrongOrder();
            return;
        }

        //입력받은 식을 계산해서
        String result = "5";

        //기록 저장

        //결과출력
        output.printResult(result);
    }

    private void exit() {
        output.printExit();
    }
}
