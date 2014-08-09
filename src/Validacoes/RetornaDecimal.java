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
        String tresUltimos = str.substring(str.length()-3, str.length());
        str = str.substring(0, str.length()-3);
        
        str = str.replace("0", "");
        return str + tresUltimos;
    }
}
