package org.mvpigs.DNI;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestDNI {

	@Test
	public void testDNI() {
		DNI dniprueba=new DNI("12345678A");
		Assert.assertEquals(dniprueba.getIdentificacion(),"12345678A");
	}

}
