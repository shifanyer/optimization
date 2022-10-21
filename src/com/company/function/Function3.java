package com.company.function;

public class Function3 extends Function {

    private final Pair<Double, Double> point;
    private final Pair<Double, Double> gradValues;
    private final Function2 originalFunction;

    public Function3(Pair<Double, Double> point, Pair<Double, Double> gradValues, Function2 originalFunction) {
        this.point = point;
        this.gradValues = gradValues;
        this.originalFunction = originalFunction;
    }

    @Override
    public double getValueAtPoint(double lambda) {
        double gradLen = originalFunction.getGradLengthAtPoint(point.getA(), point.getB());
        double newX = point.getA() - lambda * gradValues.getA() / gradLen;
        double newY = point.getB() - lambda * gradValues.getB() / gradLen;
        return originalFunction.getValueAtPoint(newX, newY);
    }

}
