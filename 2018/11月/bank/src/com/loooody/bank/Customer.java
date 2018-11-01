package com.loooody.bank;

public class Customer {

    private String firstName;
    private String lastName;

    private Account[] accounts;
    private int numberOfAcccounts;


    public Customer(){

    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        accounts = new Account[2];
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Account getAccount(int index) {
        return accounts[index];
    }

    public void setAccount(Account account) {
        accounts[numberOfAcccounts++] = account;
    }

    public int getNumberOfAcccounts() {
        return numberOfAcccounts;
    }


}
