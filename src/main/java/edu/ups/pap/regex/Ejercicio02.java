package edu.ups.pap.regex;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** E02: Códigos de dispositivos. Contrato completo en README.md. */
public class Ejercicio02 {
    public static final Pattern FORMATO = Pattern.compile("[THP](?!000)[0-9]{3}");

    public static boolean validar(String texto) {
        return texto != null && FORMATO.matcher(texto).matches();
    }
}