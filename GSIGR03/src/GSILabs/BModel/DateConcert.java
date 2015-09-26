/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.Date;

/**
 *
 * @author GR03
 */
public class DateConcert extends DateEvent {
    Date timeOpenDoors;  

    public DateConcert(String dayString, String timeString) {
        super(dayString, timeString);
        this.timeOpenDoors = super.timeFormat(timeString);   
    }
    
    public void setTimeOpenDoors(String string){
        this.timeOpenDoors = super.timeFormat(string);   
    }
    
    public boolean collisionDay(DateConcert dateConcert){
        if (!dateConcert.dayStart.before(super.dayStart)){
            if (!dateConcert.dayFinish.after(super.dayFinish)){
                return true;
            }
        }
        
        return false;
    }
}