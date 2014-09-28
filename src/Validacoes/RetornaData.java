package Validacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class RetornaData {

    public String retornaDataAtual() {
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return hoje.format(formato);
    }

    public String retornaSomaData(String data, int dias) {
        LocalDate dt;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (data.equals("")) {
            dt = LocalDate.parse(retornaDataAtual(), formato);
        } else {
            dt = LocalDate.parse(data, formato);
        }
        dt = dt.plusDays(dias);
        if (dt.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            dt = dt.plusDays(1);
        }
        return dt.format(formato);
    }

    public String retornaHoraAtual() {
        LocalDateTime hora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formato);
    }

    public boolean dataValida(String data) {
        boolean valida;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);

        try {
            Date dt = formato.parse(data);
            if (dt.getDay() == 0) {
                // se for um domingo
                valida = false;
            } else {
                if (comparaData(data) < 0) {
                    valida = false;
                } else {
                    valida = true;
                }
            }
        } catch (ParseException ex) {
            valida = false;
        }
        return valida;
    }

    public boolean dataExiste(String data) {
        boolean existe;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);

        try {
            Date dt = formato.parse(data);
            existe = true;
        } catch (ParseException ex) {
            existe = false;
        }
        return existe;
    }

    public int comparaData(String dt1, String dt2) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dtInicio;
        Date dtFim;
        try {
            dtInicio = formato.parse(dt1);
            dtFim = formato.parse(dt2);
        } catch (ParseException ex) {
            dtInicio = new Date();
            dtFim = new Date();
        }
        return dtInicio.compareTo(dtFim);
    }

    public int comparaData(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dtParam;
        Date dtAtual;
        try {
            dtParam = formato.parse(data);
            dtAtual = formato.parse(retornaDataAtual());
        } catch (ParseException ex) {
            Logger.getLogger(RetornaData.class.getName()).log(Level.SEVERE, null, ex);
            dtParam = new Date();
            dtAtual = new Date();
        }
        return dtParam.compareTo(dtAtual);
    }
}
