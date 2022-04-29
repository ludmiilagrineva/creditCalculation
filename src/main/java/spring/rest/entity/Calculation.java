package spring.rest.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Entity
@Table(name= "calculations")
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="amount_of_credit")
    @Min(value = 50000, message = "введите значение больше 50000")
    @Max(value = 2000000000, message = "не должно превышать 2000000000")
    private int amountOfCredit;
    @Column(name="deposit")
    @Min(value = 10000, message = "введите значение больше 10000")
    @Max(value = 2000000, message = "не должно превышать 2000000")
    private int deposit;
    @Column(name="years")
    @Min(value = 5, message = "введите значение больше 5")
    @Max(value = 40, message = "не должно превышать 40")
    private int years;
    @Column(name="percent")
    @Min(value = 1, message = "введите значение больше 1")
    @Max(value = 100, message = "не должно превышать 100")
    private double percent;
    @Column(name="current_datee")
    private Date date;




    public Calculation() {
    }

    public Calculation(int amountOfCredit, int deposit, int years, double percent, Date date) {
        this.amountOfCredit = amountOfCredit;
        this.deposit = deposit;
        this.years = years;
        this.percent = percent;
        this.date = date;
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountOfCredit() {
        return amountOfCredit;
    }

    public void setAmountOfCredit(int amountOfCredit) {
        this.amountOfCredit = amountOfCredit;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "id=" + id +
                ", amountOfCredit=" + amountOfCredit +
                ", deposit=" + deposit +
                ", years=" + years +
                ", percent=" + percent +
                ", date=" + date +
                '}';
    }
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
    public double total(int amountOfCredit, int deposit, int years, double percent){
        double totalPay = overpayment(amountOfCredit, deposit, years, percent) + amountOfCredit;
        totalPay=round(totalPay, 2);
        return totalPay;
    }
    public static double percentPiece(int amountOfCredit, int deposit, double percent){
        double percentPiec=(amountOfCredit-deposit)*percent/12/100;
        percentPiec=round(percentPiec,2);
        return percentPiec;
    }
    public double dolgPiece(int amountOfCredit, int deposit, double percent){
        double dolg=(amountOfCredit-deposit)-(amountOfCredit-deposit)*percent/12/100;
        dolg=round(dolg,2);
        return dolg;
    }

}
