package com.company.method;

import com.company.function.Function;
import com.company.function.Pair;

public class ChordsMethod implements Method {

    private final Function function;
    private final double epsilon;

    private double leftPoint;
    private double rightPoint;

    private double startLeftPoint;
    private double startRightPoint;


    public ChordsMethod(Function function, double startLeftPoint, double startRightPoint, double epsilon) {
        this.function = function;
        this.epsilon = epsilon;
        this.startLeftPoint = startLeftPoint;
        this.startRightPoint = startRightPoint;
        this.leftPoint = startLeftPoint;
        this.rightPoint = startRightPoint;
    }

    @Override
    public Pair<Double, Double> calculateMinimum() {

        double currentPoint = getXTilda();

        while (Math.abs(function.getFirstDerivativeValueAtPoint(currentPoint)) > epsilon) {
            boolean middleSign = function.getFirstDerivativeValueAtPoint(currentPoint) > 0;
            boolean rightSign = function.getFirstDerivativeValueAtPoint(rightPoint) > 0;
            if (middleSign == rightSign) {
                rightPoint = currentPoint;
            }
            else {
                leftPoint = currentPoint;
            }
            currentPoint = getXTilda();
        }

        if (function.getValueAtPoint(currentPoint) > function.getValueAtPoint(startLeftPoint)) {
            currentPoint = startLeftPoint;
        }

        if (function.getValueAtPoint(currentPoint) > function.getValueAtPoint(startRightPoint)) {
            currentPoint = startRightPoint;
        }

        return new Pair(currentPoint, function.getValueAtPoint(currentPoint));
    }

    @Override
    public Pair<Double, Double> calculateMaximum() {

        double currentPoint = getXTilda();

        while (Math.abs(function.getFirstDerivativeValueAtPoint(currentPoint)) > epsilon) {
            boolean middleSign = function.getFirstDerivativeValueAtPoint(currentPoint) > 0;
            boolean rightSign = function.getFirstDerivativeValueAtPoint(rightPoint) > 0;
            if (middleSign == rightSign) {
                rightPoint = currentPoint;
            }
            else {
                leftPoint = currentPoint;
            }
            currentPoint = getXTilda();
        }

        if (function.getValueAtPoint(currentPoint) < function.getValueAtPoint(startLeftPoint)) {
            currentPoint = startLeftPoint;
        }

        if (function.getValueAtPoint(currentPoint) < function.getValueAtPoint(startRightPoint)) {
            currentPoint = startRightPoint;
        }

        return new Pair(currentPoint, function.getValueAtPoint(currentPoint));
    }

    public double getXTilda() {
        return leftPoint - (leftPoint - rightPoint)
                * function.getFirstDerivativeValueAtPoint(leftPoint)
                / (function.getFirstDerivativeValueAtPoint(leftPoint)
                - function.getFirstDerivativeValueAtPoint(rightPoint));
    }

}
