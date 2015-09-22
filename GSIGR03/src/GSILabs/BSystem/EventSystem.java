/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BSystem;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Collective;
import GSILabs.BModel.Concert;
import GSILabs.BModel.Event;
import GSILabs.BModel.Exhibition;
import GSILabs.BModel.Festival;
import GSILabs.BModel.Location;
import GSILabs.BModel.Performer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author GR03
 */
public class EventSystem {
    HashSet<Event> events = new HashSet<Event>();
    HashSet<Location> locations = new HashSet<Location>();
    HashSet<Performer> performers = new HashSet<Performer>();
    
    public boolean addNewConcert(Concert c) {
        return events.add(c);
    }

    public boolean replaceConcert(Concert c) {
        return false;
    }

    public boolean deleteConcert(Concert c) {
        return events.remove(c);
    }

    public boolean addNewExhibition(Exhibition e) {
        return events.add(e);
    }

    public boolean replaceExhibition(Exhibition e) {
        return false;
    }

    public boolean deleteExhibition(Exhibition e) {
        return events.remove(e);
    }

    public boolean addNewFestival(Festival f) {
        return events.add(f);
    }

    public boolean addConcertToFestival(Festival f, Concert c) {
        return f.addConcert(c);
    }

    public boolean replaceFestival(Festival f) {
        return false;
    }

    public boolean deleteFestival(Festival f) {
        return events.remove(f);
    }

    public boolean existsEvent(Event e) {
        return false;
    }

    public Event[] retrieveEvents(String name) {
        return null;
    }

    public Event[] retrieveEvents(Location loc) {
        return null;
    }

    public Event[] retrieveEvents(Date d) {
        return null;
    }

    public boolean addLocation(Location loc) {
        return locations.add(loc);
    }

    public Location getLocation(String name) {
        for (Location l:locations){
            if (l.getName().equals(name))
                return l;
        }
        return null;
    }

    public boolean deleteLocation(Location loc) {
        return locations.remove(loc);
    }

    public Location[] getLocations(int minCapacity) {
        ArrayList<Location> locs = new ArrayList();
        for (Location l:locations)
            if (l.getCapacity()>=minCapacity)
                locs.add(l);
        
        return (Location[]) locs.toArray();
    }

    public boolean addArtist(Artist a) {
        return performers.add(a);
    }

    public boolean addCollective(Collective c) {
        return performers.add(c);
    }

    public boolean modifyArtist(Artist a) {
       for (Performer p:performers){
            if (p.getName().equals(a.getName())){
                performers.remove(p);
                this.addArtist(new Artist(p.getName(),a.getWorkDescription(),a.getWeb()));
            }
        }
        return false;
    }

    public boolean modifyCollective(Collective c) {
        return false;
    }

    public boolean removePerformer(String performerName) {
        for (Performer p:performers){
            if (p.getName().equals(performerName))
                return performers.remove(p);
        }
        return false;
    }

    public boolean existsPerformer(String performerName) {
       for (Performer p:performers){
            if (p.getName().equals(performerName))
                return true;
        }
        return false;
    }

    public boolean existsArtist(String artistName) {
        for (Performer p:performers){
            if (p.getName().equals(artistName))
                return true;
        }
        return false;
    }

    public boolean existsCollective(String artistName) {
        for (Performer p:performers){
            if (p.getName().equals(artistName))
                return true;
        }
        return false;
    }

    public Performer retrievePerformer(String performerName) {
       for (Performer p:performers){
            if (p.getName().equals(performerName))
                return p;
        }
        return null;
    }
    
}