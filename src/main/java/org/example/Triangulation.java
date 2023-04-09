package org.example;

public class Triangulation {
    private double x;
    private double y;
    private boolean located = false;
    
    public Triangulation(Intersection eq1, Intersection eq2) {
        System.out.println("_________");
        if (Intersection.thereIsImaginary == false) {
            if (eq1.coordinates.get("x1").equals(eq2.coordinates.get("x1"))) {
                if (eq1.coordinates.get("y1").equals(eq2.coordinates.get("y1"))) {
                    x = eq1.coordinates.get("x1");
                    y = eq1.coordinates.get("y1");
                    located = true;
                }
            } else if (eq1.coordinates.get("x2").equals(eq2.coordinates.get("x2"))) {
                if (eq1.coordinates.get("y2").equals(eq2.coordinates.get("y2"))) {
                    x = eq1.coordinates.get("x2");
                    y = eq1.coordinates.get("y2");
                    located = true;
                }
            } 
        } 
        PrintLocation();
    }

    public void PrintLocation() {
        if(located){
            System.out.println("spacecraft " + "x:" + x + " y:" + y);
        }
        else {
            System.out.println("Impossible to locate the spacecraft, incorrect distances");
        }
    }
}
