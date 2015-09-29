/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Comparator;
import java.util.Date;

/**
 * Implements Comparator in order to can sort the concerts
 * @author GR03
 * @version 1.0
 */
public class DateComparator implements Comparator<DateEvent> {
    @Override
    public int compare(DateEvent o1, DateEvent o2) {
        Date normalDateStart1 = o1.getDayStart();
        Date normalDateStart2 = o2.getDayStart();
        Date normalDateFinish1 = o1.getDayFinish();
        Date normalDateFinish2 = o2.getDayFinish();
        
        long date1StartInLong = normalDateStart1.getTime();
        long date2StartInLong = normalDateStart2.getTime();
        long date1FinishInLong = normalDateFinish1.getTime();
        long date2FinishInLong = normalDateFinish2.getTime();
        
        if (date1StartInLong == date2StartInLong) {
            return 1;
        }
        else
            return 0;
        /*
        if (o1.getDayStart().before(o2.getDayStart())){
            return -1;
        }
        
        if (o1.getDayStart().after(o2.getDayStart())){
            return 1;
        }
        */
        
        //return 0;
    }
    
}
