package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Pamela on 2/13/16.
 */
public class DateUtil {
    public static int calculateAge(String born){
        int age = 0;
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = format.format(today);
        String[] dat1 = born.split("/");
        String[] dat2 = hoy.split("/");
        age = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
            age = age - 1;
        } else if (mes == 0) {
            int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
            if (dia > 0) {
                age = age - 1;
            }
        }
        return age;
    }

    public static int calcularEdad(String fecha ) {

//        Calendar fechaActual = Calendar.getInstance();
//
//        // Cálculo de las diferencias.
//        int anios = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
//        int meses = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
//        int dias = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
//
//        // Hay que comprobar si el día de su cumpleaños es posterior
//        // a la fecha actual, para restar 1 a la diferencia de años,
//        // pues aún no ha sido su cumpleaños.</code>
//
//        if(meses < 0 // Aún no es el mes de su cumpleaños
//                || (meses==0 && dias < 0)) { // o es el mes pero no ha llegado el día.
//
//            anios--;
//        }
//        return anios;


        String datetext = fecha;

        try {
            Calendar birth = new GregorianCalendar();
            Calendar today = new GregorianCalendar();
            int age=0;
            int factor=0;

            Date birthDate=new SimpleDateFormat("dd/MM/yyyy").parse(datetext);
            Date currentDate=new Date(); //current date
            birth.setTime(birthDate);
            today.setTime(currentDate);

            if (today.get(Calendar.MONTH) <=  birth.get(Calendar.MONTH)) {

                if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                    if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                        System.out.println("primero");
                        //factor = -1; //Aun no celebra su cumpleaÃ±os
                    }else{
                        factor = -1;
                        System.out.println("hacer algo?");
                    }


                } else {
                    System.out.println("segundo");
                    factor = -1; //Aun no celebra su cumpleaÃ±os
                }
            }
            age=(today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor;
            return age;
        } catch (ParseException e) {
            return -1;
        }

    }





    public static Date convertStringToDate(String dateString){
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {

            date = formatter.parse(dateString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
      return  date;
    }
}
