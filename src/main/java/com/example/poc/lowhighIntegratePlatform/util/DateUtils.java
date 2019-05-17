package com.example.poc.lowhighIntegratePlatform.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

    private static final String YYYY_MM_DD = "yyyyMMdd";
    private static final String DD_MM_YYYY = "ddMMyyyy";

    static SimpleDateFormat fmt = new SimpleDateFormat(YYYY_MM_DD);
    static SimpleDateFormat fmt2 = new SimpleDateFormat(DD_MM_YYYY);

    private DateUtils() {
        super();
    }

    public static Date toDate(int ano, int mes, int dia) {
        return Date.from(LocalDate.of(ano, mes == 0? 1: mes, dia == 0? 1: dia).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Formata a data para o formato que o arquivo do DCC espera
     *
     * @param data
     * @return
     */
    public static String formatYMD(Date data) {
        if (data == null) {
            return null;
        }
        return new SimpleDateFormat(YYYY_MM_DD).format(data);
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDate) {
        return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date manipulaHoraMinuto(Date date, String horaBusca) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(horaBusca.substring(0,2)));
        calendar.set(Calendar.MINUTE, Integer.valueOf(horaBusca.substring(2,4)));
        calendar.set(Calendar.SECOND,0);

        return asDate(asLocalDateTime(calendar));

    }

    public static LocalDate asLocalDate(Date data) {
        return Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Calendar calendar){
        return Instant.ofEpochMilli(calendar.getTimeInMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDate asLocalDate(Calendar calendar) {
        return Instant.ofEpochMilli(calendar.getTimeInMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date retornaData(String s){
        try{
            Date parse = fmt.parse(s);
            return parse;
        }catch (ParseException e){
            return null;
        }
    }

    public static Date asData(String s){
        try{
            Date parse = fmt2.parse(s);
            return parse;
        }catch (ParseException e){
            return null;
        }
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static LocalDate copyData(LocalDate localDate) {
        return LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
    }
}