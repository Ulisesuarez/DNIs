package org.mvpigs.DNI;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestTablaDNIs {
	@Before
	public void caso(){
		DNI dniprueba=new DNI("43218578Z");
	};

	@Test
	public void testTablaDNIs() {
		char[] laTabla=TablaDNIs.getTabla();
		Assert.assertEquals( 'T',laTabla[0]);
		Assert.assertEquals(23,laTabla.length);
	}
	//Se obtiene el resto de dividir el número de DNI entre 23. 
	
	@Test
	public void testResto(){
		DNI dniprueba=new DNI("43218578Z");
		
		Assert.assertEquals('Z',TablaDNIs.crearLetra(dniprueba.getNumero()));
		
	}

	@Test
	public void testCrearLetra(){
		DNI dniprueba=new DNI("43218578Z");
	Assert.assertEquals('Z',TablaDNIs.crearLetra(dniprueba.getNumero()));
	
	}

	@Test
	public void testOtroConstructor(){
		DNI dniprueba=new DNI("47455398");
	Assert.assertEquals('G',TablaDNIs.crearLetra(dniprueba.getNumero()));
}
	}
