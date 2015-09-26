/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author GR03
 */
public class DateEvent extends DateGeneral{
    Date dayStart;
    Date dayFinish;
    Date timeStart;
    Date timeFinish;
   
    public DateEvent(String dayString, String timeString) {
        super(dayString, timeString);
        this.dayStart = super.dayFormat(dayString);
        this.timeStart = super.timeFormat(timeString);
    }
       
    public void setDayStart(String string){
        this.dayStart = super.dayFormat(string);
    }
    
    public void setDayFinish(String string){
        this.dayFinish = super.dayFormat(string);
    }
    
    public void setTimeStart(String string){
        this.timeStart = super.timeFormat(string);
    }
    
    public void setTimeFinish(String string){
        this.timeFinish = super.timeFormat(string);
    }
}