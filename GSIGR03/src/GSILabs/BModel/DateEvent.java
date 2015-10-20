/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Date;
import java.util.Objects;

/**
 * This class managed the date of the events. This class controls the date general (day and time) that a event start and finish)
 * @author GR03
 * @version 1.0
 */
public class DateEvent extends DateGeneral{
    private final Date dayStart;
    private Date dayFinish;
    private final Date timeStart;
    private Date timeFinish;
   
    /** 
     * Create a date event with day and time
     * @param dayString string day style "dd/mm/yyyy"
     * @param timeString string time style "H:mm"
     */
    public DateEvent(String dayString, String timeString) {
        super(dayString, timeString);
        this.dayStart = super.dayFormat(dayString);
        this.timeStart = super.timeFormat(timeString);
    }
    
    /**
     * Set the day when finish the event.
     * @param string string day style "dd/mm/yyyy"
     */
    public void setDayFinish(String string){
        this.dayFinish = super.dayFormat(string);
    }
    
    /**
     * Set the time when finish the event.
     * @param string string time style "H:mm"
     */
    public void setTimeFinish(String string){
        this.timeFinish = super.timeFormat(string);
    }
    
    /**
     * Returns the day when the event start.
     * @return the day when the event start
     */
    public Date getDayStart() {
        return dayStart;
    }

    /**
     * Returns the day when the event finish.
     * @return the day when the event finish
     */
    public Date getDayFinish() {
        return dayFinish;
    }

    /**
     * Returns the time when the event start.
     * @return the time when the event start
     */
    public Date getTimeStart() {
        return timeStart;
    }

    /**
     * Returns the time when the event finish.
     * @return the time when the event finish
     */
    public Date getTimeFinish() {
        return timeFinish;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if(o instanceof DateEvent) {
            DateEvent date = (DateEvent) o;
            //comprobar que no es after ni before
            return (super.equals(date));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.dayStart);
        return hash;
    }
}