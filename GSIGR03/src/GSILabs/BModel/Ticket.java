/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.concurrent.atomic.AtomicLong;
import java.util.GregorianCalendar;
/**
 *
 * @author GR03
 */
public class Ticket {
    
    String eventName;
    long[] ticketID;
    int numberOfPersons;
    AtomicLong ID = new AtomicLong();
    
    public Ticket (String eventName, int numberOfPersons){
        this.eventName = eventName;
        for (int i = 0; i<numberOfPersons;i++) {
            this.ticketID[i] = getIDFromDateTime();
        }
    }
    
    private long getIDFromDateTime() {
        GregorianCalendar calendar = new GregorianCalendar();
        int year = calendar.get(GregorianCalendar.YEAR);
        int month = calendar.get(GregorianCalendar.MONTH);
        int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int hour = calendar.get(GregorianCalendar.HOUR_OF_DAY);
        int minute = calendar.get(GregorianCalendar.MINUTE);
        int second = calendar.get(GregorianCalendar.SECOND);
        long ms = System.currentTimeMillis();
        long onlyMs = ms%1000;
        long id=Long.valueOf(""+year+month+day+hour+minute+second+onlyMs);
        System.out.print(id);
        return id;
    }
    
    
    
    
   
}
