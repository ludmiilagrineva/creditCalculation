package spring.rest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "calculations")
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="amount_of_credit")
    private int amountOfCredit;
    @Column(name="deposit")
    private int deposit;
    @Column(name="years")
    private int years;
    @Column(name="percent")
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
    public static double inMouns(int amountOfCredit, int deposit, int years, double percent){
        double mounthStavka=percent/12/100;
        double totalStavka=Math.pow((1+mounthStavka), years*12);
        double result=(amountOfCredit-deposit)*mounthStavka*totalStavka/(totalStavka-1);

        return result;
    }

    public static double overpayment(int amountOfCredit, int deposit, int years, double percent){
//        double mounthStavka=percent/12/100;
//        double totalStavka=Math.pow((1+mounthStavka), years*12);
//        double mounthPay=(amountOfCredit-deposit)*mounthStavka*totalStavka/(totalStavka-1);
//        double result=mounthPay*years*12-(amountOfCredit-deposit);
        double result=inMouns(amountOfCredit, deposit, years, percent)*years*12-(amountOfCredit-deposit);
        return result;

    }
    public double total(int amountOfCredit, int deposit, int years, double percent){
        double totalPay = overpayment(amountOfCredit, deposit, years, percent) + amountOfCredit;
        return totalPay;
    }

}
