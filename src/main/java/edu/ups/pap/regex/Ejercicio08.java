package edu.ups.pap.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** E08: Análisis de registros. Contrato completo en README.md. */
public class Ejercicio08 {
    private static final String NIVEL = "(INFO|WARN|ERROR)";
    private static final String OCTETO = "(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])";
    private static final String IP = "(" + OCTETO + "\\." + OCTETO + "\\." + OCTETO + "\\." + OCTETO + ")";
    private static final String CODIGO = "([THP](?!000)[0-9]{3})";
    private static final String VALOR = "(-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?)";

    private static final String TRAMA_VALIDA =
        "(?:T(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;C"
        + "|H(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;PCT"
        + "|P(?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;HPA)";

    public static final Pattern FORMATO_LINEA = Pattern.compile(
        NIVEL + " " + IP + " (?=" + TRAMA_VALIDA + "$)" + CODIGO + ";" + VALOR + ";(C|PCT|HPA)"
    );

    public static List<String> analizar(String texto) {
        List<String> resultados = new ArrayList<>();
        if (texto == null || texto.isEmpty()) {
            return resultados;
        }

        String[] lineas = texto.split("\\r?\\n");
        for (String linea : lineas) {
            Matcher matcher = FORMATO_LINEA.matcher(linea);
            if (matcher.matches()) {
                resultados.add(
                    matcher.group(1) + "|" +
                    matcher.group(2) + "|" +
                    matcher.group(3) + "|" +
                    matcher.group(4) + "|" +
                    matcher.group(5)
                );
            }
        }
        return resultados;
    }
}
