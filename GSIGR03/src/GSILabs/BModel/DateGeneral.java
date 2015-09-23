/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.sql.Time;
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
    Time time;
    
    DateGeneral (Date day, Time time){
        this.day = day;
        this.time = time;
    }
    
    /** 
     * 
     * @param string string to convert to Date
     */
    public DateGeneral (String string)
    {
        try
        {
            DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            this.day = format.parse(string);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(DateGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String toString(){
        DateFormat dateFormat =  DateFormat.getDateInstance();
        return dateFormat.format(day);
        
    }
}