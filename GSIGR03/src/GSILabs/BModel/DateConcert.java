/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Date;

/**
 *
 * @author GR03
 */
public class DateConcert extends DateEvent {
    private Date timeOpenDoors;  

    public DateConcert(String dayString, String timeString) {
        super(dayString, timeString);
        this.timeOpenDoors = super.timeFormat(timeString);
        this.dayStart = this.dayFinish;
    }
    
    public void setTimeOpenDoors(String string){
        this.timeOpenDoors = super.timeFormat(string);   
    }
    
    public Date getTimeOpenDoors(){
        return timeOpenDoors;
    }

}