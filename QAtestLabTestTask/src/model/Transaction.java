/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Stripes
 */
public class Transaction {
    private double summ;
    private int date;
    private Employee recipient;

    /**
     * @return the summ
     */
    public double getSumm() {
        return summ;
    }

    /**
     * @return the date
     */
    public int getDate() {
        return date;
    }

    /**
     * @return the recipient
     */
    public Employee getRecipient() {
        return recipient;
    }
    
    public Transaction(Date date, Employee reci){
        this.date=date.getDay();
        this.recipient=reci;
        if(reci.isSecondaryflag()==Boolean.TRUE){
        this.summ=(reci.getPosition().getWage()*reci.getHoursToPayPrimary())+(reci.getSecondaryPosition().getWage()*reci.getHoursToPaySecondary());
        }else{
            this.summ=(reci.getPosition().getWage()*reci.getHoursToPayPrimary());
        }
    }
}
