/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.Calculator;

public class App {
    public static void main(String[] args) {
        Console console = new Console();

        new Calculator(console, console).run();
    }
}
