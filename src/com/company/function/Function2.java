package com.company.function;

public class Function2 {
    public final String stringFunction = "4x + 6y - 2x^2 - 2xy - 2y^2";
    public final String stringFirstProizvodnayaX = "4 - 4x - 2y";
    public final String stringFirstProizvodnayaY = "6 - 2x - 4y";

    public double getValueAtPoint(double x, double y) {
        return 4 * x + 6 * y - 2 * Math.pow(x, 2) - 2 * x * y - 2 * Math.pow(y, 2);
    }

    public Pair<Double, Double> getGradAtPoint(double x, double y) {
        return new Pair(getGradXValue(x, y), getGradYValue(x, y));
    }

    public double getGradLengthAtPoint(double x, double y) {
        double first = getGradXValue(x, y);
        double second = getGradYValue(x, y);
        return Math.pow(first * first + second * second, 0.5);
    }

    private double getGradXValue(double x, double y) {
        return 4 - 4 * x - 2 * y;
    }

    private double getGradYValue(double x, double y) {
        return 6 - 2 * x - 4 * y;
    }

}
