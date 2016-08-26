/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Random;


/**
 *
 * @author Stripes
 */
public class Task {
    private String name; //Название
    private String type;  //Необходимый тип работника
    private int priority;
    private double cost;
    private int timeReq;
    private Date startTime;
    private Date finishTime;
    private boolean freelancePossibility;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @return the timeReq
     */
    public int getTimeReq() {
        return timeReq;
    }

    /**
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @return the finishTime
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * @param finishTime the finishTime to set
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * @return the freelancePossibility
     */
    public boolean isFreelancePossibility() {
        return freelancePossibility;
    }
    
    public Task(Date start, List<Position> pos){
        Random rand = new Random();
        int position = rand.nextInt(pos.size()-1)+1;
        this.name = pos.get(position).getWorkType()+" "+start.getDay()+" "+start.getHour();
        this.type = pos.get(position).getName();
        this.timeReq = rand.nextInt(2)+1;
        this.priority = rand.nextInt(3);
        this.cost = rand.nextInt(1000)+500;
        this.startTime = start;
        if(pos.get(position).getName().equals("Janitor")){
            this.freelancePossibility=Boolean.FALSE;
        }else{
            this.freelancePossibility=Boolean.TRUE;
        }
        
    }
    
}
