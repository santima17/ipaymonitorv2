package com.iwtg.ipaymonitor.generic.datatypes;

import java.util.Date;

public class DataSearchTransactionParameter {
	
	private String transactionID;
	private String document;
    private String channel;
    private String country;
    private String cardBrand;
    private String bank;
    private String currency;
    private String status;
    private Date dateFrom;
    private Date dateTo;
    private String creditCardNumber;
    private String acquirerID;
    
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCardBrand() {
		return cardBrand;
	}
	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getAcquirerID() {
		return acquirerID;
	}
	public void setAcquirerID(String acquirerID) {
		this.acquirerID = acquirerID;
	}

    
    

}
