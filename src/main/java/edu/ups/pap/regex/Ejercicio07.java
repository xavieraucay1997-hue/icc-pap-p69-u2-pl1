package edu.ups.pap.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** E07: Extracción de tramas. Contrato completo en README.md. */
public class Ejercicio07 {
    private static final String DELIM = "[ \\t\\n\\r\\x0B\\f\\[\\](){}]";
    private static final String TRAMA = "(?:T(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;C"
        + "|H(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;PCT"
        + "|P(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;HPA)";

    public static final Pattern FORMATO = Pattern.compile(
        "(?:^|(?<=" + DELIM + "))" + TRAMA + "(?=$|" + DELIM + ")"
    );

    public static List<String> extraer(String texto) {
        List<String> resultados = new ArrayList<>();
        if (texto == null) {
            return resultados;
        }

        Matcher matcher = FORMATO.matcher(texto);
        while (matcher.find()) {
            resultados.add(matcher.group());
        }
        return resultados;
    }
}