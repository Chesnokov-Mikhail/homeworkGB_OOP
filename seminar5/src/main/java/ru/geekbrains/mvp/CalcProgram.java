package ru.geekbrains.mvp;

import java.util.Scanner;

public class CalcProgram {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        CalcModel calcModel = new CalcModel();
        View view = new ViewImpl(scn, System.out);
        Presenter presenter = new Presenter(calcModel, view);
        presenter.execute();
    }
}
