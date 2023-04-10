package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangulationTest {
    GeneralEquation eq1 = new GeneralEquation(3,4,2);
    GeneralEquation eq2 = new GeneralEquation(4,5,3);
    GeneralEquation eq3 = new GeneralEquation(5,6,4);

    Intersection intersection1 = new Intersection(eq1, eq2);
    Intersection intersection2 = new Intersection(eq1, eq3);
    Intersection intersection3 = new Intersection(eq2, eq3);

    @Test
    public void TestGeneralEquation() {

        assertEquals("GeneralEquation{1.0x2, 1.0y2, -6.0x, -8.0y, 21.0}",eq1.toString());
        assertEquals("GeneralEquation{1.0x2, 1.0y2, -8.0x, -10.0y, 32.0}",eq2.toString());
        assertEquals("GeneralEquation{1.0x2, 1.0y2, -10.0x, -12.0y, 45.0}",eq3.toString());
    }
    @Test
    public void TestIntersections(){

    }
}
