package com.loooody.bank.test;

import com.loooody.bank.Customer;
import com.loooody.bank.Bank;
import com.loooody.bank.CheckingAccount;
import com.loooody.bank.SavingAccount;
import org.junit.Test;

public class testBanking {

    //@Test
    public void testBanking(){
        Bank bank = new Bank();

        bank.addCustomer("xiao", "ming");
        bank.addCustomer("xiao", "hong");
        bank.addCustomer("xiao", "dong");

        System.out.println(bank.toString());
    }

   // @Test
    public void testCheckingBank(){
        Bank bank = new Bank();
        bank.addCustomer("xiao", "ming");
        bank.getCustomer(0).setAccount(new CheckingAccount(500, 500));
        Customer customer = bank.getCustomer(0);
//        customer.getAccount().withdraw(300);
//        customer.getAccount().withdraw(500);
//        System.out.println(customer.getAccount().getBalance());
        System.out.println(bank.toString());
    }

    @Test
    public void test3(){
        Bank bank = new Bank();
        bank.addCustomer("xiao", "ming");
        bank.getCustomer(0).setAccount(new CheckingAccount(500, 500));
        bank.getCustomer(0).setAccount(new SavingAccount(200, 0.05));


        for (int i = 0; i < bank.getNumberOfCustomers(); i++) {
            System.out.println(bank.getCustomer(i).getFirstName() + " " + bank.getCustomer(i).getLastName());
            for (int j = 0; j < bank.getCustomer(i).getNumberOfAcccounts(); j++) {
                String type = "";
                if (bank.getCustomer(i).getAccount(j) instanceof SavingAccount) {
                    type = "SavingAccount";
                }else{
                    if(bank.getCustomer(i).getAccount(j) instanceof CheckingAccount){
                        type = "ChenkingAccount";
                    }
                }

                System.out.println(type + "balance is $" + bank.getCustomer(i).getAccount(j).getBalance());
            }
        }
    }
}
