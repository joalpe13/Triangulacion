import java.util.HashMap;
import java.util.Map;

public class GeneralEquation implements Cloneable {
    private double x2;
    private double y2;
    private double x;
    private double y;
    private double c;

    private GeneralEquation Y;

    private GeneralEquation X;

    private Map<String, Double> coordinates = new HashMap<String, Double>();

    public static boolean thereIsImaginary = false;

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

    //METHODS
    public void CalculateXY(GeneralEquation eq1, GeneralEquation eq2) {
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
        GeneralEquation eq = (GeneralEquation) eq1.clone();
        if (this.y != 0) {
            eq.x2 += Math.pow(this.Y.x, 2);
            eq.x += 2 * this.Y.x * this.Y.c + eq.y * this.Y.x;
            eq.c += Math.pow(this.Y.c, 2) + eq.y * this.Y.c;
            eq.y2 = 0;
            eq.y = 0;
            System.out.println("xxxxxxx" + eq);
            System.out.println("calculo de raiz " + Math.sqrt(Math.pow(eq.x, 2) - 4 * eq.x2 * eq.c));
            if (Math.sqrt(Math.pow(eq.x, 2) - 4 * eq.x2 * eq.c) >= 0) {
                double x1 = Math.round((-eq.x + Math.sqrt(Math.pow(eq.x, 2) - 4 * eq.x2 * eq.c)) / (2 * eq.x2));
                double x2 = Math.round((-eq.x - Math.sqrt(Math.pow(eq.x, 2) - 4 * eq.x2 * eq.c)) / (2 * eq.x2));
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
            eq.c += Math.pow(this.X.x, 2) + eq.x * this.X.x;
            eq.x2 = 0;
            eq.x = 0;
            //eq.y and eq.y2 continue equal
            System.out.println("xxxxxx" + eq);
            System.out.println("calculo de raiz" + Math.sqrt(Math.pow(eq.x, 2) - 4 * eq.x2 * eq.c));
            if (Math.sqrt(Math.pow(eq.x, 2) - 4 * eq.x2 * eq.c) >= 0) {
                double x1 = Math.round(this.X.x);
                double x2 = Math.round(this.X.x);
                double y1 = Math.round((-eq.y + Math.sqrt(Math.pow(eq.y, 2) - 4 * eq.y2 * eq.c)) / (2 * eq.y2));
                double y2 = Math.round((-eq.y - Math.sqrt(Math.pow(eq.y, 2) - 4 * eq.y2 * eq.c)) / (2 * eq.y2));

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

    public void TriangulationPosition(GeneralEquation eq1, GeneralEquation eq2) {
        System.out.println("_________");
        if (thereIsImaginary == false) {
            if (eq1.coordinates.get("x1").equals(eq2.coordinates.get("x1"))) {
                if (eq1.coordinates.get("y1").equals(eq2.coordinates.get("y1"))) {
                    double x = eq1.coordinates.get("x1");
                    double y = eq1.coordinates.get("y1");
                    System.out.println("Satellite pos" + "x: " + x + "y: " + y);
                }
            } else if (eq1.coordinates.get("x2").equals(eq2.coordinates.get("x2"))) {
                if (eq1.coordinates.get("y2").equals(eq2.coordinates.get("y2"))) {
                    double x = eq1.coordinates.get("x2");
                    double y = eq1.coordinates.get("y2");
                    System.out.println("Nave " + "x:" + x + " y:" + y);
                }
            } else {
                System.out.println("Impossible to locate the ship");
            }
        } else {
            System.out.println("Impossible to locate the ship");
        }
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
                "x2=" + x2 +
                ", y2=" + y2 +
                ", x=" + x +
                ", y=" + y +
                ", c=" + c +
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
