/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author GR03
 */
public class Ticket {
    
    String eventName;
    int[] ticketID;
    int numberOfPersons;
    AtomicInteger ID = new AtomicInteger();
    
    public Ticket (String eventName, int numberOfPersons){
        this.eventName = eventName;
        for (int i = 0; i<numberOfPersons;i++) {
            this.ticketID[i] = this.ID.get();
        }
    } 
    
    
    
    
   
}
