/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.BModel;

import java.util.HashSet;

/**
 * A client is someone who buy a ticket
 * @author GR03
 * @version 1.0
 */
public class Client {
    
    private int DNI;
    private String name;
    private String surName1;
    private String surName2;
    private DateGeneral birthday;
    private HashSet<String> creditCard;
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
        return (card.matches("\\d{16,16}") && !card.equals(""));
    }
    
    /**
     * Add a credit card to the credit pool
     * @param card string with credit card
     * @return true if the credit card is well formed and it adds to the pool false in other cas
     */
    public boolean addCreditCard(String cCard){
        if(validateCreditCard(cCard))
        {
            return this.creditCard.add(cCard);
        }
        return false;
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
    
    public HashSet<Ticket> getSales() {
        return sales;
    }
    
    public void setSales(HashSet<Ticket> sales) {
        this.sales = sales;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Client){
            Client client = (Client) o;
            return this.getDNI() == client.getDNI();
        }
        return false;
    }

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
                " Name: " + getName() +
                " Surnames: " + getSurName1() + " " + getSurName2() +
                " Birth date: " + getBirthday();
    }
}
