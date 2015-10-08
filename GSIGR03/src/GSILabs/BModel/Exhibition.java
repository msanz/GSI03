/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Date;

/**
 * An exhibition is lasting event
 * @author GR03
 */
public class Exhibition implements LastingEvent {
    private String name;
    private String org;
    private DateEvent date;
    private Artist performer;
    private Location location;
    private Performer[] performers;
    private String[] links;
    
    /**
     * Create a new exhibition
     * @param name the name of the exhibition
     * @param org who organize the event
     * @param date the date of the event
     * @param performer who takes part of the exhibition (one)
     * @param location where is the exhibition
     * @param links severals links about the exhibition
     */
    public Exhibition (String name, String org, DateEvent date, Artist performer, Location location, String[] links){
        this.name = name;
        this.org = org;
        this.date = date;
        this.performer = performer;
        this.location = location;
        this.links = links;
    }
    
     /**
     * Create a new exhibition
     * @param name the name of the exhibition
     * @param org who organize the event
     * @param date the date of the event
     * @param performers who takes part of the exhibition (two or more)
     * @param location where is the exhibition
     * @param links severals links about the exhibition
     */
    public Exhibition (String name, String org, DateEvent date, Performer[] performers, Location location, String[] links){
        this.name = name;
        this.org = org;
        this.date = date;
        this.performers = performers;
        this.location = location;
        this.links = links;
    }
    
    /**
     * Returns the location of the exhibition
     * @return location The location of the exhibition
     */
    public Location getLocation(){
        return location;
    }
    
    /**
     * Return the links of the exhibition.
     * @return links The links of the exhibition
     */
    public String[] getLinks(){
        return links;
    }
    
    /**
     * Set the links of the exhibition.
     */
    public void setLinks(String[] links){
        this.links = links;
    }
    
    /**
     * Returns the day that the exhibition starts
     * @return date The day that the exhibition start
     */
    @Override
    public Date getStartDate() {
        return date.getDayStart();
    }

     /**
     * Returns the day that the exhibition end
     * @return date The day that the exhibition end
     */
    @Override
    public Date getEndingDate() {
        return date.getDayFinish();
    }
    
    /**
     * Returns the name of the exhibition
     * @return name The name of the exhibition
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Returns the day that the concert starts and finishs.
     * Because the both are the same day.
     * @return the days that the concert start and finish
     */
    @Override
    public Date[] getDates() {
       Date[] dates = {date.getDayStart(), date.getDayFinish()};
       return dates;
    }

    /**
     * Checks if the performer has involved in the exhibition. It is compare by name
     * @param p An unique performer object
     * @return true if and only if the performer has involved in the exhibition
     */
    @Override
    public boolean involvesPerformer(Performer p) {
        if (p.getName().toLowerCase().equals(performer.getName().toLowerCase()))
            return true;
        else
            for(Performer performer: performers){
                if(performer.getName().toLowerCase().equals(p.getName().toLowerCase()))
                        return true;
            }
        return false;
    }
    
    /**
     * Returns the performers of the concert.
     * @return Returns the performers of the concert.
     */
    @Override
    public Performer[] getPerformers() {
        if (performers == null){
            return null;
        }    
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
        return "Name exhibition: " + name +
               "\n" + org +  
               "\n" + location +
               "\n" + performer +
               "\n" + date;
    }
    
    /**
     * Compare two objects by name and location
     * @param o Object
     * @return true if and only if two objects have the same name and location if not false
     */
    @Override
    public boolean equals(Object o ) {
        if (o instanceof Exhibition){ 
            Exhibition c = (Exhibition)o;
            return (this.getName().toLowerCase().equals(c.getName().toLowerCase()) 
                    && this.getLocation().equals(c.getLocation()));
        }
        return false;
    }
}