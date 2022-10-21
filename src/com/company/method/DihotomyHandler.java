package com.company.method;

import com.company.function.Function;
import com.company.function.Pair;

public class DihotomyHandler implements Method {

    private final Function function;
    private final double epsilon;

    private double leftPoint;
    private double rightPoint;
    private double startLeftPoint;
    private double startRightPoint;


    public DihotomyHandler(Function function, double startLeftPoint, double startRightPoint, double epsilon) {
        this.function = function;
        this.epsilon = epsilon;
        this.startLeftPoint = startLeftPoint;
        this.startRightPoint = startRightPoint;
    }

    private void setStarts() {
        leftPoint = startLeftPoint;
        rightPoint = startRightPoint;
    }


    @Override
    public Pair<Double, Double> calculateMinimum() {
        setStarts();
        while (Math.abs(leftPoint - rightPoint) > 2 * epsilon) {
            changeMinBorder();
        }

        double middlePoint = (leftPoint + rightPoint) / 2;
        double middleValue = function.getValueAtPoint(middlePoint);

        return new Pair<Double, Double>(middlePoint, middleValue);
    }

    @Override
    public Pair<Double, Double> calculateMaximum() {
        setStarts();
        while (Math.abs(leftPoint - rightPoint) > 2 * epsilon) {
            changeMaxBorder();
        }

        double middlePoint = (leftPoint + rightPoint) / 2;
        double middleValue = function.getValueAtPoint(middlePoint);

        return new Pair<Double, Double>(middlePoint, middleValue);
    }

    private double calculateLeft() {
        return (leftPoint + rightPoint - epsilon) / 2;
    }

    private double calculateRight() {
        return (leftPoint + rightPoint + epsilon) / 2;
    }

    private void changeMinBorder() {

        double newLeftPoint = calculateLeft();
        double newRightPoint = calculateRight();

        double newLeftValue = function.getValueAtPoint(newLeftPoint);
        double newRightValue = function.getValueAtPoint(newRightPoint);

        if (newLeftValue > newRightValue) {
            leftPoint = newLeftPoint;
        } else {
            rightPoint = newRightPoint;
        }
    }

    private void changeMaxBorder() {

        double newLeftPoint = calculateLeft();
        double newRightPoint = calculateRight();

        double newLeftValue = function.getValueAtPoint(newLeftPoint);
        double newRightValue = function.getValueAtPoint(newRightPoint);

        if (newRightValue > newLeftValue) {
            leftPoint = newLeftPoint;
        } else {
            rightPoint = newRightPoint;
        }
    }

}
