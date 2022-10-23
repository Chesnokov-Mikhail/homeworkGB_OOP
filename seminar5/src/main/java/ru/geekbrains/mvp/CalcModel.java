package ru.geekbrains.mvp;

public class CalcModel {

    private int first;

    private int second;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    // операция суммы
    public int getSum() {
        return first + second;
    }

    // операция вычитания
    public int getSubstraction() {
        return first - second;
    }

    // операция умножения
    public int getMultiplication() {
        return first * second;
    }

    // операция деление
    public double getDivision() {
        return (double) first / second;
    }

    public static void main(String[] args) {
        CalcModel calcModel = new CalcModel();
        // тест на операцию суммы
        calcModel.setFirst(2);
        calcModel.setSecond(3);
        if (calcModel.getSum() != 5) {
            throw new AssertionError("Incorrect test result summation");
        }
        // тест на операцию вычитания
        calcModel.setFirst(2);
        calcModel.setSecond(3);
        if (calcModel.getSubstraction() != -1) {
            throw new AssertionError("Incorrect test result substraction");
        }
        // тест на операцию умножения
        calcModel.setFirst(2);
        calcModel.setSecond(3);
        if (calcModel.getMultiplication() != 6) {
            throw new AssertionError("Incorrect test result multiplication");
        }
        // тест на операцию деления
        calcModel.setFirst(6);
        calcModel.setSecond(3);
        if (Math.abs(calcModel.getDivision() - 2) > 0.0001) {
            throw new AssertionError("Incorrect test result division");
        }
    }
}
