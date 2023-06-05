/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package programmers.java.calulator;

import programmers.java.calulator.console.reader.ConsoleReader;
import programmers.java.calulator.console.runner.ConsoleRunner;
import programmers.java.calulator.console.writer.ConsoleWriter;
import programmers.java.calulator.common.Calculator;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        new ConsoleRunner(new Calculator(), new ConsoleReader(), new ConsoleWriter(), new HashMap<>()).run();
    }
}
