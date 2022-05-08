package spring.rest.mehhods;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Methods {

    public static double ostatokTotal;
   public static Calendar calendar;


    //метод округления, place символов после точки
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public static double inMouns(int amountOfCredit, int deposit, int years, double percent){
        double mounthStavka=percent/12/100;
        double totalStavka=Math.pow((1+mounthStavka), years*12);
        double result=(amountOfCredit-deposit)*mounthStavka*totalStavka/(totalStavka-1);
        result=round(result, 2);

        return result;
    }

    public static double overpayment(int amountOfCredit, int deposit, int years, double percent){
        double result=inMouns(amountOfCredit, deposit, years, percent)*years*12-(amountOfCredit-deposit);
        result=round(result, 2);
        return result;

    }
    public static double total(int amountOfCredit, int deposit, int years, double percent){
        double totalPay = overpayment(amountOfCredit, deposit, years, percent) + amountOfCredit;
        totalPay=round(totalPay, 2);
        ostatokTotal=amountOfCredit-deposit;
                calendar=Calendar.getInstance();

        return totalPay;
    }
    public static double percentPiece(int amountOfCredit, int deposit, int years, double percent){
        double percentPiec=ostatokTotal*percent/12/100;
        percentPiec=round(percentPiec,2);
        return percentPiec;
    }
    public static double ostatok(int amountOfCredit, int deposit, int years, double percent){
        ostatokTotal-=dolgPiece(amountOfCredit, deposit, years, percent);
        return ostatokTotal;
    }

    public static double dolgPiece(int amountOfCredit, int deposit, int years, double percent){
        double dolg=inMouns(amountOfCredit, deposit, years, percent)-percentPiece(amountOfCredit, deposit, years, percent);
        dolg=round(dolg,2);
        ostatokTotal-=dolg;
        return dolg;
    }


    public static String grafikPayment(int years){
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
//        Date date=new Date();
//        Calendar calendar=Calendar.getInstance();
//        LocalDate localDate=LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
//        for(int i=0; i<years*12; i++) {
//            localDate.plusMonths(1);
//        }

            calendar.add(Calendar.MONTH, 1);

        Date date=calendar.getTime();
        return formater.format(date);

    }
}
