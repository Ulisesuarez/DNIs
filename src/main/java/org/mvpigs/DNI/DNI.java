package org.mvpigs.DNI;




public class DNI {

	private static final int NUMERO_CARACTERES_DNI = 9;
	private static final int NUMERO_LETRAS_DNI = 1;
	
	public  int numero=0;
	private String identificacion=null;
	private String numeroString=null;
	private char letra;
	private static char[] tabla=TablaDNIs.getTabla();

	public DNI(String secuenciaIdentificadora) {
		
		this.identificacion=secuenciaIdentificadora;
		descifrarInput();
		setLetra();
		
		
		
	}
	
	public void descifrarInput(){
		
if(this.identificacion.length()==NUMERO_CARACTERES_DNI){
			
			this.numeroString=this.identificacion.substring(0, this.identificacion.length()-1);
			if(esNumeroValido()){
				
			this.numero= Integer.parseInt(this.numeroString);}}
		
		else{ if(this.identificacion.length()==NUMERO_CARACTERES_DNI-NUMERO_LETRAS_DNI){
			this.numeroString=this.identificacion;
			if(esNumeroValido()){
			this.numero=Integer.parseInt(this.identificacion);}}
		}
		
	}
	
	
	public void setNumero(int numero) {
		this.numero=numero;
		
	}

	public String getIdentificacion() {

		return this.identificacion;
	}
	
	public int getNumero(){
		return this.numero;
		}
	
	public void setLetra(){
		this.letra=TablaDNIs.crearLetra(this.numero);
	}
	
	public boolean esNumerico(){
		try{
			Integer.parseInt(this.numeroString);
			return true;}
	
		catch(NumberFormatException e){
			
				
			return false;
			}
		}
		
		public boolean esLengthNumeroCorrecta(){
			if (this.numeroString.length()== (NUMERO_CARACTERES_DNI-NUMERO_LETRAS_DNI)){
			return true;}
			else{
				return false;
		}
		}
		
		public boolean esNumeroValido(){
			if (esLengthNumeroCorrecta() && esNumerico()){
				return true;
			}
			else{ return false;}
			
		}
}
	
