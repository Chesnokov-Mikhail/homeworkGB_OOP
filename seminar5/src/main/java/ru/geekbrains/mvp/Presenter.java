package ru.geekbrains.mvp;

public class Presenter {

    private final CalcModel model;

    private final View view;

    public Presenter(CalcModel model, View view) {
        this.model = model;
        this.view = view;
    }

    public void execute() {
        model.setFirst(view.getValue("Enter first number: "));
        model.setSecond(view.getValue("Enter second number: "));
        String op = view.getOperation("Enter operation [+,-,*,/]: ");
        if (op.equals("+")) {
            view.print("Sum is: " + model.getSum());
        } else if (op.equals("-")) {
            view.print("Substraction is: " + model.getSubstraction());
        } else if (op.equals("*")) {
            view.print("Multiplication is: " + model.getMultiplication());
        } else if (op.equals("/")) {
            view.print("Division is: " + model.getDivision());
        } else {
            view.print("No operation enter!");
        }
    }

    private static class MockView implements View {

        private int count = 0;
        private int countop = 0;

        @Override
        public int getValue(String message) {
            count++;
            return 1;
        }

        @Override
        public String getOperation(String message) {
            countop++;
            return "+";
        }

        @Override
        public void print(String message) {
            if (!message.equals("Sum is: 2")) {
                throw new AssertionError("Incorrect sum");
            }
        }

        public int getCount() {
            return count;
        }

        public int getCountOperation() {
            return countop;
        }
    }

    public static void main(String[] args) {
        CalcModel calcModel = new CalcModel();
        MockView mockView = new MockView();
        Presenter presenter = new Presenter(calcModel, mockView);

        presenter.execute();
        if (mockView.getCount() != 2) {
            throw new AssertionError("Incorrect call of getValue()");
        }

        if (mockView.getCountOperation() != 1) {
            throw new AssertionError("Incorrect call of getOperation()");
        }
    }
}
