package Validacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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

//    public String retornaDataAtual(Boolean comMascara) {
//        String dataAtual = "";
//        Date data = new Date();
//        String dia = "" + data.getDate();
//        String mes = "" + String.valueOf(data.getMonth() + 1);
//        String ano = "" + (1900 + data.getYear());
//
//        if (Integer.parseInt(mes) <= 9) {
//            mes = "0" + mes;
//        }
//        if (Integer.parseInt(dia) <= 9) {
//            dia = "0" + dia;
//        }
//
//        dataAtual = dia + mes + ano;
//
//        if (comMascara) {
//            dataAtual = dia + "/" + mes + "/" + ano;
//        }
//
//        return dataAtual;
//    }
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

    // copiado de AulaPOO 2013
    public String retornaSomaData(String data, int dias) {
        SimpleDateFormat sDate = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        if (data.equals("")) {
            Date date = new Date();
            calendar.setTime(date);
        } else {
            Date xy = new Date(data);
            calendar.setTime(xy);
        }
        calendar.add(Calendar.DATE, dias);
        if (calendar.getTime().getDay() == 0) {
            // domingo
            calendar.add(calendar.DATE, 1);
        }
        return (sDate.format(calendar.getTime()));
    }

    public boolean dataValida(String data){
        boolean valida;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        
        try{
            Date dt = formato.parse(data);
            if (dt.compareTo(new Date()) < 0){
                valida = false;
            }
            else{
                valida = true;
            }
        }
        catch(ParseException ex){
            valida = false;
        }
        return valida;
    }
    
    public int comparaData(String data){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dtParam;
        try {
            dtParam = formato.parse(data);
            
        } catch (ParseException ex) {
            Logger.getLogger(RetornaData.class.getName()).log(Level.SEVERE, null, ex);
            dtParam = new Date();
            
        }
        return dtParam.compareTo(new Date());
    }
}
