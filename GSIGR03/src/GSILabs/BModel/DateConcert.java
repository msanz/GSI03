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
public class DateConcert extends DateEvent {
    Time timeOpenDoors;  

    public DateConcert(Date dayStart, Date dayFinish, Time timeStart, Time timeFinish) {
        super(dayStart, dayFinish, timeStart, timeFinish);
    }
    
    public DateConcert(Date dayStart, Date dayFinish, Time timeOpenDoors, Time timeStart, Time timeFinish) {
        super(dayStart, dayFinish, timeStart, timeFinish);
        this.timeOpenDoors = timeOpenDoors;
    }
}
