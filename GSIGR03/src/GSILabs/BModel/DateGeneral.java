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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class managed the date in general style
 * @author GR03
 */
public class DateGeneral {
    private final Date day;
    
    /** 
     * Create a date general with day and time
     * @param dayString string day style "dd/mm/yyyy"
     */
    public DateGeneral (String dayString){
        this.day = this.dayFormat(dayString);
    }
    
    /**
     * Returns the day of the date
     * @return the day of the date 
     */
    public Date getDay() {
        return day;
    }
    
    /**
     * Convert string (dd/mm/yyyy HH:mm) to date format
     * @param string day style "dd/mm/yyyy HH:mm"
     * @return return the date object
     */
    Date dayFormat(String string){
        try{
            DateFormat format = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            return format.parse(string);
        }catch (ParseException ex){
            Logger.getLogger(DateGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    /**
     * Checks if the client is adult (+18)
     * @return tru if and only if the birthday is more than 18 years
     */
    public boolean checkBirthday(){
       return (((new Date()).getYear() + 1900) - (day.getYear() + 1900) >= 18 );              
    }
    
    @Override
    public String toString(){
        return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(day);
    }
    
    @Override
    public boolean equals(Object o) {       
        if(o instanceof DateGeneral) {
            DateGeneral date = (DateGeneral) o;
            //comprobar que no es after ni before
            return (!day.after(date.day) && !day.before(date.day));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.day);
        return hash;
    }
}