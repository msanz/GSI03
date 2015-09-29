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
 * A sale represents that a client buys a ticket
 * @author GR03
 * @version 1.0
 */

public class Sale {
    Date date;
    int[] ticketID;
    
    /** 
     * Create a new Sale.
     * @param date the moment when the ticket is buyed by the client
     * @param ticketID ids that client buy. Each id represents a pass for the event
     */
    public Sale ( Date date, int[] ticketID){
        this.date = date;
        this.ticketID = ticketID;
    }
    
     /**
     * Rewriting the toString() method
     * @return Other style to show the information
     */
    @Override
    public String toString() {
        String salesTickets = "";
        
        for (int i = 0; i < ticketID.length; i++) {
            salesTickets = salesTickets + "\n" + i + ticketID[i];
        }
        
        return "Date: " + date + "\n" + "ticket ids: " + salesTickets;
    }
}
