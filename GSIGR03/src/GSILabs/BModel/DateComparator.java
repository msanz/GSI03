/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Comparator;

/**
 * Implements Comparator in order to can sort the concerts
 * @author GR03
 * @version 1.0
 */
public class DateComparator implements Comparator<DateEvent> {
    @Override
    public int compare(DateEvent o1, DateEvent o2) {
        if (o1.getDayStart().before(o2.getDayStart())){
            return -1;
        }
        
        if (o1.getDayStart().after(o2.getDayStart())){
            return 1;
        }
        
        return 0;
    }
    
}
