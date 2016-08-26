/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Stripes
 * 
 * This class is needed for schedule creation
 */
public class WorkingDay {
    private boolean working;
    private int startHour;
    private int finishHour;

    /**
     * @return the working
     */
    public boolean isWorking() {
        return working;
    }

    /**
     * @param working the working to set
     */
    public void setWorking(boolean working) {
        this.working = working;
    }

    /**
     * @return the startHour
     */
    public int getStartHour() {
        return startHour;
    }

    /**
     * @param startHour the startHour to set
     */
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    /**
     * @return the finishHour
     */
    public int getFinishHour() {
        return finishHour;
    }

    /**
     * @param finishHour the finishHour to set
     */
    public void setFinishHour(int finishHour) {
        this.finishHour = finishHour;
    }
    
    public WorkingDay(boolean working, int startHour, int finishHour){
        this.working = working;
        this.startHour = startHour;
        this.finishHour = finishHour;
    }
}
