public class Triangulation {
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
        //Ship
        EspaceObject ship = new EspaceObject(300, 200);

        //General Equation Skywolker circumference
        System.out.println("Skywolker");
        GeneralEquation eqSkywolker = new GeneralEquation(skywolker.x, skywolker.y, Distancia(skywolker,ship));
        //General Equation Sato circumference
        System.out.println("Sato");
        GeneralEquation eqSato = new GeneralEquation(sato.x,sato.y,Distancia(sato,ship));
        //General Equation Kenobi circumference
        System.out.println("Kenobi");
        GeneralEquation eqKenobi = new GeneralEquation(kenobi.x,kenobi.y,Distancia(kenobi,ship));
        //Gets the equation bewtween skywolker and sato
        GeneralEquation skywolkerSato = new GeneralEquation();
        skywolkerSato.CalculateXY(eqSkywolker,eqSato);
        //Gets the equation between kenobi and skywolker
        GeneralEquation kenobiSkywolker = new GeneralEquation();
        kenobiSkywolker.CalculateXY(eqSkywolker,eqKenobi);
        //Gets the final coordinates
        kenobiSkywolker.TriangulationPosition(skywolkerSato, kenobiSkywolker);
    }
}
