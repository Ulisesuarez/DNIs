package org.mvpigs.DNI;

public class TablaDNIs {
	
	private static char [] Tabla={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

	public static char[] getTabla() {
		
		return Tabla;
	}

	public static char crearLetra(String numero) {

		int numeroInt=Integer.valueOf(numero);
		
		int indiceTabla = numeroInt % (Tabla.length);
		return Tabla[indiceTabla];
		
	}
	public static char crearLetra(Integer numero) {


		int indiceTabla = numero % (Tabla.length);
		return Tabla[indiceTabla];

	}
}
