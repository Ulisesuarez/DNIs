package org.mvpigs.DNIregex;


import org.mvpigs.DNI.TablaDNIs;

import java.io.IOException;

public class DniCif {

    private  String NIForignial;
    private Character letraControl = null;
    private String dni = null;
    private Boolean numeroSano = false;
    private Boolean letraSana = false;
    private Boolean dniCifSano = false;
    // Composición (agregación) "Has - a" / "Tiene - un"
    private char[] tabla = TablaDNIs.getTabla();

    /* Constructores */

    public DniCif(String dni) {
        this.NIForignial =dni;
        this.dni = ConvertNIE(dni);

    }

    /* Encapsulacion */

    public void setDni(String cadena) {
        this.NIForignial = cadena;
        this.dni = ConvertNIE(cadena);
    }

    public String getDni() {
        return this.dni;
    }

    private void setNumeroSano(Boolean valor) {
        this.numeroSano = valor;
    }

    public Boolean getNumeroSano() {
        return this.numeroSano;
    }

    private void setLetraSana(Boolean valor) {
        this.letraSana = valor;
    }

    public Boolean getLetraSana() {
        return this.letraSana;
    }

    public void setDniCifSano(Boolean valor) {
        this.dniCifSano = valor;
    }

    public Boolean getDniCifSano() {
        return this.dniCifSano;
    }
    /*
     * Lógica
     */

    /* Interfaz Pública */

    public Boolean checkCIF() {
        setDniCifSano(checkDni() && checkLetra());
        return getDniCifSano();
    }

    public Boolean checkDni() {
        setNumeroSano(checkLongitud() && stringEsNumero(getParteNumericaDni()));
        return getNumeroSano();
    }

    public Boolean checkLetra() {
        if (getNumeroSano()) {
            setLetraSana(Character.isUpperCase(getParteAlfabeticaDni()) && checkLetraValida());
            return getLetraSana();
        } else {
            return false;
        }
    }

    public void obtenerLetra() throws IOException {// calcularLetra no puede ejecutarse si antes no se cumplen las condiciones previas en checkDni
        // y checkletra
        try {
            if ( getNumeroSano() ){
            this.letraControl = TablaDNIs.crearLetra(getParteNumericaDni()); }
            else {
                throw new IOException();
            }
        } catch (IOException exc) {
            System.out.println("Parte numérica del DNI no está sana");
        }
    }

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

    public Character getParteAlfabeticaDni() {
        return dni.charAt(dni.length() - 1);
    }

    public Boolean checkLetraValida() {
        try{
            obtenerLetra();
            return getParteAlfabeticaDni() == this.letraControl;
        } catch(IOException exc){
            return false;
        }

    }
    public String ConvertNIE(String NIF){
        String parteInicial=NIF.substring(0,NIF.length()-1);
        String parteFinal =NIF.substring(NIF.length()-1);
        parteInicial = parteInicial.replace("X", "0").replace("Y", "1").replace("Z", "2");

    return parteInicial+parteFinal;}


}