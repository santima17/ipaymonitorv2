package com.iwtg.ipaymonitor.datalayer.model;
// Generated 11/04/2018 12:27:58 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Transaction generated by hbm2java
 */
public class Transaction  implements java.io.Serializable {


     private String reservationNumber;
     private String channel;
     private String country;
     private String creditCardBrand;
     private String currency;
     private String transactionStatusCode;
     private Date date;
     private String name;
     private String lastName;
     private String email;
     private String customerId;
     private String amount;
     private String cardAccountHolderName;
     private boolean notify;
     private boolean notifyAirLineTechSupport;
     private String cardAuthCode;
     private String transactionStatusMsg;

    public Transaction() {
    }

	
    public Transaction(String reservationNumber, String channel, String country, String creditCardBrand, String currency, String transactionStatusCode, Date date, String name, String lastName, String email, String customerId, String amount, boolean notify, boolean notifyAirLineTechSupport) {
        this.reservationNumber = reservationNumber;
        this.channel = channel;
        this.country = country;
        this.creditCardBrand = creditCardBrand;
        this.currency = currency;
        this.transactionStatusCode = transactionStatusCode;
        this.date = date;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.customerId = customerId;
        this.amount = amount;
        this.notify = notify;
        this.notifyAirLineTechSupport = notifyAirLineTechSupport;
    }
    public Transaction(String reservationNumber, String channel, String country, String creditCardBrand, String currency, String transactionStatusCode, Date date, String name, String lastName, String email, String customerId, String amount, String cardAccountHolderName, boolean notify, boolean notifyAirLineTechSupport, String cardAuthCode, String transactionStatusMsg) {
       this.reservationNumber = reservationNumber;
       this.channel = channel;
       this.country = country;
       this.creditCardBrand = creditCardBrand;
       this.currency = currency;
       this.transactionStatusCode = transactionStatusCode;
       this.date = date;
       this.name = name;
       this.lastName = lastName;
       this.email = email;
       this.customerId = customerId;
       this.amount = amount;
       this.cardAccountHolderName = cardAccountHolderName;
       this.notify = notify;
       this.notifyAirLineTechSupport = notifyAirLineTechSupport;
       this.cardAuthCode = cardAuthCode;
       this.transactionStatusMsg = transactionStatusMsg;
    }
   
    public String getReservationNumber() {
        return this.reservationNumber;
    }
    
    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
    public String getChannel() {
        return this.channel;
    }
    
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCreditCardBrand() {
        return this.creditCardBrand;
    }
    
    public void setCreditCardBrand(String creditCardBrand) {
        this.creditCardBrand = creditCardBrand;
    }
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getTransactionStatusCode() {
        return this.transactionStatusCode;
    }
    
    public void setTransactionStatusCode(String transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getCardAccountHolderName() {
        return this.cardAccountHolderName;
    }
    
    public void setCardAccountHolderName(String cardAccountHolderName) {
        this.cardAccountHolderName = cardAccountHolderName;
    }
    public boolean isNotify() {
        return this.notify;
    }
    
    public void setNotify(boolean notify) {
        this.notify = notify;
    }
    public boolean isNotifyAirLineTechSupport() {
        return this.notifyAirLineTechSupport;
    }
    
    public void setNotifyAirLineTechSupport(boolean notifyAirLineTechSupport) {
        this.notifyAirLineTechSupport = notifyAirLineTechSupport;
    }
    public String getCardAuthCode() {
        return this.cardAuthCode;
    }
    
    public void setCardAuthCode(String cardAuthCode) {
        this.cardAuthCode = cardAuthCode;
    }
    public String getTransactionStatusMsg() {
        return this.transactionStatusMsg;
    }
    
    public void setTransactionStatusMsg(String transactionStatusMsg) {
        this.transactionStatusMsg = transactionStatusMsg;
    }




}


