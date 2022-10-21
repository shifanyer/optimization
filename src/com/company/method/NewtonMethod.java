package com.company.method;

import com.company.function.Function;
import com.company.function.Pair;

public class NewtonMethod implements Method {

    private final Function function;
    private final double epsilon;

    private double startLeftPoint;
    private double startRightPoint;

    public NewtonMethod(Function function, double startLeftPoint, double startRightPoint, double epsilon) {
        this.function = function;
        this.epsilon = epsilon;
        this.startLeftPoint = startLeftPoint;
        this.startRightPoint = startRightPoint;
    }


    @Override
    public Pair<Double, Double> calculateMinimum() {
        double x0 = (startLeftPoint + startRightPoint) / 2;

        while (function.getFirstDerivativeValueAtPoint(x0) > epsilon) {
            x0 = x0 - function.getFirstDerivativeValueAtPoint(x0) / function.getSecondDerivativeValueAtPoint(x0);
        }

        if (function.getValueAtPoint(x0) > function.getValueAtPoint(startLeftPoint)) {
            x0 = startLeftPoint;
        }

        if (function.getValueAtPoint(x0) > function.getValueAtPoint(startRightPoint)) {
            x0 = startRightPoint;
        }

        return new Pair(x0, function.getValueAtPoint(x0));

    }

    @Override
    public Pair<Double, Double> calculateMaximum() {
        double x0 = (startLeftPoint + startRightPoint) / 2;

        while (function.getFirstDerivativeValueAtPoint(x0) > epsilon) {
            x0 = x0 - function.getFirstDerivativeValueAtPoint(x0) / function.getSecondDerivativeValueAtPoint(x0);
        }

        if (function.getValueAtPoint(x0) < function.getValueAtPoint(startLeftPoint)) {
            x0 = startLeftPoint;
        }

        if (function.getValueAtPoint(x0) < function.getValueAtPoint(startRightPoint)) {
            x0 = startRightPoint;
        }

        return new Pair(x0, function.getValueAtPoint(x0));

    }

}
