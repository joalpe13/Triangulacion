package org.example;

public class GeneralEquation implements Cloneable {
    protected double x2;
    protected double y2;
    protected double x;
    protected double y;
    protected double c;

    // CONSTRUCTOR
    public GeneralEquation() {
    }

    public GeneralEquation(double a, double b, double r) {
        this.x2 = 1;
        this.y2 = 1;
        this.x = -2 * a;
        this.y = -2 * b;
        this.c = Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(r, 2);
        System.out.println(this);
    }

    //GETTERS AND SETTERS
    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "GeneralEquation{" +
                x2 +"x2, " +
                y2 +"y2, "  +
                x +"x, " +
                y +"y, " +
                c +
                '}';
    }

    //CLONE
    public Object clone() {
        GeneralEquation eq = null;
        try {
            eq = (GeneralEquation) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return eq;
    }

}
