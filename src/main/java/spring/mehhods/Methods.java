package spring.mehhods;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Methods {

    public static double balanceTotal;
    public static Calendar calendar;


    //метод округления, place символов после точки
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double monthlyPayment(int amountOfCredit, int deposit, int years, double percent) {
        double mounthRate = percent / 12 / 100;
        double totalRate = Math.pow((1 + mounthRate), years * 12);
        double result = (amountOfCredit - deposit) * mounthRate * totalRate / (totalRate - 1);
        result = round(result, 2);

        return result;
    }

    public static double overpayment(int amountOfCredit, int deposit, int years, double percent) {
        double result = monthlyPayment(amountOfCredit, deposit, years, percent) * years * 12 - (amountOfCredit - deposit);
        result = round(result, 2);
        return result;

    }

    public static double total(int amountOfCredit, int deposit, int years, double percent) {
        double totalPay = overpayment(amountOfCredit, deposit, years, percent) + amountOfCredit;
        totalPay = round(totalPay, 2);
        balanceTotal = amountOfCredit - deposit;
        calendar = Calendar.getInstance();

        return totalPay;
    }

    public static double percentPiece(double percent) {
        double percentPiec = balanceTotal * percent / 12 / 100;
        percentPiec = round(percentPiec, 2);
        return percentPiec;
    }

    public static double creditPiece(int amountOfCredit, int deposit, int years, double percent) {
        double credit = monthlyPayment(amountOfCredit, deposit, years, percent) - percentPiece(percent);
        credit = round(credit, 2);
        balanceTotal -= credit;
        return credit;
    }


    public static String schedulePayment(int years) {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        calendar.add(Calendar.MONTH, 1);
        Date date = calendar.getTime();
        return formater.format(date);

    }
}
