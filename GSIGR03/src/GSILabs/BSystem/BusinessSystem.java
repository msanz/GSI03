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

/**
 *
 * @author GR03
 */
public class BusinessSystem implements TicketOffice{
    private ClientSystem clientSystem;
    private EventSystem eventSystem;
    private LocationSystem locationSystem;
    private PerformerSystem performerSystem;
    
    public BusinessSystem (){
        clientSystem = new ClientSystem();
        eventSystem = new EventSystem();
        locationSystem = new LocationSystem();
        performerSystem = new PerformerSystem();
    }
    
    @Override
    public boolean addNewConcert(Concert c) {
        return eventSystem.addNewConcert(c);
    }

    @Override
    public boolean replaceConcert(Concert c) {
        return eventSystem.replaceConcert(c);
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
        return eventSystem.replaceExhibition(e);
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
        return eventSystem.replaceFestival(f);
    }

    @Override
    public boolean deleteFestival(Festival f) {
        return eventSystem.deleteFestival(f);
    }

    @Override
    public boolean existsEvent(Event e) {
        return eventSystem.existsEvent(e);
    }

    @Override
    public Event[] retrieveEvents(String name) {
        return eventSystem.retrieveEvents(name);
    }

    @Override
    public Event[] retrieveEvents(Location loc) {
        return eventSystem.retrieveEvents(loc);
    }

    @Override
    public Event[] retrieveEvents(Date d) {
        return eventSystem.retrieveEvents(d);
    }

    @Override
    public boolean addClient(Client c) {
        return clientSystem.addClient(c);
    }

    @Override
    public boolean modifyClient(Client c) {
        return clientSystem.modifyClient(c);
    }

    @Override
    public boolean addCardToClient(Client c, String cCard) {
        return clientSystem.addCardToClient(c,cCard);
    }

    @Override
    public boolean containsClient(Client c) {
        return clientSystem.containsClient(c);
    }

    @Override
    public boolean containsClient(int id) {
        return clientSystem.containsClient(id);
    }

    @Override
    public Client retrieveClient(int identifier) {
        return clientSystem.retrieveClient(identifier);
    }

    @Override
    public Ticket[] getListOfTickets(Client c) {
        return clientSystem.getListOfTickets(c);
    }

    @Override
    public float getTotalSpending(Client c) {
        return clientSystem.getTotalSpending(c);
    }

    @Override
    public boolean addNewTicket(Ticket t) {
        return clientSystem.addNewTicket(t);
    }

    @Override
    public boolean hasIDCollision(Ticket t) {
        return clientSystem.hasIDCollision(t);
    }

    @Override
    public boolean availableTicketID(Event e, int id) {
        return clientSystem.availableTicketID(e, id);
    }

    @Override
    public boolean setIDUsed(Ticket t, Event e, int id) {
        return clientSystem.setIDUsed(t, e, id);
    }

    @Override
    public boolean addSale(Ticket t, Client c, Float price, String cCard) {
        return clientSystem.addSale(t, c, price, cCard);
    }
    
    // Locations management
    
    /**
     * Adds a new location to the system
     * @param loc   The location
     * @return  True if and only if the location is not null, is well formed and 
     *  could be added to the system.
     */
    @Override
    public boolean addLocation(Location loc) {
        return locationSystem.addLocation(loc);
    }

     /**
     * Retrieves a location by its exact name
     * @param name  The name of the location
     * @return  The location with that name, or null if it does not exist.
     */
    @Override
    public Location getLocation(String name) {
        return locationSystem.getLocation(name);
    }

     /**
     * Deletes a location from the system. This can only be done if there is no events
     *  associated with that location.
     * @param loc   The location to be removed
     * @return  True if an only if the location loc existed and could be removed.
     */
    @Override
    public boolean deleteLocation(Location loc) {
        return locationSystem.deleteLocation(loc);
    }
    
    /**
     * Retrieve the locations in the system with, at least, minCapacity attendance limit.
     * @param minCapacity   Attendance threshold
     * @return A list of 0+ locations
     */
    @Override
    public Location[] getLocations(int minCapacity) {
        return locationSystem.getLocations(minCapacity);
    }
    
    // Performer management
    
    /**
     * Adds a new artist to the system
     * @param a The new artist
     * @return True if the artist a is not null, is well formed and could be added to the
     *  system
     */
    @Override
    public boolean addArtist(Artist a) {
        return performerSystem.addArtist(a);
    }

    /**
     * Adds a new collective of artists to the system
     * @param c The new collective
     * @return True if the collective c is not null, is well formed and could be added to the
     *  system
     */
    @Override
    public boolean addCollective(Collective c) {
        return performerSystem.addCollective(c);
    }
    
    /**
     * Replaces the information in the sytem related to the artist e.
     * @param a The new version of the artist
     * @return True if an only if a previous version of the artist existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    @Override
    public boolean modifyArtist(Artist a) {
       return performerSystem.modifyArtist(a);
    }
    
    /**
     * Replaces the information in the sytem related to the collective e.
     * @param c The new version of the collective
     * @return True if an only if a previous version of the collective existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    @Override
    public boolean modifyCollective(Collective c) {
        return performerSystem.modifyCollective(c);
    }
    
    /**
     * Deletes the record of a performer from the system, provided it has no
     *  events to which it is associated
     * @param performerName The name of the performer
     * @return True if and only if the performer with that name existed and could be removed.
     */
    @Override
    public boolean removePerformer(String performerName) {
        return performerSystem.removePerformer(performerName);
    }
    
    /**
     * Checkes whether there exist a performer with that name in the system
     * @param performerName Name of interest
     * @return True if and only if it exists
     */
    @Override
    public boolean existsPerformer(String performerName) {
       return performerSystem.existsPerformer(performerName);
    }

    /**
     * Checkes whether there exist a performer with that name in the system
     * @param artistName Name of interest
     * @return True if and only if it exists
     */
    @Override
    public boolean existsArtist(String artistName) {
        return performerSystem.existsArtist(artistName);
    }

    /**
     * Checkes whether there exist a performer with that name in the system
     * @param artistName Name of interest
     * @return True if and only if it exists
     */
    @Override
    public boolean existsCollective(String artistName) {
       return performerSystem.existsCollective(artistName);
    }

     /**
     * Retrieves the record of a performer from the system by its name.
     * @param performerName The name of the performer
     * @return The performer, if existing. Null otherwise.
     */
    @Override
    public Performer retrievePerformer(String performerName) {
       return performerSystem.retrievePerformer(performerName);
    }
}