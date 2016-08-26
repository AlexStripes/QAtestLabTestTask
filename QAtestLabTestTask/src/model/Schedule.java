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
public class Schedule {
    private WorkingDay days[] = new WorkingDay[7];


    
    public Schedule(){
        Random rand = new Random();
        for(int i = 0; i < 7; i++){
            int hoursCount=0;
            int isWorking=rand.nextInt(2);
            if(isWorking==1){
                int start=rand.nextInt(13)+8;
                int finish=rand.nextInt(9)+start;
                if(finish>20){finish=20;}
                if(hoursCount+(finish-start)>40){finish=finish-(hoursCount+(finish-start)-40);}
                days[i]=new WorkingDay(Boolean.TRUE,start,finish);
                hoursCount=hoursCount+(finish-start);
            }
            if(hoursCount>=40){break;}
        }
    }

    /**
     * @return the days
     */
    public WorkingDay[] getDays() {
        return days;
    }
}
