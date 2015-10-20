/*
* This document is part of the lab material for the subject:
* Gestion de Sistemas de Informacion
* to be released at the
* Universidad Publica de Navarra
* during the first semester of the Academic Year 2015-2016
*/

package GSILabs.BModel;
import java.util.Date;
import java.util.Objects;

/**
 * A concert is a impermanent event with one or more performers.
 * @author GR03
 * @version 1.0
 */
public class Concert implements ImpermanentEvent {
    private DateConcert date;
    private String name;
    private Artist performer;
    private Location location;
    private Performer[] performers;
    
    /**
     * Create a new concert
     * @param name The name of the concert
     * @param performer The performer who takes in the concert (only one performer)
     * @param location The location where of the concert
     * @param date The date of the concert (day and time)
     */
    public Concert(String name, Artist performer, Location location, DateConcert date){
        this.date = date;
        this.name = name;
        this.performer = performer;
        this.location = location;
    }
    
    /**
     * Create a new concert
     * @param name The name of the concert
     * @param performers The performers who takes in the concert (two or more performers) 
     * @param location The location where of the concert
     * @param date The date of the concert (day and time)
     */
    public Concert(String name, Performer[] performers, Location location, DateConcert date){
        this.date = date;
        this.name = name;
        this.performers = performers;
        this.location = location;
    }
    
    /**
     * Compare two objects by name and location
     * @param o Object
     * @return true if and only if two objects have the same name and location if not false
     */
    @Override
    public boolean equals(Object o ) {
        if (o instanceof Concert){ 
            Concert c = (Concert)o;
            return (this.getName().toLowerCase().equals(c.getName().toLowerCase()) 
                    && this.getLocation().equals(c.getLocation()));
        }
        return false;
    }

    /**
     * Generate a hashcode based in name and location. 
     * @return the hash of the object
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.location);
        return hash;
    }
    
    /**
     * Returns the day that the concert starts
     * @return date The day that the concert start
     */
    @Override
    public Date getStartDate() {
        return date.getDay();
    }
    
    /**
     * Returns the location of the concert
     * @return location The location of the concert
     */
    @Override
    public Location getLocation() {
        return location;
    }
    
    /**
     * Returns the name of the concert
     * @return name The name of the concert
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the day that the concert starts and finish.
     * Because the both are the same day.
     * @return the days that the concert start and finish
     */
    @Override
    public Date[] getDates() {
       Date[] dates = {date.getDay()};
       return dates;
    }

    /**
     * Checks if the performer has involved in the concert. It is compare by name
     * @param p An unique performer object
     * @return true if and only if the performer has involved in the concert
     */
    @Override
    public boolean involvesPerformer(Performer p) {
        if (p.getName().toLowerCase().equals(performer.getName().toLowerCase())){
            return true;
        }else{
            for(Performer performer: performers){
                if(performer.getName().toLowerCase().equals(p.getName().toLowerCase())){
                    return true;
                }
            }
        }    
        return false;
    }
    
    /**
     * Returns the performers of the concert.
     * @return Returns the performers of the concert.
     */
    @Override
    public Performer[] getPerformers() {
        if (performers != null){
            return performers;
        }else{
            Performer[] list = {performer};
            return list;
        }
    }
    
    /**
     * Rewriting the toString() method
     * @return Other style to show the information
     */
    @Override
    public String toString() {
        return "Name concert: " + name +
               "\n" + location +
               "\n" + performer +
               "\n" + date;
    }
    
    /**
     * Check if the day has been a collision with other day.
     * @param day is Date
     * @return true if and only is the same day.
     */
    public boolean collisionDay(Date day){
        if (!day.before(date.getDay())){
            if (!day.after(date.getDayFinish())){
                return true;
            }
        }
        return false;
    }
}
