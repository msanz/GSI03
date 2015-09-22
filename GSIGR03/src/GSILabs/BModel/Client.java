/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.TreeSet;

/**
 *
 * @author GR03
 */
public class Client {
    
    private int DNI;
    private String name;
    private String surName1;
    private String surName2;
    private DateGeneral birthday;
    private TreeSet<String> creditCard;
    
    public Client (int DNI, String name, String surName1, String surName2, DateGeneral birthday){
        this.DNI = DNI;
        this.name = name;
        this.surName1 = surName1;
        this.surName2 = surName2;
        this.birthday = birthday;
    }
    
    public boolean addCreditCard(String cCard){
        return this.creditCard.add(cCard);
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
    
    @Override
    public String toString(){
        return "DNI: " + getDNI() +
                " Name: " + getName() +
                " Surnames: " + getSurName1() + " " + getSurName2() +
                " Birth date: " + getBirthday();
    }

    public int getDNI() {
        return DNI;
    }

    public String getName() {
        return name;
    }

    public String getSurName1() {
        return surName1;
    }

    public String getSurName2() {
        return surName2;
    }

    public DateGeneral getBirthday() {
        return birthday;
    }

    public TreeSet<String> getCreditCard() {
        return creditCard;
    }

}