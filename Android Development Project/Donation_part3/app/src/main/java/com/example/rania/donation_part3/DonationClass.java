package com.example.rania.donation_part3;

/**
 * Created by Rania on 11/23/2017.
 */

public class DonationClass {
    private String paymentMethod;
    private int amount;
    private int id;

    public DonationClass(String method,int amount){
        this.paymentMethod = method;
        this.amount = amount;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public DonationClass(){}

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public int getAmount() {
        return amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
