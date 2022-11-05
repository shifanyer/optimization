package com.company;

import com.company.function.Function;
import com.company.function.Function2;
import com.company.function.Pair;
import com.company.method.*;

public class Main {

    public static void main(String[] args) {
//        lab 1


        Function function = new Function();
        double leftPoint = -3;
        double rightPoint = -2;
        double epsilon = 0.05;

        Method dihotomyHandler = new DihotomyHandler(function, leftPoint, rightPoint, epsilon);
        Method goldenSplit = new GoldenSplit(function, leftPoint, rightPoint, epsilon);
        Method chordsMethod = new ChordsMethod(function, leftPoint, rightPoint, epsilon);
        Method newtonMethod = new NewtonMethod(function, leftPoint, rightPoint, epsilon);
        Method squareInterpol = new SquareInterpol(function, leftPoint, rightPoint, epsilon);

        System.out.println(dihotomyHandler.calculateMinimum().getB());
        System.out.println(goldenSplit.calculateMinimum().getB());
        System.out.println(chordsMethod.calculateMinimum().getB());
        System.out.println(newtonMethod.calculateMinimum().getB());
//        System.out.println(squareInterpol.calculateMinimum().getB());

        System.out.println();

        System.out.println(dihotomyHandler.calculateMaximum().getB());
        System.out.println(goldenSplit.calculateMaximum().getB());
        System.out.println(chordsMethod.calculateMaximum().getB());
        System.out.println(newtonMethod.calculateMaximum().getB());
        System.out.println(squareInterpol.calculateMaximum().getB());



//        lab2
/*
        Function2 function = new Function2();
        double epsilon = 0.05;
        double startX = 0;
        double startY = 0;

        Downhill speedyDown = new Downhill(function, epsilon, startX, startY);

        Pair<Double, Double> res = speedyDown.calculateExtr();
        System.out.println("x1: " + res.getA());
        System.out.println("x2: " + res.getB());
        System.out.println("f(x1, x2): " + function.getValueAtPoint(res.getA(), res.getB()));

 */

    }
}
