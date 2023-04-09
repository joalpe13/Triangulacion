package org.example;

import java.util.HashMap;
import java.util.Map;

public class Intersection extends GeneralEquation {

    private GeneralEquation Y;

    private GeneralEquation X;

    protected Map<String, Double> coordinates = new HashMap<String, Double>();

    public static boolean thereIsImaginary = false;

    public Intersection(GeneralEquation eq1, GeneralEquation eq2) {
        super();
        this.x2 = eq1.x2 - eq2.x2;
        this.y2 = eq1.y2 - eq2.y2;
        this.x = eq1.x - eq2.x;
        this.y = eq1.y - eq2.y;
        this.c = eq1.c - eq2.c;

        if (this.y != 0) {
            this.Y = new GeneralEquation();
            this.Y.x = -this.x / this.y;
            this.Y.c = -this.c / this.y;
        } else {
            this.X = new GeneralEquation();
            this.X.x = -this.c / this.x;
        }
        this.CalculateIntersections(eq1);
    }

    public void CalculateIntersections(GeneralEquation eq1) {
        GeneralEquation eqIntersection = (GeneralEquation) eq1.clone();
        if (this.y != 0) {
            eqIntersection.x2 += Math.pow(this.Y.x, 2);
            eqIntersection.x += 2 * this.Y.x * this.Y.c + eqIntersection.y * this.Y.x;
            eqIntersection.c += Math.pow(this.Y.c, 2) + eqIntersection.y * this.Y.c;
            eqIntersection.y2 = 0;
            eqIntersection.y = 0;
            System.out.println(eqIntersection);
            System.out.println("calculo de raiz " + Math.sqrt(Math.pow(eqIntersection.x, 2) - 4 * eqIntersection.x2 * eqIntersection.c));
            if (Math.sqrt(Math.pow(eqIntersection.x, 2) - 4 * eqIntersection.x2 * eqIntersection.c) >= 0) {
                double x1 = Math.round((-eqIntersection.x + Math.sqrt(Math.pow(eqIntersection.x, 2) - 4 * eqIntersection.x2 * eqIntersection.c)) / (2 * eqIntersection.x2));
                double x2 = Math.round((-eqIntersection.x - Math.sqrt(Math.pow(eqIntersection.x, 2) - 4 * eqIntersection.x2 * eqIntersection.c)) / (2 * eqIntersection.x2));
                double y1 = Math.round(this.Y.c + this.Y.x * x1);
                double y2 = Math.round(this.Y.c + this.Y.x * x2);
                coordinates.put("x1", x1);
                coordinates.put("y1", y1);
                coordinates.put("x2", x2);
                coordinates.put("y2", y2);
                System.out.println("Coordinates " + this.coordinates);
            } else {
                thereIsImaginary = true;
                System.out.println("imaginary in x");
            }
        } else {
            eqIntersection.c += Math.pow(this.X.x, 2) + eqIntersection.x * this.X.x;
            eqIntersection.x2 = 0;
            eqIntersection.x = 0;
            //eqIntersection.y and eqIntersection.y2 continue equal
            System.out.println(eqIntersection);
            System.out.println("calculo de raiz" + Math.sqrt(Math.pow(eqIntersection.x, 2) - 4 * eqIntersection.x2 * eqIntersection.c));
            if (Math.sqrt(Math.pow(eqIntersection.x, 2) - 4 * eqIntersection.x2 * eqIntersection.c) >= 0) {
                double x1 = Math.round(this.X.x);
                double x2 = Math.round(this.X.x);
                double y1 = Math.round((-eqIntersection.y + Math.sqrt(Math.pow(eqIntersection.y, 2) - 4 * eqIntersection.y2 * eqIntersection.c)) / (2 * eqIntersection.y2));
                double y2 = Math.round((-eqIntersection.y - Math.sqrt(Math.pow(eqIntersection.y, 2) - 4 * eqIntersection.y2 * eqIntersection.c)) / (2 * eqIntersection.y2));

                coordinates.put("x1", x1);
                coordinates.put("y1", y1);
                coordinates.put("x2", x2);
                coordinates.put("y2", y2);
                System.out.println("Coordinates " + this.coordinates);
            } else {
                thereIsImaginary = true;
                System.out.println("imaginary in y");
            }
        }
    }
}