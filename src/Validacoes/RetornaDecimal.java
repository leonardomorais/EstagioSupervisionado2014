/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacoes;

import java.text.DecimalFormat;

/**
 *
 * @author Leonardo
 */
public class RetornaDecimal {

    public String retornaDecimal(double valor,int casas) {
        String formato = "";
        for (int i = 1; i<= casas; i++){
            formato = formato+"0";
        }
        formato = formato + ".00";
        DecimalFormat df = new DecimalFormat(formato);
        //System.out.println(df.format(valor));
        return df.format(valor).replace(",", ".");
    }
    
    public String retornaDecimal(double valor){
        String formato = "";
        formato = formato + ".00";
        DecimalFormat df = new DecimalFormat(formato);
        return df.format(valor).replace(",", ".");
    }

}
