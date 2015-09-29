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