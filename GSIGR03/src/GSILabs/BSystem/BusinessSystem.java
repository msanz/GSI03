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
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author GR03
 */
public class BusinessSystem implements TicketOffice{
    private ClientSystem clientSystem;
    private EventSystem eventSystem;
    
    public BusinessSystem (){
        clientSystem = new ClientSystem();
        eventSystem = new EventSystem();
    }
    
    @Override
    public boolean addNewConcert(Concert c) {
        return eventSystem.addNewConcert(c);
    }

    @Override
    public boolean replaceConcert(Concert c) {
        return false;
    }

    @Override
    public boolean deleteConcert(Concert c) {
        return eventSystem.deleteConcert(c);
    }

    @Override
    public boolean addNewExhibition(Exhibition e) {
        return eventSystem.addNewExhibition(e);
    }

    @Override
    public boolean replaceExhibition(Exhibition e) {
        return false;
    }

    @Override
    public boolean deleteExhibition(Exhibition e) {
        return eventSystem.deleteExhibition(e);
    }

    @Override
    public boolean addNewFestival(Festival f) {
        return eventSystem.addNewFestival(f);
    }

    @Override
    public boolean addConcertToFestival(Festival f, Concert c) {
        return eventSystem.addConcertToFestival(f,c);
    }

    @Override
    public boolean replaceFestival(Festival f) {
        return false;
    }

    @Override
    public boolean deleteFestival(Festival f) {
        return eventSystem.deleteFestival(f);
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
        return clientSystem.addClient(c);
    }

    @Override
    public boolean modifyClient(Client c) {
        return false;
    }

    @Override
    public boolean addCardToClient(Client c, String cCard) {
        return clientSystem.addCardToClient(c,cCard);
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
        return eventSystem.addLocation(loc);
    }

    @Override
    public Location getLocation(String name) {
        return eventSystem.getLocation(name);
    }

    @Override
    public boolean deleteLocation(Location loc) {
        return eventSystem.deleteLocation(loc);
    }

    @Override
    public Location[] getLocations(int minCapacity) {
       return eventSystem.getLocations(minCapacity);
    }

    @Override
    public boolean addArtist(Artist a) {
        return eventSystem.addArtist(a);
    }

    @Override
    public boolean addCollective(Collective c) {
        return eventSystem.addCollective(c);
    }

    @Override
    public boolean modifyArtist(Artist a) {
        return eventSystem.modifyArtist(a);
    }

    @Override
    public boolean modifyCollective(Collective c) {
        return false;
    }

    @Override
    public boolean removePerformer(String performerName) {
        return eventSystem.removePerformer(performerName);
    }

    @Override
    public boolean existsPerformer(String performerName) {
       return eventSystem.existsPerformer(performerName);
    }

    @Override
    public boolean existsArtist(String artistName) {
        return eventSystem.existsArtist(artistName);
    }

    @Override
    public boolean existsCollective(String artistName) {
        return eventSystem.existsCollective(artistName);
    }

    @Override
    public Performer retrievePerformer(String performerName) {
       return eventSystem.retrievePerformer(performerName);
    }
    
}