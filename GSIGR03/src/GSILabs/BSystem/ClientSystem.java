/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BSystem;

import GSILabs.BModel.Client;
import GSILabs.BModel.Ticket;
import java.util.HashSet;
import java.util.Iterator;

/**
 * A clientSystem is a subsystem from BussinessSystem, that manage a hashset of clients objects.
 * @author GR03
 */
public class ClientSystem {
    
    HashSet<Client> clients;
    
    /**
     * Initialicing hasset of clients
     */
    public ClientSystem() {
        clients = new HashSet<>();  
    }
    
    /**
     * Adds a new client to the system
     * @param c The client to be added
     * @return True if and only if c is not null, well formed and could be added
     *  to the system
     */
    public boolean addClient(Client c) {
        if (c.getBirthday().checkBirthday())
            return clients.add(c);
        return false;
    }

    /**
     * Replaces the information in the sytem related to the Client c.
     * @param c The new version of the client
     * @return True if an only if a previous version of the client existed,
     *  c is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    public boolean modifyClient(Client c) {
        
        boolean clientFound = false;
        
        if (    (c != null) &&
                (!"".equals(c.getName())) &&
                (c.getBirthday().checkBirthday()) &&
                containsClient(c) ) {
            
            Iterator clientsIterator = clients.iterator();
            Client client;
            //Look for de client with the same DNI that c
            while (clientsIterator.hasNext() && !clientFound)
            {
                client = (Client) clientsIterator.next();
                
                if(client.equals(c))
                {
                    clientFound = true;
                    //modify client data
                    HashSet<Ticket> sales = client.getSales();
                    clients.remove(client);
                    //maintain client sales
                    c.setSales(sales);
                    clients.add(c);
                }
            }
        }
        //return true if everything is well done and false otherwise
        
        return clientFound;
    }

    /**
     * Adds a new card to the list of cards of a given client
     * @param c     The client
     * @param cCard The identified of the new card
     * @return  True if and only if the client exists, cCard is well formed and 
     *      the card did not exist already for that client.
     */
    public boolean addCardToClient(Client c, String cCard) {
        
        if(containsClient(c) && !cCard.isEmpty())
        {
            return c.addCreditCard(cCard);
        }
        return false;
    }
   
    /**
     * Checks whether a client exists in the system
     * @param c The client to be checked
     * @return True if an only if c is not null, well formed and exists in the system.
     */
    public boolean containsClient(Client c) {
        
        Iterator clientsIterator = clients.iterator();
        boolean clientFound = false;
        Client client;
        
        while (clientsIterator.hasNext() && (!clientFound))
        {
            client = (Client)clientsIterator.next();
            
            if(client.equals(c))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks whether there exits a client with an identifier matching the argument
     * @param id Identifier of interest
     * @return True if an only if a client has the given identifier
     */
    public boolean containsClient(int id) {
        
        Iterator clientsIterator = clients.iterator();
        boolean clientFound = false;
        Client client;
       
        while (clientsIterator.hasNext() && !clientFound)
        {
            client = (Client) clientsIterator.next();
            
            if(client.getDNI() == id)
            {
                clientFound = true;
            }
        }
        
        return clientFound;
    }
    
    /**
     * Retrieves the client associated with an identifier
     * @param identifier Idenfifier of interest
     * @return The client, or null if no such Client exists
     */
    public Client retrieveClient(int identifier) {
        
        if(containsClient(identifier))
        {
            Iterator clientsIterator = clients.iterator();
            boolean clientFound = false;
            Client client;

            while (clientsIterator.hasNext() && (!clientFound))
            {
                client = (Client)clientsIterator.next();

                if(client.getDNI() == identifier)
                {
                    return client;
                }
            }
        }
        return null;
    }

    /**
     * Retrieves the tickets associated to a given client
     * @param c The client of interest
     * @return The list of tickets that has been sold to the client, if any.
     */
    public Ticket[] getListOfTickets(Client c) {
        
        return (Ticket[]) retrieveClient(c.getDNI()).getSales().toArray();
    }
    
    /**
     * Retrieves the amount of money spent by the client in tickets
     * @param c The client of interest
     * @return The sum of the prices of the tickets
     */
    public float getTotalSpending(Client c) {
        
        float sum = 0;
        
        for (Ticket ticket: retrieveClient(c.getDNI()).getSales())
        {
            sum = sum + ticket.getPrice();
        }
        
        return sum;
    }
}