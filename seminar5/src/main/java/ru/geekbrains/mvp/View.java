package ru.geekbrains.mvp;

public interface View {
    // ввод значения
    int getValue(String message);
    // ввод операции
    String getOperation(String message);
    // вывод
    void print(String message);
}
