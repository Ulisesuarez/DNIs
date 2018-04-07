package org.mvpigs.DNIregex;

import org.mvpigs.DNI.TablaDNIs;

public class DniCifValidacionRegex {


    private  String NIForignial;
    private Character letraControl = null;
    private String dni = null;
    private String tipo;
    private Boolean valido=false;

    /* Constructores */

    public DniCifValidacionRegex(String dni) {
        this.NIForignial =dni;
        this.dni = ConvertNIE(dni);
        setLetraControl();
        setTipoDocumento();
        setValido();

    }

    /* Encapsulacion */

    public void setDni(String cadena) {
        this.NIForignial = cadena;
        this.dni = ConvertNIE(cadena);
    }

    public String getDni() {
        return this.dni;
    }


    /*
     * Lógica
     */

    /* Interfaz Pública */

        public Boolean checkLongitud() {
        return getDni().length() == 9;
    }

    public Boolean stringEsNumero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            } else ;
        }
        return true;
    }

    public String getParteNumericaDni() {
        return (String) dni.substring(0, dni.length() - 1);
    }

    public void setLetraControl() throws NumberFormatException,ArrayIndexOutOfBoundsException {
            if(stringEsNumero(getParteNumericaDni())){
                try{
                    this.letraControl = TablaDNIs.crearLetra(getParteNumericaDni());}
                catch (NumberFormatException e){
                    System.out.println("Documento inválido");
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Documento inválido");
                }
            }
    }
    public String ConvertNIE(String NIF){
        String parteInicial=NIF.substring(0,NIF.length()-1);
        String parteFinal =NIF.substring(NIF.length()-1);
        parteInicial = parteInicial.replace("X", "0").replace("Y", "1").replace("Z", "2");

        return parteInicial+parteFinal;}

        public void setTipoDocumento(){

            if (this.dni.equals(this.NIForignial)){
                this.tipo = "DNI";
            } else {
                this.tipo = "NIE";
            }
        }

    public void setValido(){
            this.valido=NIF_Validator.checkNIF(this.tipo,this.NIForignial,this.letraControl);
    }
    public boolean getValido(){
            return this.valido;
    }

    public Character getLetraControl() {
        return letraControl;
    }

    public String getTipo(){
            return this.tipo;
    }
}

