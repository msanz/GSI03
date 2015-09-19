/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

/**
 *
 * @author dani
 */
public class Ticket {
    
    String eventName;
    int[] ticketID;
    
    public Ticket (String eventName, int[] ticketID ){
        this.eventName = eventName;
        this.ticketID = ticketID;
    } 
    
}
