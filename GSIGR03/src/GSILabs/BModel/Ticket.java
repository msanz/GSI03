/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import GSILabs.serializable.XMLRepresentable;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A ticket is a object that allows to enter to a event.
 * Is associated with event name.
 * All the tickets are different
 * @author GR03
 * @version 1.0
 */
public class Ticket implements XMLRepresentable {
    
    String eventName;
    int id;
    int numberOfPersons;
    int numberOfUses;
    float price;
    boolean used;
    
    /**
     * Create a new Ticket. Only needs a event name, and a atomic integer object initialize.
     * @param eventName The name of the event
     * @param atomicInteger The atomic integer object, for creating ticket's ids
     */
    public Ticket (String eventName, AtomicInteger atomicInteger){
        this.eventName = eventName;
        this.id = atomicInteger.getAndIncrement();
        this.used = false;
    }
    
    /**
     * Set the number of persons that this ticket is going to authorize 
     * @param numberOfPersons number of persons for this ticket
     * 
     */
    public void setNumberOfPersons(int numberOfPersons){
        
        this.numberOfPersons = numberOfPersons;
        this.numberOfUses = numberOfPersons;
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
            numberOfUses--;
            if (numberOfUses == 0)
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
    
    /** 
     * Check if two tickets for a event has the same id
     * @param o object to compare
     * @return true if and only if the object to compare is a ticket for the same event and has the same id, false otherwise.
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Ticket){
            Ticket ticket = (Ticket) o;
            return (eventName.equals(ticket.eventName)) && (id == ticket.id);
        }else{
            return false;
        }
    }

    /** 
     * Generate a hashCode based in event's name
     * @return hashCode for the new event
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.eventName);
        return hash;
    }
    
    /**
     * Override toString method from class Object
     * @return ticket information in a specific format
     */
    @Override
    public String toString(){
        return "Event Name: " + eventName + "\n" +
                " id: " + this.id + "\n" +
                " numberOfPersons: " + numberOfPersons + "\n" +
                " remaining: " + numberOfUses;
    }
    
    /**
     * Get the event from a ticket
     * @return a string with the name of the ticket's event
     */
    public String getEventNameInTicket() {
        return this.eventName;
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("ticket",Ticket.class);
        String xml = xstream.toXML(this);
        return xml;
    }

    @Override
    public boolean saveToXML(File f) {
                
        String xml = this.toXML();

        try (FileWriter writer = new FileWriter(f)) {
            writer.write(xml);
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(Artist.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    @Override
    public boolean saveToXML(String filePath) {
        return saveToXML(new File(filePath));
    }
}