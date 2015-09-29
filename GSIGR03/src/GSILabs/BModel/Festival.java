/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.BModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A festival is an event composed of two or more concerts.
 * @author GR03
 * @version 1.0
 */
public class Festival implements LastingEvent {
    
    private SortedSet<Concert> concerts;
    private HashSet<Location> locations;
    private String name;
    
    /** 
     * Create a new Festival.In locations there are all concert's locations.
     * @param name name of the festival. this name should be unique
     */
    public Festival (String name){
        this.name = name;        
        this.locations = new HashSet<>();
        this.concerts = new TreeSet<>();
    }
    
    /**
     * Adds a concert to the festival
     * @param concert the concert to add
     * @return true if and only if the concert is add to the festival
     */
    public boolean addConcert(Concert concert){
        return (locations.add(concert.getLocation()) && concerts.add(concert));
    }
    
    /**
     * Delete a concert from the festival
     * @param concert the concert to remove
     * @return true if and only if the concert is remove from the festival
     */
    public boolean deleteConcert(Concert concert){
        return (locations.remove(concert.getLocation()) && concerts.remove(concert));
    }
    
    /**
     * Get festival's start date 
     * @return the start date from the first concert in the festival.
     */
    @Override
    public Date getStartDate() {
        return concerts.first().getStartDate();
    }

    /**
     * Get festival's ending date
     * @return the ending date from the last concert in the festival
     */
    @Override
    public Date getEndingDate() {
        return concerts.last().getStartDate();
    }

    /** 
     * Get festival's name
     * @return the name of the festival
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * TO-DO : quitar duplicados && comprobar que están ordenadas
     * Get all the dates of the festival's concerts
     * @return array that contains all the dates of the concerts in the festival
     */
    @Override
    public Date[] getDates() {
        ArrayList<Date> dates = new ArrayList();
        for (Concert c:concerts){
             dates.add(c.getDates()[0]);
        }
        return (Date[]) dates.toArray();
    }

    /**
     * Check if a performer is involved in the festival.
     * @param p performer to lookfor
     * @return true if and only if a performer is involved in a festival
     */
    @Override
    public boolean involvesPerformer(Performer p) {
        for (Concert c:concerts){
            if(c.involvesPerformer(p)){
                return true;
            }
        }
        return false;
    }

    /**
     * Get performers from the festival
     * @return returns an array that contains the performers of the festival
     */
    @Override
    public Performer[] getPerformers() {
       ArrayList<Performer> performers = new ArrayList();
        for (Concert c:concerts)
            performers.addAll(Arrays.asList(c.getPerformers()));
        
        return (Performer[]) performers.toArray();
    }
    
    /**
     * Get concerts sorted by date
     * @return concerts in the festival sorted by date
     */
    public SortedSet<Concert> getConcerts(){
        return concerts;
    }
    
    /**
     * Get the locations of the festival.
     * @return locations for the festival's concerts.
     */
    public HashSet<Location> getLocation(){
        return locations;
    }


}
