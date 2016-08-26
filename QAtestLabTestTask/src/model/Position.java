/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author Stripes
 */
public class Position {
    private String name; //Название должности
    private double wage; //Почасовая зарплата
    private int compatibility; /*тип совместимости(0-уборщик, не совместим с другими; 1-директор/бухгалтер,
                                совместимо с менеджером, 2-остальные, совместимы со всеми)*/
    private String workType;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the wage
     */
    public double getWage() {
        return wage;
    }

    /**
     * @param wage the wage to set
     */
    public void setWage(double wage) {
        this.wage = wage;
    }

    /**
     * @return the compatibility
     */
    public int getCompatibility() {
        return compatibility;
    }

    /**
     * @param compatibility the compatibility to set
     */
    public void setCompatibility(int compatibility) {
        this.compatibility = compatibility;
    }
    


    /**
     * @return the workType
     */
    public String getWorkType() {
        return workType;
    }

    /**
     * @param workType the workType to set
     */
    public void setWorkType(String workType) {
        this.workType = workType;
    }    
    
    public Position(String name, int compatibility, String workType){
        Random rand = new Random();
        this.name=name;
        this.wage=rand.nextDouble()*100.0+50.0;
        this.compatibility=compatibility;
        this.workType=workType;
    }
}
