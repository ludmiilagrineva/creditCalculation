package spring.entity;

import spring.mehhods.Methods;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "calculations")
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "amount_of_credit")
    @Min(value = 50000, message = "min значение 50000")
    @Max(value = 2000000000, message = "не должно превышать 2000000000")
    private int amountOfCredit;
    @Column(name = "deposit")
    @Min(value = 10000, message = "min значение 10000")
    @Max(value = 2000000, message = "не должно превышать 2000000")
    private int deposit;
    @Column(name = "years")
    @Min(value = 5, message = "min значение 5")
    @Max(value = 40, message = "не должно превышать 40")
    private int years;
    @Column(name = "percent")
    @Min(value = 1, message = "min значение 1")
    @Max(value = 100, message = "не должно превышать 100")
    private double percent;


    public Calculation() {
    }


    public Calculation(int amountOfCredit, int deposit, int years, double percent) {
        this.amountOfCredit = amountOfCredit;
        this.deposit = deposit;
        this.years = years;
        this.percent = percent;

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


    @Override
    public String toString() {
        return "Calculation{" +
                "id=" + id +
                ", amountOfCredit=" + amountOfCredit +
                ", deposit=" + deposit +
                ", years=" + years +
                ", percent=" + percent +
                '}';
    }

    public static double monthlyPayment(int amountOfCredit, int deposit, int years, double percent) {
        return Methods.monthlyPayment(amountOfCredit, deposit, years, percent);
    }

    public static double overpayment(int amountOfCredit, int deposit, int years, double percent) {

        return Methods.overpayment(amountOfCredit, deposit, years, percent);

    }

    public double total(int amountOfCredit, int deposit, int years, double percent) {

        return Methods.total(amountOfCredit, deposit, years, percent);
    }

    public static double percentPiece(double percent) {

        return Methods.percentPiece(percent);
    }

    public double creditPiece(int amountOfCredit, int deposit, int years, double percent) {

        return Methods.creditPiece(amountOfCredit, deposit, years, percent);
    }

    public String schedulePayment(int years) {

        return Methods.schedulePayment(years);

    }

}
