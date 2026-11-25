package edu.ups.pap.regex;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** E01: Palabras del catálogo. Contrato completo en README.md. */


public class Ejercicio01 {
    private final static Pattern REGEX  = Pattern.compile("[a-z]{4,12}");
    public static boolean validar(String texto) {

    /*    if(texto == null){
            return false;

        
        }
        Matcher matcher = REGE X.matcher(texto); 
        if(matcher.matches()){
            return true; 
        }
        return false; 
    */ 

        return texto != null && REGEX.matcher(texto).matches();
 
    }
}
