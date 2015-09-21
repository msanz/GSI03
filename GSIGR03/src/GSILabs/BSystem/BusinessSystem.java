/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BSystem;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Client;
import GSILabs.BModel.Collective;
import GSILabs.BModel.Concert;
import GSILabs.BModel.Event;
import GSILabs.BModel.Exhibition;
import GSILabs.BModel.Festival;
import GSILabs.BModel.Location;
import GSILabs.BModel.Performer;
import GSILabs.BModel.Ticket;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author GR03
 */
public class BusinessSystem implements TicketOffice{
    
    HashSet<Festival> festivals;
    HashSet<Concert> concerts;
    HashSet<Exhibition> exhibitions;
    HashSet<Client> clients;
    
    @Override
    public boolean addNewConcert(Concert c) {
        return concerts.add(c);
    }

    @Override
    public boolean replaceConcert(Concert c) {
        return false;
    }

    @Override
    public boolean deleteConcert(Concert c) {
        return concerts.remove(c);
    }

    @Override
    public boolean addNewExhibition(Exhibition e) {
        return exhibitions.add(e);
    }

    @Override
    public boolean replaceExhibition(Exhibition e) {
        return false;
    }

    @Override
    public boolean deleteExhibition(Exhibition e) {
        return exhibitions.remove(e);
    }

    @Override
    public boolean addNewFestival(Festival f) {
        return festivals.add(f);
    }

    @Override
    public boolean addConcertToFestival(Festival f, Concert c) {
        return f.addConcert(c);
    }

    @Override
    public boolean replaceFestival(Festival f) {
        return false;
    }

    @Override
    public boolean deleteFestival(Festival f) {
        return festivals.remove(f);
    }

    @Override
    public boolean existsEvent(Event e) {
        return false;
    }

    @Override
    public Event[] retrieveEvents(String name) {
        return null;
    }

    @Override
    public Event[] retrieveEvents(Location loc) {
        return null;
    }

    @Override
    public Event[] retrieveEvents(Date d) {
        return null;
    }

    @Override
    public boolean addClient(Client c) {
        
        return clients.add(c);
    }

    @Override
    public boolean modifyClient(Client c) {
        return false;
    }

    @Override
    public boolean addCardToClient(Client c, String cCard) {
        return c.addCreditCard(cCard);
    }

    @Override
    public boolean containsClient(Client c) {
        return false;
    }

    @Override
    public boolean containsClient(int id) {
        return false;
    }

    @Override
    public Client retrieveClient(int identifier) {
        return null;
    }

    @Override
    public Ticket[] getListOfTickets(Client c) {
        return null;
    }

    @Override
    public float getTotalSpending(Client c) {
        return (float)0.0;
    }

    @Override
    public boolean addNewTicket(Ticket t) {
        return false;
    }

    @Override
    public boolean hasIDCollision(Ticket t) {
        return false;
    }

    @Override
    public boolean availableTicketID(Event e, int id) {
        return false;
    }

    @Override
    public boolean setIDUsed(Ticket t, Event e, int id) {
        return false;
    }

    @Override
    public boolean addSale(Ticket t, Client c, Float price, String cCard) {
        return false;
    }

    @Override
    public boolean addLocation(Location loc) {
        return false;
    }

    @Override
    public Location getLocation(String name) {
        return null;
    }

    @Override
    public boolean deleteLocation(Location loc) {
        return false;
    }

    @Override
    public Location[] getLocations(int minCapacity) {
        return null;
    }

    @Override
    public boolean addArtist(Artist a) {
        return false;
    }

    @Override
    public boolean addCollective(Collective c) {
        return false;
    }

    @Override
    public boolean modifyArtist(Artist a) {
        return false;
    }

    @Override
    public boolean modifyCollective(Collective c) {
        return false;
    }

    @Override
    public boolean removePerformer(String performerName) {
        return false;
    }

    @Override
    public boolean existsPerformer(String performerName) {
        return false;
    }

    @Override
    public boolean existsArtist(String artistName) {
        return false;
    }

    @Override
    public boolean existsCollective(String artistName) {
        return false;
    }

    @Override
    public Performer retrievePerformer(String performerName) {
       return null;
    }
    
}
