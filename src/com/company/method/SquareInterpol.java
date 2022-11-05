package com.company.method;

import com.company.function.Function;
import com.company.function.Pair;

import java.util.*;

public class SquareInterpol implements Method {

    private final Function function;
    private final double epsilon;

    private final double startLeftPoint;
    private final double startRightPoint;

    private double x1;
    private double x2;
    private double x3;

    public SquareInterpol(Function function, double startLeftPoint, double startRightPoint, double epsilon) {
        this.function = function;
        this.epsilon = epsilon;
        this.startLeftPoint = startLeftPoint;
        this.startRightPoint = startRightPoint;
        this.x1 = (startLeftPoint + startRightPoint) / 2;
        this.x2 = startRightPoint;
        this.x3 = startLeftPoint;
    }

    @Override
    public Pair<Double, Double> calculateMinimum() {
        while (Math.abs(function.getValueAtPoint(x2) - function.getValueAtPoint(x3)) > epsilon) {
            double newX = getXStar();
            setMinOrderedXValues(newX);
        }
        double minPoint = (x2 + x3) / 2;
        double minValue = function.getValueAtPoint(minPoint);
        return new Pair(minPoint, minValue);
    }

    @Override
    public Pair<Double, Double> calculateMaximum() {
        while (Math.abs(function.getValueAtPoint(x2) - function.getValueAtPoint(x3)) > epsilon) {
            double newX = getXStar();
            setMaxOrderedXValues(newX);
        }
        double minPoint = (x2 + x3) / 2;
        double minValue = function.getValueAtPoint(minPoint);
        return new Pair(minPoint, minValue);
    }

    private Double getXStar() {
        double half = 0.5;
        double x1DiffSquare = (x2 * x2 - x3 * x3) * function.getValueAtPoint(x1);
        double x2DiffSquare = (x3 * x3 - x1 * x1) * function.getValueAtPoint(x2);
        double x3DiffSquare = (x1 * x1 - x2 * x2) * function.getValueAtPoint(x3);

        double x1Diff = (x2 - x3) * function.getValueAtPoint(x1);
        double x2Diff = (x3 - x1) * function.getValueAtPoint(x2);
        double x3Diff = (x1 - x2) * function.getValueAtPoint(x3);

        return half * ((x1DiffSquare + x2DiffSquare + x3DiffSquare) / (x1Diff + x2Diff + x3Diff));
    }

    private void setMinOrderedXValues(double x) {
        List<Pair<Double, Double>> xes = Arrays.asList(
                new Pair(x1, function.getValueAtPoint(x1)),
                new Pair(x2, function.getValueAtPoint(x2)),
                new Pair(x3, function.getValueAtPoint(x3)),
                new Pair(x, function.getValueAtPoint(x))
        );
        Collections.sort(xes, new PairComparator());
        x1 = xes.get(1).getA();
        x2 = xes.get(0).getA();
        x3 = xes.get(2).getA();
    }

    private void setMaxOrderedXValues(double x) {
        List<Pair<Double, Double>> xes = Arrays.asList(
                new Pair(x1, function.getValueAtPoint(x1)),
                new Pair(x2, function.getValueAtPoint(x2)),
                new Pair(x3, function.getValueAtPoint(x3)),
                new Pair(x, function.getValueAtPoint(x))
        );
        Collections.sort(xes, new PairComparator());
        x1 = xes.get(2).getA();
        x2 = xes.get(1).getA();
        x3 = xes.get(3).getA();
    }

}

class PairComparator implements Comparator<Pair<Double, Double>> {
    @Override
    public int compare(Pair<Double, Double> o1, Pair<Double, Double> o2) {
        return o1.getB() < o2.getB() ? -1 : 1;
    }
}
