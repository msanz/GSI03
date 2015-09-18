/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.sql.Time;

/**
 *
 * @author GR03
 */
public class DateEvent extends Date{
    Date dayStart;
    Date dayFinish;
    Time timeStart;
    Time timeFinish;
   
    public DateEvent(Date dayStart, Time timeStart, Time timeFinish ) {
       super(dayStart, timeStart);
    }
    
    public DateEvent(Date dayStart, Date dayFinish, Time timeStart, Time timeFinish ) {
       super(dayStart, timeStart);
       this.dayStart = dayStart;
       this.dayFinish = dayFinish;
       this.timeStart = timeStart;
       this.timeFinish = timeFinish;
    }
    
}
