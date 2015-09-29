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
 * This class managed the date of the events. This class controls the date general (day and time) that a event start and finish. 
 * Add this class controls the time that the open has been opened.
 * @author GR03
 * @version 1.0
 */
public class DateConcert extends DateEvent {
    private Date timeOpenDoors;  
    
    /** 
     * Create a date concert with day and time
     * @param dayString string day style "dd/mm/yyyy"
     * @param timeString string time style "H:mm"
     */
    public DateConcert(String dayString, String timeString) {
        super(dayString, timeString);
        this.timeOpenDoors = super.timeFormat(timeString);
        this.setDayFinish(dayString);
    }
    
     /**
     * Set the time when finish the event.
     * @param string string day style "H:mm"
     */
    public void setTimeOpenDoors(String string){
        this.timeOpenDoors = super.timeFormat(string);   
    }
    
    /**
     * Returns the time when the event start.
     * @return the time when the event start
     */
    public Date getTimeOpenDoors(){
        return timeOpenDoors;
    }

}