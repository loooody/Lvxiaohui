package com.loooody.bank1.bank.test;


import com.loooody.bank1.bank.Bank;
import com.loooody.bank1.bank.CheckingAccount;
import com.loooody.bank1.bank.Customer;
import com.loooody.bank1.bank.SavingAccount;
import org.junit.Test;

public class testAccoutn {

    @Test
    public void test(){
        Bank bank = new Bank();
        bank.addCustomer("xiao", "dong");
        bank.addCustomer("xiao", "zhang");
        Customer customer = bank.getCustomer(0);

        SavingAccount saving = new SavingAccount(500, 0.05);
        customer.setSavingAccount(saving);
        customer.setCheckingAccount(new CheckingAccount(500,saving));
        System.out.println(customer.getBalance());
        customer.getCheckingAccount().withdraw(600);
        System.out.println(customer.getSavingAccount().getBalance());

    }
}
