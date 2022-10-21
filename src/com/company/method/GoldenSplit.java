package com.company.method;

import com.company.function.Function;
import com.company.function.Pair;

public class GoldenSplit implements Method {

    private static final double leftGolden = 0.382;
    private static final double rightGolden = 0.618;

    private final Function function;
    private final double epsilon;

    private double leftPoint;
    private double rightPoint;
    private double startLeftPoint;
    private double startRightPoint;

    public GoldenSplit(Function function, double startLeftPoint, double startRightPoint, double epsilon) {
        this.function = function;
        this.epsilon = epsilon;
        this.startLeftPoint = startLeftPoint;
        this.startRightPoint = startRightPoint;
    }

    @Override
    public Pair<Double, Double> calculateMinimum() {
        setStart();

        double leftValue = function.getValueAtPoint(leftPoint);
        double rightValue = function.getValueAtPoint(rightPoint);

        while (Math.abs(leftPoint - rightPoint) > 2 * epsilon) {
            if (leftValue < rightValue) {
                changeRightBorder();
            } else {
                changeLeftBorder();
            }
        }

        double middlePoint = (leftPoint + rightPoint) / 2;

        double middleValue = function.getValueAtPoint(middlePoint);

        return new Pair<Double, Double>(middlePoint, middleValue);

    }

    @Override
    public Pair<Double, Double> calculateMaximum() {
        setStart();

        double leftValue = function.getValueAtPoint(leftPoint);
        double rightValue = function.getValueAtPoint(rightPoint);

        while (Math.abs(leftPoint - rightPoint) > 2 * epsilon) {
            if (leftValue < rightValue) {
                changeLeftBorder();
            } else {
                changeRightBorder();
            }
        }

        double middlePoint = (leftPoint + rightPoint) / 2;

        double middleValue = function.getValueAtPoint(middlePoint);

        return new Pair<Double, Double>(middlePoint, middleValue);

    }

    private void setStart() {
        double a = startLeftPoint + (startRightPoint - startLeftPoint) * leftGolden;
        double b = startLeftPoint + (startRightPoint - startLeftPoint) * rightGolden;

        if (function.getValueAtPoint(a) < function.getValueAtPoint(b)) {
            leftPoint = startLeftPoint;
            rightPoint = b;
        } else {
            leftPoint = a;
            rightPoint = startRightPoint;
        }

    }

    private void changeLeftBorder() {
        leftPoint = leftPoint + leftGolden * (rightPoint - leftPoint);
    }

    private void changeRightBorder() {
        rightPoint = leftPoint + rightGolden * (rightPoint - leftPoint);
    }

}
