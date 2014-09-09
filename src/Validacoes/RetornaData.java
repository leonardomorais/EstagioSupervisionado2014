package Validacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
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

    public String retornaSomaData(String data, int dias){
        LocalDate dt;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (data.equals("")){
            dt = LocalDate.parse(retornaDataAtual(), formato);
        }
        else{
            dt = LocalDate.parse(data, formato);
        }
        dt = dt.plusDays(dias);
        if (dt.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            dt = dt.plusDays(1);
        }
        return dt.format(formato);
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
    
    public String somaPeriodo(String periodo, int quantidade){
        LocalDate data = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        switch(periodo){
            case "DIAS":
                data = data.plusDays(quantidade);
            break;
            
            case "MESES":
                data = data.plusMonths(quantidade);
            break;
            
            case "ANOS":
                data = data.plusYears(quantidade);
            break;
            
            default :
                data = data.plusWeeks(quantidade);
        }
        return data.format(formato);
    }
    
    public String periodoAnterior(String periodo, int quantidade){
        LocalDate data = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        switch(periodo){
            case "DIAS":
                data = data.minusDays(quantidade);
            break;
            
            case "MESES":
                data = data.minusMonths(quantidade);
            break;
            
            case "ANOS":
                data = data.minusYears(quantidade);
            break;
            
            default :
                data = data.minusWeeks(quantidade);
        }
        return data.format(formato);
    }
}
