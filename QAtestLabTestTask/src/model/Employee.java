/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Stripes
 */
public class Employee {
    private Position position;
    private boolean secondaryflag;
    private Position secondaryPosition;
    private List<Task> completeTasks = new ArrayList<>();
    private int currentTaskHours;
    private Task currentTask;
    private boolean currentSecondary;
    private boolean atWork;
    private int hoursToPayPrimary;
    private int hoursToPaySecondary;
    private List<Transaction> transactions = new ArrayList<>();
    private Schedule schedule;
    private int totalTaskcount;
    private int hoursPaidPrim;
    private int hoursPaidSeco;

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return the secondaryPosition
     */
    public Position getSecondaryPosition() {
        return secondaryPosition;
    }

    /**
     * @return the completeTasks
     */
    public List<Task> getCompleteTasks() {
        return completeTasks;
    }

    /**
     * @return the currentTask
     */
    public Task getCurrentTask() {
        return currentTask;
    }

    /**
     * @param date
     * @return the atWork
     */
    public boolean isAtWork(Date date) {
        if(this.schedule.getDays()[date.getDay()%7]!=null && this.schedule.getDays()[date.getDay()%7].isWorking()==Boolean.TRUE){
            if(date.getHour()>=this.schedule.getDays()[(date.getDay()%7)].getStartHour()&&date.getHour()<this.schedule.getDays()[date.getDay()%7].getFinishHour()){
                this.atWork=Boolean.TRUE;
            }else{
                this.atWork=Boolean.FALSE;
            }
        }else{
            this.atWork=Boolean.FALSE;
        }
        return atWork;
    }

    /**
     * @return the hoursToPayPrimary
     */
    public int getHoursToPayPrimary() {
        return hoursToPayPrimary;
    }

    /**
     * @param hoursToPayPrimary the hoursToPayPrimary to set
     */
    public void setHoursToPayPrimary(int hoursToPayPrimary, Date date) {
        if(date.getDay()%7==6||date.getDay()%7==0){
            this.hoursToPayPrimary += (hoursToPayPrimary*2);
        }else{
            this.hoursToPayPrimary += hoursToPayPrimary;
        }
    }

    /**
     * @return the hoursToPaySecondary
     */
    public int getHoursToPaySecondary() {
        return hoursToPaySecondary;
    }

    /**
     * @param hoursToPaySecondary the hoursToPaySecondary to set
     */
    public void setHoursToPaySecondary(int hoursToPaySecondar, Date date) {
        if(date.getDay()%7==6||date.getDay()%7==0){
            this.hoursToPaySecondary += (hoursToPaySecondar*2);
        }else{
            this.hoursToPaySecondary += hoursToPaySecondar;
        }
    }

    /**
     * @return the schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }
    
    public Employee(List<Position> positions){
        Random rand= new Random();
        this.position=positions.get(rand.nextInt(7));
        int comp = this.position.getCompatibility();
        switch(comp){
            case 0:
                this.secondaryPosition=null;
                this.secondaryflag=Boolean.FALSE;
                break;
            case 1:
                Position sec=positions.get(rand.nextInt(7));
                if(sec.getName().equals("Manager")){
                    this.secondaryPosition = sec;
                    this.secondaryflag = Boolean.TRUE;
                    break;
                }else{
                    this.secondaryPosition=null;
                    this.secondaryflag=Boolean.FALSE;
                    break;
                }
            case 2:
                Position seco=positions.get(rand.nextInt(7));
                if(seco.getCompatibility()==2){
                    this.secondaryPosition = seco;
                    this.secondaryflag = Boolean.TRUE;
                    break;
                }else{
                    this.secondaryPosition=null;
                    this.secondaryflag=Boolean.FALSE;
                    break;
                } 
        }
        this.schedule = new Schedule();
        this.hoursToPayPrimary = 0;
        this.hoursToPaySecondary = 0;
    }
    public Employee(Position pos){
        this.position=pos;
        this.secondaryflag=Boolean.FALSE;
        this.secondaryPosition=null;
        this.schedule=new Schedule();
        this.hoursToPayPrimary = 0;
        this.hoursToPaySecondary = 0;
    }

    /**
     * @return the currentTaskHours
     */
    public int getCurrentTaskHours() {
        return currentTaskHours;
    }

    /**
     * @param currentTaskHours the currentTaskHours to set
     */
    public void setCurrentTaskHours(int currentTaskHours) {
        this.currentTaskHours += currentTaskHours;
    }

    /**
     * @param currentTask the currentTask to set
     */
    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
        this.currentTaskHours = currentTask.getTimeReq();
    }

    /**
     * @param transaction the transactions to set
     */
    public void setTransactions(Transaction transaction) {
        this.getTransactions().add(transaction);
    }

    /**
     * @param completeTask the completeTasks to set
     */
    public void setCompleteTasks(Task completeTask) {
        this.completeTasks.add(completeTask);
    }

    /**
     * @return the secondaryflag
     */
    public boolean isSecondaryflag() {
        return secondaryflag;
    }

    public void payOff(Transaction tran){
        this.getTransactions().add(tran);
        this.setHoursPaidPrim(this.hoursToPayPrimary);
        this.setHoursPaidSeco(this.hoursToPaySecondary);
        this.hoursToPayPrimary=0;
        this.hoursToPaySecondary=0;
    }
    
    public void currentTaskComplete(){
        this.currentTask = null;
        this.currentSecondary = Boolean.FALSE;
        this.totalTaskcount++;
    }

    /**
     * @return the currentSecondary
     */
    public boolean isCurrentSecondary() {
        return currentSecondary;
    }

    /**
     * @param currentSecondary the currentSecondary to set
     */
    public void setCurrentSecondary(boolean currentSecondary) {
        this.currentSecondary = currentSecondary;
    }

    /**
     * @return the hoursPaidPrim
     */
    public int getHoursPaidPrim() {
        return hoursPaidPrim;
    }

    /**
     * @return the hoursPaidSeco
     */
    public int getHoursPaidSeco() {
        return hoursPaidSeco;
    }

    /**
     * @return the transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param hoursPaidPrim the hoursPaidPrim to set
     */
    public void setHoursPaidPrim(int hoursPaidPrim) {
        this.hoursPaidPrim += hoursPaidPrim;
    }

    /**
     * @param hoursPaidSeco the hoursPaidSeco to set
     */
    public void setHoursPaidSeco(int hoursPaidSeco) {
        this.hoursPaidSeco += hoursPaidSeco;
    }
}
