package org.mvpigs.DNIregex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NIF_Validator {

    private static RegexNIF regexNIF = new RegexNIF();
    private static RegexNIF incompletRegexNIF = new RegexNIF();

    public static void main (String[] args) {

        regexNIF.addRegex("DNI","^([0-9]){8}[A-Z&&[^IÑOU]]$");
        regexNIF.addRegex("NIE","^[X-Z]([0-9]){7}[A-Z&&[^IÑOU]]$");
        incompletRegexNIF.addRegex("DNI","^([0-9]){8}");
        incompletRegexNIF.addRegex("NIE","^[X-Z]([0-9]){7}");
        String tipo = args[0];
        int contador = 0;
        for (String arg :args){
            if (contador > 0){
            findPattern(tipo,arg);
            }
            contador++;
        }

    }
    public static String findPattern(String TipoDocumento, String source) {
        String regex= "";
        String matchedText="";
        if (regexNIF.getRegex().containsKey(TipoDocumento)) {
             regex = regexNIF.getRegexValue(TipoDocumento);
        }
        else{
            System.out.println("Por ahora los tipos de documentos contemplados son DNI y NIE");
            return matchedText;
        }

// Compile regex into a Pattern object
        Pattern p = Pattern.compile(regex);

// Get a Matcher object
        Matcher m = p.matcher(source);


// Perform find
        boolean found = false;
        while (m.find()) {
            matchedText = matchedText+m.group();
            System.out.println("Matched Text:" + m.group() +
                    ", Start:" + m.start() +
                    ", " + "End:" + m.end());

// We found at least one match. Set the found flag to true
            found = true;
        }
        if (!found) {
// We did not find any match
            System.out.println("Documento incorrecto");
        }
        return matchedText;
    }

    public static Boolean checkNIF(String TipoDocumento, String source,Character LetraControl) {
        incompletRegexNIF.addRegex("DNI","^([0-9]){8}");
        incompletRegexNIF.addRegex("NIE","^[X-Z]([0-9]){7}");

        String regex= "";
        String matchedText="";
        if (incompletRegexNIF.getRegex().containsKey(TipoDocumento)) {
            try{
            regex = incompletRegexNIF.getRegexValue(TipoDocumento)+String.valueOf(LetraControl)+"$";
            }
            catch (NullPointerException e ){
                return false;
            }
        }
        else{
            System.out.println("Por ahora los tipos de documentos contemplados son DNI y NIE");
            return false;
        }

// Compile regex into a Pattern object
        Pattern p = Pattern.compile(regex);

// Get a Matcher object
        Matcher m = p.matcher(source);


// Perform find
        boolean found = false;
        while (m.find()) {
            matchedText = matchedText+m.group();
            System.out.println("Matched Text:" + m.group() +
                    ", Start:" + m.start() +
                    ", " + "End:" + m.end());

// We found at least one match. Set the found flag to true
            found = true;
        }
        if (!found) {
// We did not find any match
            System.out.println("Documento incorrecto");
        }
        return found;}

}

