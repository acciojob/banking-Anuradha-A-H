package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;





    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;

    }
    public double getRate() {
        return rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        if(amount>maxWithdrawalLimit)
        {
            throw new InsufficientBalance("Maximum Withdraw Limit Exceed");
        }

        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>getBalance())
        {
            throw new InsufficientBalance("Insufficient Balance");
        }

        setBalance(getBalance()-amount);

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        double principle = getBalance();
        double totalpercentofInterest = years * rate;
        double totalamount = principle +((totalpercentofInterest * principle)/100);

        return totalamount ;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double principal = getBalance();
        double n = times; // Compounded 'times' times per year
        double r = rate/100;
        double A = principal * (Math.pow((1 + (r / n)), n * years));
        return A;
    }


    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

}
