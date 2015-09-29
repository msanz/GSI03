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
 * This class manager the day and time of the 
 * @author GR03
 */
public class DateGeneral {
    Date day;
    Date time;    
    
    /** 
     * Convert string day and time to Date and Time types
     * @param dayString string day style "dd/mm/yyyy"
     * @param timeString string time style "H:mm"
     */
    public DateGeneral (String dayString, String timeString){
        this.day = this.dayFormat(dayString);
        this.time = this.timeFormat(timeString);
    }
    
    Date dayFormat(String string){
        try{
            DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            return format.parse(string);
        }catch (ParseException ex){
            Logger.getLogger(DateGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    Date timeFormat(String string){
        try{
            DateFormat format = new SimpleDateFormat("H:mm");
            return format.parse(string);
        }catch (ParseException ex){
            Logger.getLogger(DateGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public String toString(){
        DateFormat dayFormat = new SimpleDateFormat("dd/mm/yyyy");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        return "Day: " + dayFormat.format(day) + " - " + timeFormat.format(time);
    }
    
    public boolean checkBirthday(){
       return (((new Date()).getYear() + 1900) - (day.getYear() + 1900) >= 18 );              
    }
}