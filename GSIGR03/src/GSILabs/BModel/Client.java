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
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A client is someone who can buy tickets for diferent events
 * @author GR03
 * @version 1.0
 */
public class Client implements XMLRepresentable{
    
    private final int DNI;
    private final String name;
    private final String surName1;
    private final String surName2;
    private final DateGeneral birthday;
    private final HashSet<String> creditCard;
    private HashSet<Ticket> sales;
    
     /**
     * Create a new client
     * @param DNI A number that indentify the client
     * @param name Name of client
     * @param surName1 First surname of client
     * @param surName2 Second surname of client
     * @param birthday The day and time that client born 
     */
    public Client (int DNI, String name, String surName1, String surName2, DateGeneral birthday){
        this.DNI = DNI;
        this.name = name;
        this.surName1 = surName1;
        this.surName2 = surName2;
        this.birthday = birthday;
        this.creditCard = new HashSet<>();
        this.sales = new HashSet<>();
    }
    
    /** 
     * Validate if a credit card is well formed
     * @param card string with credit card number
     * @return true if the string is formed by 16 numeric digits
     */
    public boolean validateCreditCard(String card){
        return card.matches("\\d{16,16}");
    }
    
    /**
     * Add a credit card to the credit pool
     * @param cCard string with credit card
     * @return true if the credit card is well formed and it adds to the pool false in other cas
     */
    public boolean addCreditCard(String cCard){
        if(validateCreditCard(cCard))
        {
            return this.creditCard.add(cCard);
        }else{
            return false;
        }
    }
    
    /**
     * Set client credit cards.
     * @param cCards hashset that contains the credit cards from a client
     */
    public void setCredicCards(HashSet<String> cCards) {
        for (String cCard : cCards) {
            this.addCreditCard(cCard);
        }
    }
    
     /**
     * Add ticket to the tickets pool
     * @param t Ticket object
     * @return truei if it adds to the pool false in other case
     */
    public boolean addTicket(Ticket t) {
        return this.sales.add(t);
    }
    
    /**
     * Returns the DNI associated with the client
     * @return The DNI of the client.
     */
    public int getDNI() {
        return DNI;
    }
    
    /**
     * Returns the name associated with the client
     * @return The name of the client.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the first surname associated with the client
     * @return The first surname of the client.
     */
    public String getSurName1() {
        return surName1;
    }

    /**
     * Returns the second surname associated with the client
     * @return The second surname of the client.
     */
    public String getSurName2() {
        return surName2;
    }
    
    /**
     * Returns the birthday associated with the client
     * @return The birthday of the client
     */
    public DateGeneral getBirthday() {
        return birthday;
    }

    /**
     * Returns the credits card pool associated with the client
     * @return The credits card pool of the client
     */
    public HashSet<String> getCreditCard() {
        return creditCard;
    }
    
    /**
     * This return all the hashset of tickets from this client
     * @return the tickets buyed from this client.
     */
    public HashSet<Ticket> getSales() {
        return sales;
    }
    
    /**
     * This put a new ticket sale into the tickets hashset of the client.
     * @param sales the new hashset of sales
     */
    public void setSales(HashSet<Ticket> sales) {
        this.sales = sales;
    }
    
    
    /** 
     * Check if the client has the same DNI
     * @param o object to compare
     * @return true if and only if the object to compare is a client and has the same DNI, false otherwise.
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Client){
            Client client = (Client) o;
            return this.getDNI() == client.getDNI();
        }else{
            return false;
        }
    }

    /** 
     * Generate a hashCode based in client's DNI
     * @return hashCode for the new client
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.DNI;
        return hash;
    }
    
     /**
     * Rewriting the toString() method
     * @return Other style to show the information
     */
    @Override
    public String toString(){
        return "DNI: " + getDNI() +
                "; Name: " + getName() +
                ", " + getSurName1() + " " + getSurName2() +
                "; Birth date: " + getBirthday();
    }

    @Override
    public String toXML() { 
        XStream xstream = new XStream();
        xstream.alias("client",Client.class);
        return xstream.toXML(this);
    }

    @Override
    public boolean saveToXML(File f) {
        String xml = this.toXML();
        try (FileWriter writer = new FileWriter(f)) {
            writer.write(xml);
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    @Override
    public boolean saveToXML(String filePath) {
        return saveToXML(new File(filePath));
    }
}
