package edu.wccnet.emeyer.springMVC.domain;

public class PaymentDetail {
	private int paymentNumb;
	private double principalPaid;
	private double interestPaid;
	private double outstanding;
	
	public int getPaymentNumb() {
		return paymentNumb;
	}
	public void setPaymentNumb(int paymentNumb) {
		this.paymentNumb = paymentNumb;
	}
	public double getPrincipalPaid() {
		return Math.round(principalPaid * 100.0) / 100.0;
	}
	public void setPrincipalPaid(double principalPaid) {
		this.principalPaid = principalPaid;
	}
	public double getInterestPaid() {
		return Math.round(interestPaid * 100.0) / 100.0;
	}
	public void setInterestPaid(double interestPaid) {
		this.interestPaid = interestPaid;
	}
	public double getOutstanding() {
		return Math.round(outstanding * 100.0) / 100.0;
	}
	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}
	
	
	
}
