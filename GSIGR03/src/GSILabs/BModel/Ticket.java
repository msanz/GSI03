/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A ticket is a object that allows to enter to a event. Is associated with event name.
 * All the tickets are diferent
 * @author GR03
 */
public class Ticket {
    
    String eventName;
    int id;
    int numberOfPersons;
    int numberOfUsed;
    float price;
    boolean used;
    
    /**
     * ticket constructor. Only needs a event name, and a atomic integer object initializated.
     * @param eventName The name of the event
     * @param atomicInteger The atomic integer object, for creating ticket's ids
     */
    public Ticket (String eventName, AtomicInteger atomicInteger){
        this.eventName = eventName;
        this.id = (int)atomicInteger.getAndIncrement();
        this.used = false;
    }
    
    /**
     * Set the number of persons that this ticket is going to authorice 
     * @param numberOfPersons number of persons for this ticket
     * 
     */
    public void setNumberOfPersons(int numberOfPersons){
        this.numberOfPersons = numberOfPersons;
        this.numberOfUsed = numberOfPersons;
    }
    
    /**
     * A simply method for check ticket status
     * @return used var, that can be true if used or false if not
     */
    public boolean checkTicketUsed(){
        return used;
    }
    
    /**
     * This method checks how many times a ticket was used, and mark it as used if number of used
     * is 0. If not 0, decrement it one unit
     */
    public void useTicket() {
        
        if (checkTicketUsed())
        {
            numberOfUsed--;
            if (numberOfUsed == 0)
                this.setUsed();
        }
    }
    
    /**
     * This method only set used to true
     */
    private void setUsed(){
        this.used = true;
    }
    
    /**
     * Sets a ticket's price passed in float parameter
     * @param price the price of the ticket
     */
    public void setPrice(float price){
        this.price = price;
    }
    
    /**
     * This only returns the price attribute
     * @return the price of this ticket 
     */
    public float getPrice()
    {
        return price;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Ticket){
            Ticket ticket = (Ticket) o;
            return (eventName.equals(ticket.eventName)) && (id == ticket.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.eventName);
        return hash;
    }
    
    @Override
    public String toString(){
        return "Event Name: " + eventName + "\n" +
                " id: " + id + "\n" +
                " numberOfPersons: " + numberOfPersons + "\n" +
                "price :" + price + "\n" +
                " numberOfUsed: " + numberOfUsed;
    }
    
    /**
     * This returns a string with the name of the ticket's event
     * @return 
     */
    public String getEventNameInTicket() {
        return this.eventName;
    }
    
    
}
