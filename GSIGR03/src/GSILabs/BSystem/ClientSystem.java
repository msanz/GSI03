/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BSystem;

import GSILabs.BModel.Client;
import GSILabs.BModel.Event;
import GSILabs.BModel.Ticket;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author GR03
 */
public class ClientSystem {
    HashSet<Client> clients = new HashSet<Client>();
    AtomicInteger atomic;
   
    public ClientSystem(){
        atomic = new AtomicInteger();
    }
    
    public boolean addClient(Client c) {
        return clients.add(c);
    }

    public boolean modifyClient(Client c) {
        return false;
    }

    public boolean addCardToClient(Client c, String cCard) {
        return c.addCreditCard(cCard);
    }
   
    public boolean containsClient(Client c) {
        return false;
    }

    public boolean containsClient(int id) {
        return false;
    }

    public Client retrieveClient(int identifier) {
        return null;
    }

    public Ticket[] getListOfTickets(Client c) {
        return null;
    }

    public float getTotalSpending(Client c) {
        return (float)0.0;
    }

    public boolean addNewTicket(Ticket t) {
        return false;
    }

    public boolean hasIDCollision(Ticket t) {
        return false;
    }

    public boolean availableTicketID(Event e, int id) {
        return false;
    }

    public boolean setIDUsed(Ticket t, Event e, int id) {
        return false;
    }

    public boolean addSale(Ticket t, Client c, Float price, String cCard) {
        return false;
    }
}