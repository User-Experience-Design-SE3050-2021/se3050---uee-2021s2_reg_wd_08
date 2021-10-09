package com.example.cargillsshop;

public class m_CreditCard_Class {
    private String user;
    private Float total;
    private String cardNumber;
    private String cardHolder;
    private String month;
    private String year;
    private String cvc;
    private String date;

    public m_CreditCard_Class(){}

    public m_CreditCard_Class(String user, Float total, String cardNumber, String cardHolder, String month, String year, String cvc, String date) {
        this.user = user;
        this.total = total;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.month = month;
        this.year = year;
        this.cvc = cvc;
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
