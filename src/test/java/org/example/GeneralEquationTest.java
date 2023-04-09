package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class GeneralEquationTest {

    @Test
    public void TestGeneralEquation() {

        GeneralEquation eq1 = new GeneralEquation(3,4,2);
        GeneralEquation eq2 = new GeneralEquation(4,5,3);
        GeneralEquation eq3 = new GeneralEquation(5,6,4);

        assertEquals("GeneralEquation{1.0x2, 1.0y2, -6.0x, -8.0y, 21.0}",eq1.toString());
        assertEquals("GeneralEquation{1.0x2, 1.0y2, -8.0x, -10.0y, 32.0}",eq2.toString());
        assertEquals("GeneralEquation{1.0x2, 1.0y2, -10.0x, -12.0y, 45.0}",eq3.toString());
    }

}
