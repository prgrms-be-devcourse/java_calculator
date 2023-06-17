package com.programmers;

import com.programmers.engine.controller.Calculator;
import com.programmers.engine.io.Console;
import com.programmers.engine.model.storage.MapStorage;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        new Calculator(
                console,
                console,
                new MapStorage())
                .run();
    }
}