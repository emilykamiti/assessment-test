package com.resale.app.model.entity;

public class Bid {
    private String userName;
    private String phone;
    private double bidAmount;

    public Bid(String userName, String phone, double bidAmount) {
        this.userName = userName;
        this.phone = phone;
        this.bidAmount = bidAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
