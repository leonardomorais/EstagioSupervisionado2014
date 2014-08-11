package Validacoes;

import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class RetornaData {

    public String retornaDataAtual(Boolean comMascara) {
        String dataAtual = "";
        Date data = new Date();
        String dia = "" + data.getDate();
        String mes = "" + String.valueOf(data.getMonth() + 1);
        String ano = "" + (1900 + data.getYear());

        if (Integer.parseInt(mes) <= 9) {
            mes = "0" + mes;
        }
        if (Integer.parseInt(dia) <= 9) {
            dia = "0" + dia;
        }

        dataAtual = dia + mes + ano;

        if (comMascara) {
            dataAtual = dia + "/" + mes + "/" + ano;
        }

        return dataAtual;
    }

    public String retornaHoraAtual() {
        String horaAtual = "";
        Date data = new Date();
        String hora = "" + data.getHours();
        String min = "" + data.getMinutes();
        String seg = "" + data.getSeconds();

        if (Integer.parseInt(hora) < 10) {
            hora = "0" + hora;
        }
        if (Integer.parseInt(min) < 10) {
            min = "0" + hora;
        }
        if (Integer.parseInt(seg) < 10) {
            seg = "0" + hora;
        }

        horaAtual = hora + min + seg;
        return horaAtual;
    }

}
