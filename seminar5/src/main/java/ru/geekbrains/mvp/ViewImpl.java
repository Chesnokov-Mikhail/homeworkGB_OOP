package ru.geekbrains.mvp;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ViewImpl implements View {

    private final Scanner scn;

    private final PrintStream out;

    public ViewImpl(Scanner scn, PrintStream out) {
        this.scn = scn;
        this.out = out;
    }

    @Override
    public int getValue(String message) {
        out.print(message);
        return scn.nextInt();
    }

    @Override
    public String getOperation(String message) {
        out.print(message);
        String op = scn.next().trim();
        return op;
    }

    @Override
    public void print(String message) {
        out.print(message);
    }
}
