package spring.rest.mehhods;

public class Methods {
    public double inMouns(int amountOfCredit, int deposit, int years, double percent){
        double result=(amountOfCredit+amountOfCredit*percent*0.01)/years*12;
        return result;
    }
}
