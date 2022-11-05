package com.company.method;

import com.company.function.Function;
import com.company.function.Function2;
import com.company.function.Function3;
import com.company.function.Pair;

public class Downhill {

    private final Function2 function;
    private final double epsilon;
    private final double startX;
    private final double startY;

//    private static final double lambda = 0.25;

    public Downhill(Function2 function, double epsilon, double startX, double startY) {
        this.function = function;
        this.epsilon = epsilon;
        this.startX = startX;
        this.startY = startY;
    }

    public Pair<Double, Double> calculateExtr() {
        double x = startX;
        double y = startY;

        while (function.getGradLengthAtPoint(x, y) > epsilon) {

            Pair<Double, Double> grad = function.getGradAtPoint(x, y);

            Function minFun = new Function3(new Pair(x, y), grad, function);
            Method dihotomyHandler = new DihotomyHandler(minFun, 0, 100, epsilon);
            double lambda = dihotomyHandler.calculateMaximum().getA();

            double gradLen = function.getGradLengthAtPoint(x, y);
            double newX = x + lambda * grad.getA() / gradLen;
            double newY = y + lambda * grad.getB() / gradLen;

            double oldVal = function.getValueAtPoint(x, y);
            double newVal = function.getValueAtPoint(newX, newY);

            x = newX;
            y = newY;

            if (Math.abs(oldVal - newVal) < epsilon) break;
        }

        return new Pair(x, y);
    }

}
