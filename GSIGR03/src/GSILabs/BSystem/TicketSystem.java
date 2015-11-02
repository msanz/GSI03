/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BSystem;

import GSILabs.BModel.Client;
import GSILabs.BModel.Event;
import GSILabs.BModel.Ticket;
import java.util.HashSet;
import java.util.Iterator;

/**
 * This is a system that administrate the ticket sales to the clients
 * @author GR03
 * @version 1.0
 */
public class TicketSystem {
    HashSet<Ticket> tickets;
    HashSet<Ticket> ticketSales;
    
    /**
     * Creating a two new hashsets. One for all the tickets that can be selled. The second is for all the tickts selled
     */
    TicketSystem() {
        tickets = new HashSet<>();
        //Added a second hashset of tickets, for saving all the sales, and clean the tickets hash set
        //All methods are rewrited.
        ticketSales = new HashSet<>();
    }
    
    public Ticket[] getTicketsForEvent(String eventName) {
        Iterator ticketsIterator = tickets.iterator();
        Ticket ticket;
        int cont = 0;
        Ticket[] ticketsForEvent = new Ticket[tickets.size()];
        while (ticketsIterator.hasNext()) {
            ticket = (Ticket) ticketsIterator.next();
            if(ticket.getEventNameInTicket().equals(eventName)) {
                ticketsForEvent[cont] = ticket;
                cont++;
            }
        }
        return ticketsForEvent;
    }
    
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
        }else{
            return false;
        }
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
        Iterator it2 = ticketSales.iterator();
        Ticket ticket;
        Ticket ticket2;
        boolean exist = false;
        //check it using hascode();
        while (it.hasNext()) {
            ticket = (Ticket) it.next();
            if ( t.hashCode() == ticket.hashCode() ) {
                exist = true;
            }
        }
        while (it2.hasNext() && exist != true ) {
            ticket2 = (Ticket)it2.next();
            if ( t.hashCode() == ticket2.hashCode() ) {
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
    boolean setIDUsed(Ticket t, Event e, int id) {
        Iterator ticketsIterator = tickets.iterator();
        Iterator salesIterator = ticketSales.iterator();
        Ticket ticket1;
        Ticket ticket2;
        boolean didit = false;
        while (ticketsIterator.hasNext() ) {
            ticket1 = (Ticket)ticketsIterator.next();
            if ( t.hashCode() == ticket1.hashCode() ) {
                if (ticket1.getEventNameInTicket().equals(e.getName())) {
                    ticket1.useTicket();
                }
            }
            ticket2 = (Ticket)salesIterator.next();
            if ( t.hashCode() == ticket2.hashCode() ) {
                if (ticket2.getEventNameInTicket().equals(e.getName())) {
                    ticket2.useTicket();
                }
            }
        }
        return didit;
    }
    
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
        Ticket ticket;
        HashSet sales;
        sales = c.getCreditCard();
        Iterator it = tickets.iterator();
        Iterator cr = sales.iterator();
        String creditCard;
        //check if ticket exist
        while (it.hasNext()) {
            ticket = (Ticket)it.next();
            if ( t.hashCode()== ticket.hashCode() ) {
                while(cr.hasNext()) {
                    creditCard = (String)cr.next();                
                    if ( creditCard.equals(cCard) ) {
                        if (t.checkTicketUsed() == false ) {
                            t.setPrice(price);
                            //For now, all tickets have 2 uses available when are selled
                            t.setNumberOfPersons(2);
                            c.addTicket(t);
                            ticketSales.add(t);
                            tickets.remove(t);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}


    
