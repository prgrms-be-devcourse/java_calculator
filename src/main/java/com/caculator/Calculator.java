package com.caculator;

import com.caculator.io.Input;
import com.caculator.io.Output;
import com.caculator.repository.CalculatorRepository;
import com.caculator.dto.Result;

import java.util.List;
import java.util.Stack;

import static com.caculator.ErrorMessage.*;

public class Calculator {

    private final CalculatorRepository repository;
    private final Input input;
    private final Output output;
    private static final String COMMAND_HISTORY = "1", COMMAND_CALCULATE = "2", COMMAND_EXIT = "-1";

    public Calculator(CalculatorRepository repository, Input input, Output output) {
        this.repository = repository;
        this.input = input;
        this.output = output;
    }

    public void run() {
        while (true) {
            String cmd = input.inputCmd();

            switch (cmd) {
                case COMMAND_HISTORY:
                    List<Result> history = repository.findAll();
                    executeHistoryCommand(history);
                    break;
                case COMMAND_CALCULATE:
                    String exp = input.inputExp();
                    executeCalculationCommand(exp);
                    break;
                case COMMAND_EXIT:
                    return;
                default:
                    commandError();
            }
        }
    }

    /**
     * 잘못된 메뉴를 선택했을 때 호출 되어 에러 메시지를 출력한다.
     */
    private void commandError() {
        output.printError(INCORRECT_COMMAND_ERROR_MESSAGE);
    }

    /**
     * - 올바른 수식인 경우 -> 인자로 받은 수식을 계산 후 repository 에 저장하고 결과를 출력한다.
     * - 올바른 수식이 아닌 경우 -> 에러 메시지를 출력한다.
     * @param expression : 수식
     */
    private void executeCalculationCommand(String expression) {
        try {
            int result = executeCalculator(expression);
            repository.save(new Result(expression, result));
            output.printResult(result);
        } catch (IllegalArgumentException e) {
            output.printError(INCORRECT_EXPRESSION_ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            output.printError(DIVIDE_ZERO_ERROR_MESSAGE);
        }
    }

    /**
     * 계산 이력을 출력한다.
     * - 계산 이력이 있는 경우 -> 계산 이력을 출력
     * - 계산 이력이 없는 경우 -> 계산 이력이 없다는 메시지 출력
     */
    private void executeHistoryCommand(List<Result> history) {
        if (isEmptyHistory(history)) {
            output.printError(EMPTY_HISTORY_MESSAGE);
            return;
        }
        output.printHistory(history);
    }

    /**
     * 계산 이력이 없으면 true 를 반환한다.
     */
    private boolean isEmptyHistory(List<Result> history) {
        return history.size() == 0;
    }

    /**
     * 계산기를 실행한다.
     * @param expression : 중위 표기법 수식
     * @return : 계산 결과 정수
     * @throws IllegalArgumentException, ArithmeticException : convert(), calculatePostfixExpression()에서 던져진 예외
     */
    public int executeCalculator(String expression) throws IllegalArgumentException, ArithmeticException {
        List<String> postfix = PostfixConverter.convert(expression);
        return calculatePostfixExpression(postfix);
    }

    /**
     후위 표기식을 입력 받아 계산 후 결과를 반환한다.
     * @param expressions : 후위 표기식
     * @return 연산 결과
     * @throws IllegalArgumentException, ArithmeticException : calculate()에서 던져진 예외
     */
    private int calculatePostfixExpression(List<String> expressions) throws IllegalArgumentException, ArithmeticException {
        Stack<Integer> stack = new Stack<>();

        for (String s : expressions) {
            if (StringUtils.isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(calculate(n1, n2, s));
            }
        }

        return stack.pop();
    }

    /**
     * n1,n2를 operator 연산한 결과를 반환한다.
     * @throws ArithmeticException : 0으로 나누는 연산, 연산 결과에 오버플로 발생시 던져진다.
     * @throws IllegalArgumentException : operator 가 연산자(+, -. *, /)가 가 아닌 경우 던져진다.
     */
    private int calculate(int n1, int n2, String operator) throws ArithmeticException, IllegalArgumentException {
        switch (operator) {
            case "+":
                return Math.addExact(n1, n2);
            case "-":
                return Math.subtractExact(n1, n2);
            case "*":
                return Math.multiplyExact(n1, n2);
            case "/":
                return Math.floorDiv(n1, n2);
            default:
                throw new IllegalArgumentException();
        }
    }
}
