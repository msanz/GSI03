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
    int id;
    int numberOfPersons;
    int numberOfUsed;
    float price;
    boolean used;
    
    public Ticket (String eventName, AtomicInteger atomicInteger){
        this.eventName = eventName;
        this.id = (int)atomicInteger.getAndIncrement();
        this.used = false;
    }
    
    public void setNumberOfPersons(int numberOfPersons){
        this.numberOfPersons = numberOfPersons;
        this.numberOfUsed = numberOfPersons;
    }
    
    public boolean checkTicketUsed(){
        return used;
    }
    
    public void useTicket() {
        
        if (checkTicketUsed())
        {
            numberOfUsed--;
            if (numberOfUsed == 0)
                this.setUsed();
        }
    }
   
    private void setUsed(){
        this.used = true;
    }
    
    public void setPrice(float price){
        this.price = price;
    }
    
    public float getPrice()
    {
        return price;
    }
}
