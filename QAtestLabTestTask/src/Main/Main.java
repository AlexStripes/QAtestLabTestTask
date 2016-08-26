/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import model.Date;
import model.Employee;
import model.Position;
import model.Task;
import model.Transaction;

/**
 *
 * @author Stripes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position("Director", 1, "Director"));             //создаем нужные должности
        positions.add(new Position("Manager", 2, "Service selling"));
        positions.add(new Position("Accountant", 1, "Make a report"));
        positions.add(new Position("Programmer", 2, "Write code"));
        positions.add(new Position("Designer", 2, "Draw a model"));
        positions.add(new Position("Tester", 2, "Test a program"));
        positions.add(new Position("Janitor", 0, "Clean the office"));
        Random rand = new Random();
        int totalEmloyeeCount=0;
        List<Employee> directors = new ArrayList<>();        //создаем список сотрудников каждой должности
        List<Employee> managers = new ArrayList<>();
        List<Employee> accountants = new ArrayList<>();
        List<Employee> programmers = new ArrayList<>();
        List<Employee> designers = new ArrayList<>();
        List<Employee> testers = new ArrayList<>();
        List<Employee> janitors = new ArrayList<>();
        List<Employee> freelancers = new ArrayList<>();
        directors.add(new Employee(positions.get(0)));      //создаем минимальный набор из 1 директора, 1 менеджера и 1 бухгалтера
        managers.add(new Employee(positions.get(1)));
        accountants.add(new Employee(positions.get(2)));
        totalEmloyeeCount=3;
        int totalTasksComplete = 0;
        int totalHoursPaid = 0;
        double totalMoneyPaid = 0;
        int toAdd=rand.nextInt(91)+7;                //случайный выбор числа сотрудников от 10 до 100 с учетом 3 уже добавленных
        for(int i=0;i<toAdd;i++){                  //цикл для создания сотрудников 
            Employee emp = new Employee(positions);
            switch(emp.getPosition().getName()){
                case "Director":
                    directors.add(emp);
                    break;
                case "Manager":
                    managers.add(emp);
                    break;
                case "Accountant":
                    accountants.add(emp);
                    break;
                case "Programmer":
                    programmers.add(emp);
                    break;
                case "Designer":
                    designers.add(emp);
                    break;
                case "Tester":
                    testers.add(emp);
                    break;
                case "Janitor":
                    janitors.add(emp);
                    break;
            }
            if(emp.isSecondaryflag()==Boolean.TRUE){
                switch(emp.getSecondaryPosition().getName()){
                case "Director":
                    directors.add(emp);
                    break;
                case "Manager":
                    managers.add(emp);
                    break;
                case "Accountant":
                    accountants.add(emp);
                    break;
                case "Programmer":
                    programmers.add(emp);
                    break;
                case "Designer":
                    designers.add(emp);
                    break;
                case "Tester":
                    testers.add(emp);
                    break;
                case "Janitor":
                    janitors.add(emp);
                    break;
            }
            }
            
            totalEmloyeeCount++;
        }
        Date date = new Date();
        for(int day = 0; day <30; day++){
            do{
                //Если уже прошел хотя бы час рабочего дня-проходим по списку работников, и отмечаем отработанный час у работающих
                //При добавлении часов к значению отработанных пересылается дата, если день-выходной, то начисляется в 2 раза больше часов.
                if(date.getHour()!=8){
                for(int dir = 0; dir < directors.size(); dir++){
                    if(directors.get(dir).getPosition().getName().equals("Director")){
                    if(directors.get(dir).getCurrentTaskHours()>0){
                        if(directors.get(dir).isCurrentSecondary()==Boolean.TRUE){
                         directors.get(dir).setHoursToPaySecondary(1, date);
                         directors.get(dir).setCurrentTaskHours(-1);
                        }
                         if(directors.get(dir).getCurrentTaskHours()==0){
                             Task tsk = directors.get(dir).getCurrentTask();
                             directors.get(dir).setCompleteTasks(tsk);
                             directors.get(dir).currentTaskComplete();
                             totalTasksComplete++;
                         }
                    }
                }
                }
                for(int mng = 0; mng < managers.size(); mng++){
                    if(managers.get(mng).getPosition().getName().equals("Manager")){
                    if(managers.get(mng).getCurrentTaskHours()>0){
                        if(managers.get(mng).isCurrentSecondary()==Boolean.FALSE){
                         managers.get(mng).setHoursToPayPrimary(1, date);
                         managers.get(mng).setCurrentTaskHours(-1);
                        }else{
                         managers.get(mng).setHoursToPaySecondary(1, date);
                         managers.get(mng).setCurrentTaskHours(-1);
                        }
                         if(managers.get(mng).getCurrentTaskHours()==0){
                             Task tsk = managers.get(mng).getCurrentTask();
                             managers.get(mng).setCompleteTasks(tsk);
                             managers.get(mng).currentTaskComplete();
                             totalTasksComplete++;
                         }
                    }
                }
                }
                for(int acc = 0; acc < accountants.size(); acc++){
                    if(accountants.get(acc).getPosition().getName().equals("Accountant")){
                    if(accountants.get(acc).getCurrentTaskHours()>0){
                        if(accountants.get(acc).isCurrentSecondary()==Boolean.FALSE){
                         accountants.get(acc).setHoursToPayPrimary(1, date);
                         accountants.get(acc).setCurrentTaskHours(-1);
                        }else{
                         accountants.get(acc).setHoursToPaySecondary(1, date);
                         accountants.get(acc).setCurrentTaskHours(-1);
                        }
                         if(accountants.get(acc).getCurrentTaskHours()==0){
                             Task tsk = accountants.get(acc).getCurrentTask();
                             accountants.get(acc).setCompleteTasks(tsk);
                             accountants.get(acc).currentTaskComplete();
                             totalTasksComplete++;
                         }
                    }
                }
                }
                for(int prg = 0; prg < programmers.size(); prg++){
                    if(programmers.get(prg).getPosition().getName().equals("Programmer")){
                    if(programmers.get(prg).getCurrentTaskHours()>0){
                        if(programmers.get(prg).isCurrentSecondary()==Boolean.FALSE){
                         programmers.get(prg).setHoursToPayPrimary(1, date);
                         programmers.get(prg).setCurrentTaskHours(-1);
                        }else{
                         programmers.get(prg).setHoursToPaySecondary(1, date);
                         programmers.get(prg).setCurrentTaskHours(-1);
                        }
                         if(programmers.get(prg).getCurrentTaskHours()==0){
                             Task tsk = programmers.get(prg).getCurrentTask();
                             programmers.get(prg).setCompleteTasks(tsk);
                             programmers.get(prg).currentTaskComplete();
                             totalTasksComplete++;
                         }
                    }
                }
                }
                for(int tes = 0; tes < testers.size(); tes++){
                    if(testers.get(tes).getPosition().getName().equals("Tester")){
                    if(testers.get(tes).getCurrentTaskHours()>0){
                        if(testers.get(tes).isCurrentSecondary()==Boolean.FALSE){
                         testers.get(tes).setHoursToPayPrimary(1, date);
                         testers.get(tes).setCurrentTaskHours(-1);
                        }else{
                         testers.get(tes).setHoursToPaySecondary(1, date);
                         testers.get(tes).setCurrentTaskHours(-1);
                        }
                         if(testers.get(tes).getCurrentTaskHours()==0){
                             Task tsk = testers.get(tes).getCurrentTask();
                             testers.get(tes).setCompleteTasks(tsk);
                             testers.get(tes).currentTaskComplete();
                             totalTasksComplete++;
                         }
                    }
                }
                }
                for(int des = 0; des < designers.size(); des++){
                    if(designers.get(des).getPosition().getName().equals("Designer")){
                    if(designers.get(des).getCurrentTaskHours()>0){
                        if(designers.get(des).isCurrentSecondary()==Boolean.FALSE){
                         designers.get(des).setHoursToPayPrimary(1, date);
                         designers.get(des).setCurrentTaskHours(-1);
                        }else{
                         designers.get(des).setHoursToPaySecondary(1, date);
                         designers.get(des).setCurrentTaskHours(-1);
                        }
                         if(designers.get(des).getCurrentTaskHours()==0){
                             Task tsk = designers.get(des).getCurrentTask();
                             designers.get(des).setCompleteTasks(tsk);
                             designers.get(des).currentTaskComplete();
                             totalTasksComplete++;
                         }
                    }
                }
                }
                for(int jan = 0; jan < janitors.size(); jan++){
                    if(janitors.get(jan).getPosition().getName().equals("Janitor")){
                    if(janitors.get(jan).getCurrentTaskHours()>0){
                        if(janitors.get(jan).isCurrentSecondary()==Boolean.FALSE){
                         janitors.get(jan).setHoursToPayPrimary(1, date);
                         janitors.get(jan).setCurrentTaskHours(-1);
                        }else{
                         janitors.get(jan).setHoursToPaySecondary(1, date);
                         janitors.get(jan).setCurrentTaskHours(-1);
                        }
                         if(janitors.get(jan).getCurrentTaskHours()==0){
                             Task tsk = janitors.get(jan).getCurrentTask();
                             janitors.get(jan).setCompleteTasks(tsk);
                             janitors.get(jan).currentTaskComplete();
                             totalTasksComplete++;
                         }
                    }
                }
                }
                if(freelancers.isEmpty()==Boolean.FALSE){
                    for(int frl = 0; frl < freelancers.size(); frl++){
                    if(freelancers.get(frl).getCurrentTaskHours()>0){
                         freelancers.get(frl).setHoursToPayPrimary(1, date);
                         freelancers.get(frl).setCurrentTaskHours(-1);
                         if(freelancers.get(frl).getCurrentTaskHours()==0){
                             Task tsk = freelancers.get(frl).getCurrentTask();
                             freelancers.get(frl).setCompleteTasks(tsk);
                             freelancers.get(frl).currentTaskComplete();
                             totalTasksComplete++;
                         }
                    }
                }
                }
                }
                //Начинаем новый час
                /*
                для начала для каждого из директоров проверяем, находится ли он на рабочем месте
                если да-он назначает набор задач от 1 до 3 шт.(в задании 1 или больше, ограничил тремя во славу здравого смысла)
                Если ни одного директора на месте нет-работа стоит
                */
                for(int i = 0; i<directors.size(); i++){
                    if(directors.get(i).isAtWork(date)==Boolean.TRUE){
                        directors.get(i).setHoursToPayPrimary(1, date);
                        int taskcount = rand.nextInt(4) + 1;
                        for(int j = 0; j < taskcount; j++){
                            Task tsk = new Task(date, positions);
                            //Созданная задача проверяется по типу и отправляется работникам соответствующего типа
                            switch(tsk.getType()){
                                //Задача для менеджера
                                case "Manager":
                                    for(int a = 0; a < managers.size(); a++){
                                        if(managers.get(a).isAtWork(date)==Boolean.TRUE && managers.get(a).getCurrentTaskHours()==0){
                                            managers.get(a).setCurrentTask(tsk);
                                            tsk=null;
                                            if(managers.get(a).getPosition().getName().equals("Manager")){
                                                managers.get(a).setCurrentSecondary(false);
                                            }else{
                                                managers.get(a).setCurrentSecondary(true);
                                            }
                                            break;
                                        }
                                    }
                                    if(tsk!=null){
                                        for(int a = 0; a < managers.size(); a++){
                                            if(managers.get(a).isAtWork(date)==Boolean.TRUE){
                                                if(managers.get(a).getCurrentTaskHours()==managers.get(a).getCurrentTask().getTimeReq()){
                                                    if(managers.get(a).getCurrentTask().getPriority()==tsk.getPriority()){
                                                        if(managers.get(a).getCurrentTask().getCost()<tsk.getCost()){
                                                            Task tsktmp=managers.get(a).getCurrentTask();
                                                            managers.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(managers.get(a).getPosition().getName().equals("Manager")){
                                                                managers.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                managers.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }else{
                                                        if(managers.get(a).getCurrentTask().getPriority()<tsk.getPriority()){
                                                            Task tsktmp=managers.get(a).getCurrentTask();
                                                            managers.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(managers.get(a).getPosition().getName().equals("Manager")){
                                                                managers.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                managers.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }
                                                }
                                        }
                                        }
                                        if(freelancers.isEmpty()==Boolean.FALSE){
                                            for(int b = 0; b < freelancers.size(); b++){
                                                if(freelancers.get(b).getPosition().getName().equals("Manager")&&
                                                        freelancers.get(b).isAtWork(date)==Boolean.TRUE &&
                                                        freelancers.get(b).getCurrentTaskHours()==0){
                                                    freelancers.get(b).setCurrentTask(tsk);
                                                    tsk=null;
                                                    break;
                                                }
                                            }
                                        }
                                        if(tsk!=null){
                                        Employee freelancer = new Employee(positions.get(1));
                                        freelancer.setCurrentTask(tsk);
                                        freelancers.add(freelancer);
                                        }
                                    }
                                    break;
                                    
                                //Задача для бухгалтера
                                case "Accountant":
                                    for(int a = 0; a < accountants.size(); a++){
                                        if(accountants.get(a).isAtWork(date)==Boolean.TRUE && accountants.get(a).getCurrentTaskHours()==0){
                                            accountants.get(a).setCurrentTask(tsk);
                                            tsk=null;
                                            if(accountants.get(a).getPosition().getName().equals("Accountant")){
                                                accountants.get(a).setCurrentSecondary(false);
                                            }else{
                                                accountants.get(a).setCurrentSecondary(true);
                                            }
                                            break;
                                        }
                                    }
                                    if(tsk!=null){
                                        for(int a = 0; a < accountants.size(); a++){
                                            if(accountants.get(a).isAtWork(date)==Boolean.TRUE){
                                                if(accountants.get(a).getCurrentTaskHours()==accountants.get(a).getCurrentTask().getTimeReq()){
                                                    if(accountants.get(a).getCurrentTask().getPriority()==tsk.getPriority()){
                                                        if(accountants.get(a).getCurrentTask().getCost()<tsk.getCost()){
                                                            Task tsktmp=accountants.get(a).getCurrentTask();
                                                            accountants.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(accountants.get(a).getPosition().getName().equals("Accountant")){
                                                                accountants.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                accountants.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }else{
                                                        if(accountants.get(a).getCurrentTask().getPriority()<tsk.getPriority()){
                                                            Task tsktmp=accountants.get(a).getCurrentTask();
                                                            accountants.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(accountants.get(a).getPosition().getName().equals("Accountant")){
                                                                accountants.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                accountants.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }
                                                }
                                        }
                                        }
                                        if(freelancers.isEmpty()==Boolean.FALSE){
                                            for(int b = 0; b < freelancers.size(); b++){
                                                if(freelancers.get(b).getPosition().getName().equals("Accountant")&&
                                                        freelancers.get(b).isAtWork(date)==Boolean.TRUE &&
                                                        freelancers.get(b).getCurrentTaskHours()==0){
                                                    freelancers.get(b).setCurrentTask(tsk);
                                                    tsk=null;
                                                    break;
                                                }
                                            }
                                        }
                                        if(tsk!=null){
                                        Employee freelancer = new Employee(positions.get(2));
                                        freelancer.setCurrentTask(tsk);
                                        freelancers.add(freelancer);
                                        }
                                    }
                                    break;
                                    
                                //Задача для программиста
                                case "Programmer":
                                    for(int a = 0; a < programmers.size(); a++){
                                        if(programmers.get(a).isAtWork(date)==Boolean.TRUE && programmers.get(a).getCurrentTaskHours()==0){
                                            programmers.get(a).setCurrentTask(tsk);
                                            tsk=null;
                                            if(programmers.get(a).getPosition().getName().equals("Programmer")){
                                                programmers.get(a).setCurrentSecondary(false);
                                            }else{
                                                programmers.get(a).setCurrentSecondary(true);
                                            }
                                            break;
                                        }
                                    }
                                    if(tsk!=null){
                                        for(int a = 0; a < programmers.size(); a++){
                                            if(programmers.get(a).isAtWork(date)==Boolean.TRUE){
                                                if(programmers.get(a).getCurrentTaskHours()==programmers.get(a).getCurrentTask().getTimeReq()){
                                                    if(programmers.get(a).getCurrentTask().getPriority()==tsk.getPriority()){
                                                        if(programmers.get(a).getCurrentTask().getCost()<tsk.getCost()){
                                                            Task tsktmp=programmers.get(a).getCurrentTask();
                                                            programmers.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(programmers.get(a).getPosition().getName().equals("Programmer")){
                                                                programmers.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                programmers.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }else{
                                                        if(programmers.get(a).getCurrentTask().getPriority()<tsk.getPriority()){
                                                            Task tsktmp=programmers.get(a).getCurrentTask();
                                                            programmers.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(programmers.get(a).getPosition().getName().equals("Programmer")){
                                                                programmers.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                programmers.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }
                                                }
                                        }
                                        }
                                        if(freelancers.isEmpty()==Boolean.FALSE){
                                            for(int b = 0; b < freelancers.size(); b++){
                                                if(freelancers.get(b).getPosition().getName().equals("Programmer")&&
                                                        freelancers.get(b).isAtWork(date)==Boolean.TRUE &&
                                                        freelancers.get(b).getCurrentTaskHours()==0){
                                                    freelancers.get(b).setCurrentTask(tsk);
                                                    tsk=null;
                                                    break;
                                                }
                                            }
                                        }
                                        if(tsk!=null){
                                        Employee freelancer = new Employee(positions.get(3));
                                        freelancer.setCurrentTask(tsk);
                                        freelancers.add(freelancer);
                                        }
                                    }
                                    break;
                                    
                                //Задача для тестировщика
                                case "Tester":
                                    for(int a = 0; a < testers.size(); a++){
                                        if(testers.get(a).isAtWork(date)==Boolean.TRUE && testers.get(a).getCurrentTaskHours()==0){
                                            testers.get(a).setCurrentTask(tsk);
                                            tsk=null;
                                            if(testers.get(a).getPosition().getName().equals("Tester")){
                                                testers.get(a).setCurrentSecondary(false);
                                            }else{
                                                testers.get(a).setCurrentSecondary(true);
                                            }
                                            break;
                                        }
                                    }
                                    if(tsk!=null){
                                        for(int a = 0; a < testers.size(); a++){
                                            if(testers.get(a).isAtWork(date)==Boolean.TRUE){
                                                if(testers.get(a).getCurrentTaskHours()==testers.get(a).getCurrentTask().getTimeReq()){
                                                    if(testers.get(a).getCurrentTask().getPriority()==tsk.getPriority()){
                                                        if(testers.get(a).getCurrentTask().getCost()<tsk.getCost()){
                                                            Task tsktmp=testers.get(a).getCurrentTask();
                                                            testers.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(testers.get(a).getPosition().getName().equals("Tester")){
                                                                testers.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                testers.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }else{
                                                        if(testers.get(a).getCurrentTask().getPriority()<tsk.getPriority()){
                                                            Task tsktmp=testers.get(a).getCurrentTask();
                                                            testers.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(testers.get(a).getPosition().getName().equals("Tester")){
                                                                testers.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                testers.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }
                                                }
                                        }
                                        }
                                        if(freelancers.isEmpty()==Boolean.FALSE){
                                            for(int b = 0; b < freelancers.size(); b++){
                                                if(freelancers.get(b).getPosition().getName().equals("Tester")&&
                                                        freelancers.get(b).isAtWork(date)==Boolean.TRUE &&
                                                        freelancers.get(b).getCurrentTaskHours()==0){
                                                    freelancers.get(b).setCurrentTask(tsk);
                                                    tsk=null;
                                                    break;
                                                }
                                            }
                                        }
                                        if(tsk!=null){
                                        Employee freelancer = new Employee(positions.get(4));
                                        freelancer.setCurrentTask(tsk);
                                        freelancers.add(freelancer);
                                        }
                                    }
                                    break;
                                    
                                //Задача для дизайнера
                                case "Designer":
                                    for(int a = 0; a < designers.size(); a++){
                                        if(designers.get(a).isAtWork(date)==Boolean.TRUE && designers.get(a).getCurrentTaskHours()==0){
                                            designers.get(a).setCurrentTask(tsk);
                                            tsk=null;
                                            if(designers.get(a).getPosition().getName().equals("Designer")){
                                                designers.get(a).setCurrentSecondary(false);
                                            }else{
                                                designers.get(a).setCurrentSecondary(true);
                                            }
                                            break;
                                        }
                                    }
                                    if(tsk!=null){
                                        for(int a = 0; a < designers.size(); a++){
                                            if(designers.get(a).isAtWork(date)==Boolean.TRUE){
                                                if(designers.get(a).getCurrentTaskHours()==designers.get(a).getCurrentTask().getTimeReq()){
                                                    if(designers.get(a).getCurrentTask().getPriority()==tsk.getPriority()){
                                                        if(designers.get(a).getCurrentTask().getCost()<tsk.getCost()){
                                                            Task tsktmp=designers.get(a).getCurrentTask();
                                                            designers.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(designers.get(a).getPosition().getName().equals("Designer")){
                                                                designers.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                designers.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }else{
                                                        if(designers.get(a).getCurrentTask().getPriority()<tsk.getPriority()){
                                                            Task tsktmp=designers.get(a).getCurrentTask();
                                                            designers.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(designers.get(a).getPosition().getName().equals("Designer")){
                                                                designers.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                designers.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }
                                                }
                                        }
                                        }
                                        if(freelancers.isEmpty()==Boolean.FALSE){
                                            for(int b = 0; b < freelancers.size(); b++){
                                                if(freelancers.get(b).getPosition().getName().equals("Designer")&&
                                                        freelancers.get(b).isAtWork(date)==Boolean.TRUE &&
                                                        freelancers.get(b).getCurrentTaskHours()==0){
                                                    freelancers.get(b).setCurrentTask(tsk);
                                                    tsk=null;
                                                    break;
                                                }
                                            }
                                        }
                                        if(tsk!=null){
                                        Employee freelancer = new Employee(positions.get(5));
                                        freelancer.setCurrentTask(tsk);
                                        freelancers.add(freelancer);
                                        }
                                    }
                                    break;
                                    
                                //Задачи для уборщика
                                case "Janitor":
                                    for(int a = 0; a < janitors.size(); a++){
                                        if(janitors.get(a).isAtWork(date)==Boolean.TRUE && janitors.get(a).getCurrentTaskHours()==0){
                                            janitors.get(a).setCurrentTask(tsk);
                                            tsk=null;
                                            if(janitors.get(a).getPosition().getName().equals("Janitor")){
                                                janitors.get(a).setCurrentSecondary(false);
                                            }else{
                                                janitors.get(a).setCurrentSecondary(true);
                                            }
                                            break;
                                        }
                                    }
                                    if(tsk!=null){
                                        for(int a = 0; a < janitors.size(); a++){
                                            if(janitors.get(a).isAtWork(date)==Boolean.TRUE){
                                                if(janitors.get(a).getCurrentTaskHours()==janitors.get(a).getCurrentTask().getTimeReq()){
                                                    if(janitors.get(a).getCurrentTask().getPriority()==tsk.getPriority()){
                                                        if(janitors.get(a).getCurrentTask().getCost()<tsk.getCost()){
                                                            Task tsktmp=janitors.get(a).getCurrentTask();
                                                            janitors.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(janitors.get(a).getPosition().getName().equals("Janitor")){
                                                                janitors.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                janitors.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }else{
                                                        if(janitors.get(a).getCurrentTask().getPriority()<tsk.getPriority()){
                                                            Task tsktmp=janitors.get(a).getCurrentTask();
                                                            janitors.get(a).setCurrentTask(tsk);
                                                            tsk=tsktmp;
                                                            if(janitors.get(a).getPosition().getName().equals("Janitor")){
                                                                janitors.get(a).setCurrentSecondary(false);
                                                            }else{
                                                                janitors.get(a).setCurrentSecondary(true);
                                                            }
                                                        }
                                                    }
                                                }
                                        }
                                        }
                                    }
                                    break;
                                }
                        }
                    }
                }
            //В конце каждого дня оплачивается работа фрилансеров
            if(date.getHour()==19){
                for(int i = 0; i<freelancers.size(); i++){
                    totalHoursPaid+=freelancers.get(i).getHoursToPayPrimary();
                    Transaction tran = new Transaction(date, freelancers.get(i));
                    freelancers.get(i).payOff(tran);
                    totalMoneyPaid+=tran.getSumm();
                }
            }
            //В конце последнего дня недели оплачивается работа всех работников
            if(date.getDay()%7==0 && date.getHour()==19){
                for(int i = 0; i<directors.size(); i++){
                    if(directors.get(i).getPosition().getName().equals("Director")){
                    totalHoursPaid+=directors.get(i).getHoursToPayPrimary();
                    if(directors.get(i).isSecondaryflag()==Boolean.TRUE){
                        totalHoursPaid+=directors.get(i).getHoursToPaySecondary();
                    }
                    Transaction tran = new Transaction(date, directors.get(i));
                    directors.get(i).payOff(tran);
                    totalMoneyPaid+=tran.getSumm();
                    }
                }
                for(int i = 0; i<managers.size(); i++){
                    if(managers.get(i).getPosition().getName().equals("Manager")){
                    totalHoursPaid+=managers.get(i).getHoursToPayPrimary();
                    if(managers.get(i).isSecondaryflag()==Boolean.TRUE){
                        totalHoursPaid+=managers.get(i).getHoursToPaySecondary();
                    }
                    Transaction tran = new Transaction(date, managers.get(i));
                    managers.get(i).payOff(tran);
                    totalMoneyPaid+=tran.getSumm();
                    }
                }
                for(int i = 0; i<accountants.size(); i++){
                    if(accountants.get(i).getPosition().getName().equals("Accountant")){
                    totalHoursPaid+=accountants.get(i).getHoursToPayPrimary();
                    if(accountants.get(i).isSecondaryflag()==Boolean.TRUE){
                        totalHoursPaid+=accountants.get(i).getHoursToPaySecondary();
                    }
                    Transaction tran = new Transaction(date, accountants.get(i));
                    accountants.get(i).payOff(tran);
                    totalMoneyPaid+=tran.getSumm();
                    }
                }
                for(int i = 0; i<programmers.size(); i++){
                    if(programmers.get(i).getPosition().getName().equals("Programmer")){
                    totalHoursPaid+=programmers.get(i).getHoursToPayPrimary();
                    if(programmers.get(i).isSecondaryflag()==Boolean.TRUE){
                        totalHoursPaid+=programmers.get(i).getHoursToPaySecondary();
                    }
                    Transaction tran = new Transaction(date, programmers.get(i));
                    programmers.get(i).payOff(tran);
                    totalMoneyPaid+=tran.getSumm();
                    }
                }
                for(int i = 0; i<testers.size(); i++){
                    if(testers.get(i).getPosition().getName().equals("Tester")){
                    totalHoursPaid+=testers.get(i).getHoursToPayPrimary();
                    if(testers.get(i).isSecondaryflag()==Boolean.TRUE){
                        totalHoursPaid+=testers.get(i).getHoursToPaySecondary();
                    }
                    Transaction tran = new Transaction(date, testers.get(i));
                    testers.get(i).payOff(tran);
                    totalMoneyPaid+=tran.getSumm();
                    }
                }
                for(int i = 0; i<designers.size(); i++){
                    if(designers.get(i).getPosition().getName().equals("Designer")){
                    totalHoursPaid+=designers.get(i).getHoursToPayPrimary();
                    if(designers.get(i).isSecondaryflag()==Boolean.TRUE){
                        totalHoursPaid+=designers.get(i).getHoursToPaySecondary();
                    }
                    Transaction tran = new Transaction(date, designers.get(i));
                    designers.get(i).payOff(tran);
                    totalMoneyPaid+=tran.getSumm();
                    }
                }
                for(int i = 0; i<janitors.size(); i++){
                    if(janitors.get(i).getPosition().getName().equals("Janitor")){
                    totalHoursPaid+=janitors.get(i).getHoursToPayPrimary();
                    if(janitors.get(i).isSecondaryflag()==Boolean.TRUE){
                        totalHoursPaid+=janitors.get(i).getHoursToPaySecondary();
                    }
                    Transaction tran = new Transaction(date, janitors.get(i));
                    janitors.get(i).payOff(tran);
                    totalMoneyPaid+=tran.getSumm();
                    }
                }
            }
            date.setHour(date.getHour()+1);
            }while(date.getHour()<=20);
            date.NextDay();
            System.out.println("+day");
            
        }
        try{
            PrintWriter pw = new PrintWriter(new File("C:/report.txt"));
            pw.println("Общий отчет");
            pw.println("__________________");
            pw.println("Всего работников "+totalEmloyeeCount);
            pw.println("Отработано часов "+totalHoursPaid);
            pw.println("Выполнено задач "+totalTasksComplete);
            pw.println("Выплачено "+totalMoneyPaid);
            pw.println("");
            pw.println("Отчет по сотрудникам");
            pw.println("_____________________________");
            for(int i = 0; i<directors.size(); i++){
                   if(directors.get(i).getPosition().getName().equals("Director")){
                       pw.println("Директор №"+(i+1));
                       pw.println("Отработано часов по основной должности "+directors.get(i).getHoursPaidPrim());
                       if(directors.get(i).isSecondaryflag()==Boolean.TRUE){
                           pw.println("Дополнительная должность "+directors.get(i).getSecondaryPosition().getName());
                           pw.println("Отработано часов по дополнительной должности "+directors.get(i).getHoursPaidSeco());
                       }
                       pw.println("Выполнено задач "+directors.get(i).getCompleteTasks().size());
                       pw.println("Список транзакций:");
                       for(int a = 0; a < directors.get(i).getTransactions().size(); a++){
                           pw.println("   Транзакция"+(a+1)+":");
                           pw.println("      Дата "+directors.get(i).getTransactions().get(a).getDate());
                           pw.println("      Сумма "+directors.get(i).getTransactions().get(a).getSumm());
                       }
                   }
                   pw.println("");
                }
                for(int i = 0; i<managers.size(); i++){
                    if(managers.get(i).getPosition().getName().equals("Manager")){
                       pw.println("Менеджер №"+(i+1));
                       pw.println("Отработано часов по основной должности "+managers.get(i).getHoursPaidPrim());
                       if(managers.get(i).isSecondaryflag()==Boolean.TRUE){
                           pw.println("Дополнительная должность "+managers.get(i).getSecondaryPosition().getName());
                           pw.println("Отработано часов по дополнительной должности "+managers.get(i).getHoursPaidSeco());
                       }
                       pw.println("Выполнено задач "+managers.get(i).getCompleteTasks().size());
                       pw.println("Список транзакций:");
                       for(int a = 0; a < managers.get(i).getTransactions().size(); a++){
                           pw.println("   Транзакция"+(a+1)+":");
                           pw.println("      Дата "+managers.get(i).getTransactions().get(a).getDate());
                           pw.println("      Сумма "+managers.get(i).getTransactions().get(a).getSumm());
                       }
                   }
                }
                for(int i = 0; i<accountants.size(); i++){
                    if(accountants.get(i).getPosition().getName().equals("Accountant")){
                       pw.println("Бухгалтер №"+(i+1));
                       pw.println("Отработано часов по основной должности "+accountants.get(i).getHoursPaidPrim());
                       if(accountants.get(i).isSecondaryflag()==Boolean.TRUE){
                           pw.println("Дополнительная должность "+accountants.get(i).getSecondaryPosition().getName());
                           pw.println("Отработано часов по дополнительной должности "+accountants.get(i).getHoursPaidSeco());
                       }
                       pw.println("Выполнено задач "+accountants.get(i).getCompleteTasks().size());
                       pw.println("Список транзакций:");
                       for(int a = 0; a < accountants.get(i).getTransactions().size(); a++){
                           pw.println("   Транзакция"+(a+1)+":");
                           pw.println("      Дата "+accountants.get(i).getTransactions().get(a).getDate());
                           pw.println("      Сумма "+accountants.get(i).getTransactions().get(a).getSumm());
                       }
                   }
                }
                for(int i = 0; i<programmers.size(); i++){
                   if(programmers.get(i).getPosition().getName().equals("Programmer")){
                       pw.println("Программист №"+(i+1));
                       pw.println("Отработано часов по основной должности "+programmers.get(i).getHoursPaidPrim());
                       if(programmers.get(i).isSecondaryflag()==Boolean.TRUE){
                           pw.println("Дополнительная должность "+programmers.get(i).getSecondaryPosition().getName());
                           pw.println("Отработано часов по дополнительной должности "+programmers.get(i).getHoursPaidSeco());
                       }
                       pw.println("Выполнено задач "+programmers.get(i).getCompleteTasks().size());
                       pw.println("Список транзакций:");
                       for(int a = 0; a < programmers.get(i).getTransactions().size(); a++){
                           pw.println("   Транзакция"+(a+1)+":");
                           pw.println("      Дата "+programmers.get(i).getTransactions().get(a).getDate());
                           pw.println("      Сумма "+programmers.get(i).getTransactions().get(a).getSumm());
                       }
                   }
                }
                for(int i = 0; i<testers.size(); i++){
                    if(testers.get(i).getPosition().getName().equals("Tester")){
                       pw.println("Тестировщик №"+(i+1));
                       pw.println("Отработано часов по основной должности "+testers.get(i).getHoursPaidPrim());
                       if(testers.get(i).isSecondaryflag()==Boolean.TRUE){
                           pw.println("Дополнительная должность "+testers.get(i).getSecondaryPosition().getName());
                           pw.println("Отработано часов по дополнительной должности "+testers.get(i).getHoursPaidSeco());
                       }
                       pw.println("Выполнено задач "+testers.get(i).getCompleteTasks().size());
                       pw.println("Список транзакций:");
                       for(int a = 0; a < testers.get(i).getTransactions().size(); a++){
                           pw.println("   Транзакция"+(a+1)+":");
                           pw.println("      Дата "+testers.get(i).getTransactions().get(a).getDate());
                           pw.println("      Сумма "+testers.get(i).getTransactions().get(a).getSumm());
                       }
                   }
                }
                for(int i = 0; i<designers.size(); i++){
                    if(designers.get(i).getPosition().getName().equals("Designer")){
                       pw.println("Дизайнер №"+(i+1));
                       pw.println("Отработано часов по основной должности "+designers.get(i).getHoursPaidPrim());
                       if(designers.get(i).isSecondaryflag()==Boolean.TRUE){
                           pw.println("Дополнительная должность "+designers.get(i).getSecondaryPosition().getName());
                           pw.println("Отработано часов по дополнительной должности "+designers.get(i).getHoursPaidSeco());
                       }
                       pw.println("Выполнено задач "+designers.get(i).getCompleteTasks().size());
                       pw.println("Список транзакций:");
                       for(int a = 0; a < designers.get(i).getTransactions().size(); a++){
                           pw.println("   Транзакция"+(a+1)+":");
                           pw.println("      Дата "+designers.get(i).getTransactions().get(a).getDate());
                           pw.println("      Сумма "+designers.get(i).getTransactions().get(a).getSumm());
                       }
                   }
                }
                for(int i = 0; i<janitors.size(); i++){
                    if(janitors.get(i).getPosition().getName().equals("Janitor")){
                       pw.println("Уборщик №"+(i+1));
                       pw.println("Отработано часов по основной должности "+janitors.get(i).getHoursPaidPrim());
                       if(janitors.get(i).isSecondaryflag()==Boolean.TRUE){
                           pw.println("Дополнительная должность "+janitors.get(i).getSecondaryPosition().getName());
                           pw.println("Отработано часов по дополнительной должности "+janitors.get(i).getHoursPaidSeco());
                       }
                       pw.println("Выполнено задач "+janitors.get(i).getCompleteTasks().size());
                       pw.println("Список транзакций:");
                       for(int a = 0; a < janitors.get(i).getTransactions().size(); a++){
                           pw.println("   Транзакция"+(a+1)+":");
                           pw.println("      Дата "+janitors.get(i).getTransactions().get(a).getDate());
                           pw.println("      Сумма "+janitors.get(i).getTransactions().get(a).getSumm());
                       }
                   }
                }
            pw.close();
            }catch(FileNotFoundException e){e.printStackTrace();}  
    
    
    }
    
}
