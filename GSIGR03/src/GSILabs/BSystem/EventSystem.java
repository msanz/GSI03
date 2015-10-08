/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BSystem;

import GSILabs.BModel.Concert;
import GSILabs.BModel.Event;
import GSILabs.BModel.Exhibition;
import GSILabs.BModel.Festival;
import GSILabs.BModel.Location;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 * EventSystem is a subsystem for manage a hashset of events
 * @author GR03
 * @version 1.0
 */
public class EventSystem {

    private final HashSet<Event> events;
    
    /**
    * Create a new Event System with a hashset of events.
    */
    public EventSystem(){
        events = new HashSet<>();
    }
    
    /**
     * Adds a new concert to the system. Note that setting up the concert should not produce
     *  any kind of clash with the existing concerts, etc.
     * @param c The concert to be added
     * @return True if an only if the concert c was not null, was well formed and did
     *  not clash with the information already in the system. False otherwise.
     */
    public boolean addNewConcert(Concert c) {
        if (c.getPerformers().length == 1){
            for (Event e: events){
               if (e.involvesPerformer(c.getPerformers()[0])){
                   if (!c.collisionDay(e.getDates()[0])){
                       return events.add(c);
                   }
               }    
            }
        }else{
            events.add(c);
        }
        return false;
    }

    /**
     * Replace an existing concert. The system must be able to indentify the concert
     *  as "already existing", then proceed for its replacement.
     * @param c The concert to be added
     * @return True if an only if the concert c was not null, was well formed and did
     *  not clash with the information already in the system. False otherwise.
     */
    public boolean replaceConcert(Concert c) {
       for (Event e:events){
            if (existsEvent(c)){
                events.remove(e);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Deletes a concert from the system. In case c did not exist in the system, 
     *  this action has no impact.
     * @param c The concert to be removed
     * @return True if an only if the concert c was not null, and existed 
     *  already in the system. False otherwise.
     */
    public boolean deleteConcert(Concert c) {
       return (c != null) ? events.remove(c) : false;
    }
    
    /**
     * Adds an exhibition to the system.
     * @param e The exhibition to be added.
     * @return True if e is not null, well formed and does not produce a clash with 
     *  the information already in the system.
     */   
    public boolean addNewExhibition(Exhibition e) {
        return events.add(e);
    }

    /**
     * Replaces the information in the system related to the Exhibition e.
     * @param e The new version of the exhibition
     * @return True if an only if a previous version of the exhibition existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    public boolean replaceExhibition(Exhibition e) {
        for (Event event:events){
            if (existsEvent(e)){
                events.remove(event);
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes an exhibition from the system
     * @param e The exhibition to be deleted
     * @return True if and only if e is not null, e existed in the system and it could be
     *  removed from the system
     */
    public boolean deleteExhibition(Exhibition e) {
        return (e != null) ? events.remove(e) : false;
    }

    /**
     * Adds a new festival to the system
     * @param f The festival to be added
     * @return True if an only if f is not null, well formed and could be added to the system
     */
    public boolean addNewFestival(Festival f) {
        return (f != null) ? events.add(f) : false;
    }

    /**
     * Adds a new concert to an existing festival
     * @param f The festival to which the concert is to be added
     * @param c The concert itself
     * @return True if and only if both arguments are not null, both are well formed 
     *  and the information could be added not causing any clash with the existing information
     */
    public boolean addConcertToFestival(Festival f, Concert c) {
        if(events.contains(c)) {
            return f.addConcert(c);
        }
        else {
            return false;
        }
    }

    /**
     * Replaces the information in the system related to the Festival f.
     * @param f The new version of the festival
     * @return True if an only if a previous version of the festival existed,
     *  f is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    public boolean replaceFestival(Festival f) {
        for (Event event:events){
            if (existsEvent(f)){
                events.remove(event);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Deletes the festival f from the system. It also deletes all of the concerts 
     *      associated with it.
     * @param f The festival to be removed
     * @return True if the festival existed and could be removed, together with all 
     *  the concerts it was composed of.
     */
    public boolean deleteFestival(Festival f) {
        return (f != null) ? events.remove(f) : false;
    }

     /**
     * Checks whether an event is already registered in the system
     * @param e The event to be checked
     * @return True if and only if e is not null, well formed and did exist in the system
     */
    public boolean existsEvent(Event e) {
        if (e != null){
            for (Event event:events){
                if (event.equals(e)){
                    return true;
                }
            }
        }    
        return false;
    }
    
    /**
     * Retrieves all the events whose name matches (partially) with the name
     * @param name Full or partial name of the events
     * @return A list of events, potentially being empty
     */
    public Event[] retrieveEvents(String name) {
        ArrayList<Event> list = new ArrayList();
        for (Event e:events){
            if (e.getName().contains(name)){
                list.add(e);
            }
        }
        if (list.isEmpty()){
            return null;
        }else{
            return (Event[]) list.toArray();
        }
    }

    /**
     * Retrieves all the events associated with an specific location
     * @param loc Location of interest
     * @return A list of events, potentially being empty
     */
    public Event[] retrieveEvents(Location loc) {
        ArrayList<Event> list = new ArrayList();
        for (Event e:events){
            if (retrieveConcert(e) != null){
                if (retrieveConcert(e).getLocation().equals(loc)){
                    list.add(e);
                }
            }
        }
        if (list.isEmpty()){
            return null;
        }else{
            return (Event[]) list.toArray();
        }
    }

    /**
     * Retrieves all the events at some given date
     * @param d Date of interest
     * @return A list of events, potentially being empty
     */
    public Event[] retrieveEvents(Date d) {
        return null;
    }
    
    /**
     * Retrieve a concert object
     * @param e Event object
     * @return An unique concert, if and only if the event is a concert else return null
     */
    public Concert retrieveConcert(Event e){
        return (e instanceof Concert) ? (Concert) e : null;
    }
    
    /**
     * Retrieve a festival object
     * @param e Event object
     * @return An unique festival, if and only if the event is a festival else return null
     */
    public Festival retrieveFestival(Event e){
        return (e instanceof Festival) ? (Festival) e : null;
    }
    
    /**
     * Retrieve a exhibition object
     * @param e Event object
     * @return An unique exhibition, if and only if the event is a exhibition else return null
     */
    public Exhibition retrieveExhibition(Event e){
        return (e instanceof Exhibition) ? (Exhibition) e : null;
    }
}
