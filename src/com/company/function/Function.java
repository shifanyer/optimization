package com.company.function;

public class Function {
    public final String stringFunction = "x^5 - 5x^3 + 10x^2 - 5x";
    public final String stringFirstProizvodnaya = "5*x^4 - 15x^2 + 20x - 5";
    public final String stringSecondProizvodnaya = "20*x^3 - 30x + 20";

    public double getValueAtPoint(double x) {
        return Math.pow(x, 5) - 5 * Math.pow(x, 3) + 10 * Math.pow(x, 2) - 5 * x;
    }

    public double getFirstDerivativeValueAtPoint(double x) {
        return 5 * Math.pow(x, 4) - 15 * Math.pow(x, 2) + 20 * x - 5;
    }

    public double getSecondDerivativeValueAtPoint(double x) {
        return 20 * Math.pow(x, 3) - 30 * x + 20;
    }


}
