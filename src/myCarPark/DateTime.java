/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myCarPark;

/**
 *
 * @author Thilina
 */
public class DateTime {
    private int day;
    private int month;
    private int year;
    private int hours;
    private int minutes;
    
    public DateTime(int day, int month, int year,int hours, int minutes){
        this.day=day;
        this.month=month;
        this.year=year;
        this.hours=hours;
        this.minutes=minutes;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }
    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    public String getDate(){
        String date;
        if (getDay()<10){
            date =  "0"+getDay()+"/";
        }else{
            date = getDay()+"/";
        }
        if (getMonth()<10){
            date +=  "0"+getMonth()+"/";
        }else{
            date +=  getMonth()+"/";
        }
         date += getYear();
        return date;
    }
    public String viewTime(){
        String time;
        if (getHours()<10){
        	time =  "0"+getHours()+" : ";
        }else{
        	time = getHours()+" : ";
        }
        if (getMinutes()<10){
        	time +=  "0"+getMinutes();
        }else{
        	time +=  getMinutes();
        }
        return time;
    }
    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }
    /**
     * @param the hours to set
     */
    public void setHours(int hours) {
        this.hours = hours;
    }
    /**
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }
    /**
     * @param the minutes to set
     */
    public void setSeconds(int minutes) {
        this.minutes = minutes;
    }
    public void setDateTime(int day, int month, int year,int hours, int minutes) {
        setDay(day);
        setMonth(month);
        setYear(year);
        setHours(hours);
        setSeconds(minutes);
    }
    @Override
        public String toString(){
        return getDate()+" "+viewTime();
    }
}
