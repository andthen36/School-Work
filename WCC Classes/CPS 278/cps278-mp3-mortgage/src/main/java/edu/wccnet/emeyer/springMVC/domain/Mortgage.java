package edu.wccnet.emeyer.springMVC.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Mortgage {
	
	private double principle;
	
	private double downPayment;
	
	private double interest;
	
	private int loanTerm;
	
	private double monthlyPayment;
	
	private ArrayList<PaymentDetail> paymentList;

	public double getMonthlyPayment() {
		return Math.round(monthlyPayment*100.0)/100.0;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public ArrayList<PaymentDetail> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(ArrayList<PaymentDetail> paymentList) {
		this.paymentList = paymentList;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double principle) {
		this.principle = principle;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public void calMonthly() {
		monthlyPayment =  (principle - downPayment) * (interest/12 * Math.pow(1 + interest / 12, loanTerm *12)
				/ (Math.pow(1 + interest/12, loanTerm*12)-1));
		
		
	}
	public void populatePaymentList() {
		paymentList = new ArrayList<PaymentDetail>();
		double outstanding, pPaid;
		outstanding = principle - downPayment;
		int count = 0;
		PaymentDetail paymentDetail;
		while(outstanding > 0) {
			paymentDetail = new PaymentDetail();
			paymentDetail.setPaymentNumb(++count);
			if(outstanding < monthlyPayment) {
				paymentDetail.setPrincipalPaid(outstanding);
				paymentDetail.setOutstanding(0);
				paymentDetail.setInterestPaid(0);
				outstanding = 0;
			} else {
				pPaid = monthlyPayment - (outstanding * (interest/12));
				paymentDetail.setInterestPaid(outstanding * (interest/12));
				paymentDetail.setPrincipalPaid(pPaid);
				outstanding -= pPaid;
				paymentDetail.setOutstanding(outstanding);
			}
			paymentList.add(paymentDetail);
			
			
		}
	}
	public static void main(String[] args) {
		Mortgage m = new Mortgage();
		m.principle = 300_00;
		m.interest = 0.05;
		m.loanTerm = 30;
		m.calMonthly();
		System.out.println(m.monthlyPayment);
		m.populatePaymentList();
		for(PaymentDetail paymentDetail : m.paymentList) {
			System.out.println(paymentDetail);
		}
	}
	
	
}
