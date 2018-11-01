package com.loooody.bank1.bank;

import java.util.Arrays;

public class Bank {

    private Customer[] customers;
    private int numberOfCustomers;

    public Bank(){
        customers = new Customer[10];
    }

    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
        customers[numberOfCustomers++] = customer;
    }

    public int getNumberOfCustomers(){
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }

    @Override
    public String toString() {
        return "Bank{" +
                "customers=" + Arrays.toString(customers) +
                '}';
    }
}
