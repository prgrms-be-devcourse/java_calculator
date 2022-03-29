package main.calculator.engine.io;

public interface Output {
    void menu();
    void inputError();
    void quit();
    void print(String content);
}
