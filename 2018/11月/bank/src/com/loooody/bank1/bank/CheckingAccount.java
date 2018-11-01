package com.loooody.bank1.bank;

public class CheckingAccount extends Account {

    private SavingAccount protectedBy;

    public CheckingAccount(double init_balance) {
        super(init_balance);
    }

    public CheckingAccount(double init_balance, SavingAccount protectedBy) {
        super(init_balance);
        this.protectedBy = protectedBy;
    }

    public SavingAccount getProtectedBy() {
        return protectedBy;
    }

    public void setProtectedBy(SavingAccount protectedBy) {
        this.protectedBy = protectedBy;
    }

    @Override
    public boolean withdraw(double amt) {

        if (balance >= amt) {
            balance -= amt;
        }else{
            if (protectedBy != null &&
                    protectedBy.getBalance() >= (amt - balance)) {
                protectedBy.withdraw(amt - balance);
                balance = 0;
            }else{
                return false;
            }
        }

        return true;
    }
}
