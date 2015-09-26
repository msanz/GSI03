/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BSystem;

import GSILabs.BModel.Client;
import GSILabs.BModel.Event;
import GSILabs.BModel.Location;
import GSILabs.BModel.Ticket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author iecha
 */
public class TicketSystem {
    HashSet<Ticket> tickets;
    
    TicketSystem() {
        tickets = new HashSet<Ticket>();        
    }
    
    
    // Ticket management
    
    /**
     * Adds a new ticket to the pool
     * @param t The new ticket
     * @return True if an only if t is not null, it is well formed and can be added 
     *  to the system
     */
    boolean addNewTicket(Ticket t) {
        if (t.equals(t)) {
            tickets.add(t);
            return true;
        }
        else
            return false;
    }
    
    /**
     * Checks whether there exists some collision of the tickets in the system and
     *  the ticket t
     * @param t The candidate ticket
     * @return True if an only if the ticket t contains event id's which are already
     *      part of another ticket.
     */
    boolean hasIDCollision(Ticket t) {
        Iterator it = tickets.iterator();
        Ticket ticket;
        boolean exist = false;
        //check it using hascode();
        while (it.hasNext()) {
            ticket = (Ticket) it.next();
            if ( t.hashCode()== ticket.hashCode() ) {
                exist = true;
            }
        }
        return exist;
    }
    
    /**
     * Checks whether an identifier is not assigned to any ticket.
     * @param e The event of interest
     * @param id    The identifier of interest
     * @return True if and only if the Event e exists in the system, and no ticket
     *      includes the identifier id
     */
    boolean availableTicketID(Event e, int id) {
        //ver si tengo tickets de ese evento, y aun no esta ese hashcode en mi hashset
        Iterator it = tickets.iterator();
        Ticket ticket;
        boolean exist = false;
        while (it.hasNext()) {
            ticket = (Ticket) it.next();
            if (e.getName().equals(ticket.getEventNameInTicket())) {
                if ( id == ticket.hashCode()) {
                    exist = true;
                }
            }
        }
        return exist;
    }
    
    /**
     * Let the system know that the identifier id, as part of the ticket t,
     *  has been used to access the event e.
     * @param t The ticket
     * @param e The event
     * @param id    The identifier
     * @return True if and only if the Ticket exists, is associated with the Event e,
     *      contains the identifier id and it was not used before.
     */
    boolean setIDUsed(Ticket t,Event e, int id) {
        //comprobar si existe el ticket, si corresponde a mi evento, y si no ha quemado todas sus plazas.
        Iterator it = tickets.iterator();
        Ticket ticket;
        boolean didit = false;
        while (it.hasNext() ) {
            ticket = (Ticket)it.next();
            if ( t.hashCode()== ticket.hashCode() ) {
                if (ticket.getEventNameInTicket().equals(e.getName())) {
                    ticket.useTicket();
                }
            }
        }
        
        return didit;
    }
    
    //Sales and so
    /**
     * Registers the sale of an existing ticket to an existing client.
     * @param t     The ticket to be sold
     * @param c     The client who buys the ticket
     * @param price The price of the sale
     * @param cCard The card the transaction was performed with
     * @return  True if and only if the ticket, client and card existed, and the 
     *      sale could be registered (e.g. the ticket was not sold in beforehand, etc.)
     */
    boolean addSale(Ticket t,Client c,Float price,String cCard) {
        //meterle al hashset del cliente, el ticket en su lista.
        Iterator it = tickets.iterator();
        Ticket ticket;
        TreeSet sales;
        sales = c.getCreditCard();
        Iterator cr = sales.iterator();
        String creditCard;
        //check if ticket exist
        while (it.hasNext()) {
            ticket = (Ticket)it.next();
            if ( t.hashCode()== ticket.hashCode() ) {
                while(cr.hasNext()) {
                    creditCard = (String)cr.next();                
                    if ( creditCard.equals(cCard) ) {
                        if (t.getUsedStatus() == false ) {
                            t.setPrice(price);
                            c.addTicket(t);
                            return true;
                        }
                    }
                }
            }
        
    }
        return false;
    }
}


    

