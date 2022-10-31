package com.programmers.java.engin;

import com.programmers.java.Console;
import com.programmers.java.engin.io.Calculation;
import com.programmers.java.engin.io.Input;
import com.programmers.java.engin.io.Output;
import com.programmers.java.engin.model.Log;

import java.util.ArrayList;
import java.util.List;


public class Calculator implements Runnable{

    private Calculation calculation;
    private Input input;
    private Output output;

    static final String NEWLINE = System.lineSeparator();

    List<Log> logs = new ArrayList<>();

    public Calculator(Calculation calculation, Input input, Output output) {
        this.calculation = calculation;
        this.input = input;
        this.output = output;
    }


    @Override
    public void run() {

        while(true){
            String inputMenu = input.input("1. 조회"+NEWLINE+"2. 계산"+NEWLINE+NEWLINE+"선택 : ");

            if (inputMenu.equals("1")){
                output.logsView(logs);
            } else if (inputMenu.equals("2")) {
                String expression = input.input();
                runCalculation(expression);
            } else if (inputMenu.equals("-1")) {
                break;
            } else {
                output.errorMessage("잘못된 입력입니다. 메뉴를 다시 선택해주세요.");
            }

        }
    }

    private void runCalculation(String expression){
        try{
            String result = calculation.getResult(expression);
            logs.add(new Log(expression ,result));
            output.answer(result);
        }catch (Exception error){
            output.errorMessage(error.getMessage());
        }
    }

}
