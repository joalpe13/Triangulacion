package org.example;

public class Main {
    public static double Distancia(EspaceObject a, EspaceObject b) {
        double d = Math.sqrt(Math.pow((a.x - b.x), 2)
                + Math.pow((a.y - b.y), 2));
        return d;
    }

    public static void main(String[] args) {
        //Satellites
        EspaceObject kenobi = new EspaceObject(-500, -200);
        EspaceObject skywolker = new EspaceObject(100, -100);
        EspaceObject sato = new EspaceObject(500, 100);
        //Spacecraft
        EspaceObject spacecraft = new EspaceObject(300, 200);

        //General Equation Skywolker circumference
        System.out.println("Skywolker");
        GeneralEquation eqSkywolker = new GeneralEquation(skywolker.x, skywolker.y, Distancia(skywolker,spacecraft));
        //General Equation Sato circumference
        System.out.println("Sato");
        GeneralEquation eqSato = new GeneralEquation(sato.x,sato.y,Distancia(sato,spacecraft));
        //General Equation Kenobi circumference
        System.out.println("Kenobi");
        GeneralEquation eqKenobi = new GeneralEquation(kenobi.x,kenobi.y,Distancia(kenobi,spacecraft));
        //Gets the equation bewtween skywolker and sato
        System.out.println("skywolkersato intersection");
        Intersection skywolkerSatoIntersection = new Intersection(eqSkywolker,eqSato);
        //Gets the equation between kenobi and skywolker
        System.out.println("kenobiskywolker intersection");
        Intersection kenobiSkywolkerIntersection = new Intersection(eqSkywolker,eqKenobi);
        //Gets the coordinates of the spacecraft
        new Triangulation(skywolkerSatoIntersection, kenobiSkywolkerIntersection);
    }
}
