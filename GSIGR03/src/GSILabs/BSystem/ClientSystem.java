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
 *
 * @author GR03
 */
public class ClientSystem {
    
    HashSet<Ticket> tickets;
    HashSet<Client> clients;
   
    public ClientSystem() {
        
        clients = new HashSet<>();
        tickets = new HashSet<>();
    }
    
    public boolean addClient(Client c) {
        if (c.getBirthday().checkBirthday())
            return clients.add(c);
        return false;
    }

    
    public boolean modifyClient(Client c) {
        
        //validate input data. c is well formed?
        
        boolean clientFound = false;
        
        if(containsClient(c))
        {
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
                    clients.remove(client);
                    clients.add(c);
                }
            }
        }
        //return true if everything is well done and false otherwise
        
        return clientFound;
    }

    public boolean addCardToClient(Client c, String cCard) {
        return c.addCreditCard(cCard);
    }
   
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

    public Ticket[] getListOfTickets(Client c) {
        
        return (Ticket[]) retrieveClient(c.getDNI()).getSales().toArray();
        
    }

    public float getTotalSpending(Client c) {
        
        float sum = 0;
        
        for (Ticket ticket: retrieveClient(c.getDNI()).getSales())
        {
            sum = sum + ticket.getPrice();
        }
        
        return sum;
    }
}