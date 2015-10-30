/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * This class managed the date in general style
 * @author GR03
 */
public class DateGeneral {
    private final Date day;
    private final SimpleDateFormat simpleDateFormat;
    
    /** 
     * Create a date general with day and time
     * @param dayString string day style "dd/mm/yyyy"
     */
    public DateGeneral (String dayString){
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
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
     * Convert string (dd/MM/yyyy hh:mm) to date format
     * @param string day style "dd/MM/yyyy HH:mm"
     * @return return the date object
     */
    Date dayFormat(String string){
        try{
            return simpleDateFormat.parse(string);
        }catch (ParseException ex){
            return null;
        }        
    }
   
    /**
     * Checks if the client is adult (+18)
     * @return true if and only if the birthday is more than 18 years
     */
    public boolean checkBirthday(){
       return (((new Date()).getYear() + 1900) - (day.getYear() + 1900) >= 18 );              
    }
    
    @Override
    public String toString(){
        return simpleDateFormat.format(day);
    }
    
    @Override
    public boolean equals(Object o) {       
        if(o instanceof DateGeneral) {
            DateGeneral date = (DateGeneral) o;
            //comprobar que no es after ni before
            return (!day.after(date.day) && !day.before(date.day));
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.day);
        return hash;
    }
}