package com.loooody.bank;

import com.loooody.bank.Account;

public class CheckingAccount extends Account {

    protected double orverdraftProtection;

    public CheckingAccount(double init_balance, SavingAccount savingAccount) {
        super(init_balance);
    }

    public CheckingAccount(double init_balance, double orverdraftProtection) {
        super(init_balance);
        this.orverdraftProtection = orverdraftProtection;
    }

    public double getOrverdraftProtection() {
        return orverdraftProtection;
    }

    public void setOrverdraftProtection(double orverdraftProtection) {
        this.orverdraftProtection = orverdraftProtection;
    }

    @Override
    public boolean withdraw(double amt) {

        if (balance >= amt) {
            balance -= amt;
        }else{
            if (orverdraftProtection >= (amt - balance)) {
                orverdraftProtection -= (amt - balance);
                balance = 0;
            }else{
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "orverdraftProtection=" + orverdraftProtection +
                ", balance=" + balance +
                '}';
    }
}
