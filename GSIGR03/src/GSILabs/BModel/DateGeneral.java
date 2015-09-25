/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
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
    
    public Date dayFormat(String string){
        try{
            DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            return format.parse(string);
        }catch (ParseException ex){
            Logger.getLogger(DateGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Date timeFormat(String string){
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
        DateFormat dayFormat = DateFormat.getDateInstance();
        DateFormat timeFormat = new SimpleDateFormat("H:mm");
        return "Day: " + dayFormat.format(day) + " - " + timeFormat.format(time);
    }
}