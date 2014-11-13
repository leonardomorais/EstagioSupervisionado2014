package Validacoes;

import java.text.DecimalFormat;

/**
 *
 * @author Leonardo
 */
public class RetornaDecimal {

    public String retornaDecimal(double valor, int casas) {
        String formato = "";
        for (int i = 1; i <= casas; i++) {
            formato = formato + "0";
        }
        formato = formato + ".00";
        DecimalFormat df = new DecimalFormat(formato);
        formato = (df.format(valor).replace(".", "").replace(",", ""));
        return removeZeros(formato);
    }

    public String retornaDecimal(double valor) {
        String formato = "";
        formato = formato + ".00";
        DecimalFormat df = new DecimalFormat(formato);
        return df.format(valor).replace(",", ".");
    }

    public String removeZeros(String str) {
        while (str.startsWith("0")){
            str = str.substring(1, str.length());
        }
        
        return str;
    }
}
