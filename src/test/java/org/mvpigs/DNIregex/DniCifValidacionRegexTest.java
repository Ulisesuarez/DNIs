package org.mvpigs.DNIregex;

import org.junit.Test;

import static org.junit.Assert.*;

public class DniCifValidacionRegexTest {

    @Test
    public void TestDniCifValidacionRegexTest(){
        DniCifValidacionRegex miDNI =new DniCifValidacionRegex("43218578Z");
        assertEquals("DNI",miDNI.getTipo());
        assertTrue(miDNI.getValido());
        DniCifValidacionRegex DNIfalso =new DniCifValidacionRegex("43218578W");
        assertEquals("DNI",DNIfalso.getTipo());
        assertFalse(DNIfalso.getValido());
    }
    @Test
    public void TestNieCifValidacionRegexTest(){
        DniCifValidacionRegex NIE =new DniCifValidacionRegex("Y4134157J");
        assertEquals("NIE",NIE.getTipo());
        assertTrue(NIE.getValido());
        DniCifValidacionRegex NIEfalso =new DniCifValidacionRegex("Y4134157Z");
        assertEquals("NIE",NIEfalso.getTipo());
        assertFalse(NIEfalso.getValido());
        DniCifValidacionRegex NIEfalso2 =new DniCifValidacionRegex("Z4134157J");
        assertEquals("NIE",NIEfalso2.getTipo());
        assertFalse(NIEfalso2.getValido());
    }

}