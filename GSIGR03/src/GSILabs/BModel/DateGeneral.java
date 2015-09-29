/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class managed the date in general style
 * @author GR03
 */
public class DateGeneral {
    
    private final Date day;
    private final Date time;    
    
    /** 
     * Create a date general with day and time
     * @param dayString string day style "dd/mm/yyyy"
     * @param timeString string time style "H:mm"
     */
    public DateGeneral (String dayString, String timeString){
        this.day = this.dayFormat(dayString);
        this.time = this.timeFormat(timeString);
    }
    
    /**
     * Returns the day of the date
     * @return the day of the date 
     */
    public Date getDay() {
        return day;
    }

    /**
     * Returns the time of the date
     * @return the time of the date 
     */
    public Date getTime() {
        return time;
    }
    
    /**
     * Convert string (dd/mm/yyyy) to date format
     * @param string day style "dd/mm/yyyy"
     * @return return the date object
     */
    Date dayFormat(String string){
        try{
            DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            return format.parse(string);
        }catch (ParseException ex){
            Logger.getLogger(DateGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Convert string (H:mm) to date format
     * @param string day style "H:mm"
     * @return return the date object
     */
    Date timeFormat(String string){
        try{
            DateFormat format = new SimpleDateFormat("H:mm");
            return format.parse(string);
        }catch (ParseException ex){
            Logger.getLogger(DateGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Rewriting the toString() method
     * @return other style to show the information
     */
    @Override
    public String toString(){
        DateFormat dayFormat = new SimpleDateFormat("dd/mm/yyyy");
        DateFormat timeFormat = new SimpleDateFormat("H:mm");
        return "Day: " + dayFormat.format(day) + " - " + timeFormat.format(time);
    }
    
    /**
     * Checks if the client is adult (+18)
     * @return tru if and only if the birthday is more than 18 years
     */
    public boolean checkBirthday(){
       return (((new Date()).getYear() + 1900) - (day.getYear() + 1900) >= 18 );              
    }
}