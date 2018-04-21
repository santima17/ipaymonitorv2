package com.iwtg.ipaymonitor.facades.datatypes.search;

import java.util.Date;

public class DataTransactionLog {
	
    private Integer id;
    private String reservationNumber;
    private String processStepCode;
    private Date date;
    private String transactionStatusCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReservationNumber() {
		return reservationNumber;
	}
	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	public String getProcessStepCode() {
		return processStepCode;
	}
	public void setProcessStepCode(String processStepCode) {
		this.processStepCode = processStepCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTransactionStatusCode() {
		return transactionStatusCode;
	}
	public void setTransactionStatusCode(String transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}
    
    

}
