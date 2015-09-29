/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Objects;

/** 
 * A location is the site where a event can be placed
 * @author GR03
 */
public class Location {
    
    String name;
    int capacity;
    Coordinates gps;
    String web;
    
    /**
     * this sets a new location
     * @param name the name of the place
     * @param capacity max number of people in this place
     * @param gps the gps coordinates
     * @param web a siteweb of the location
     */
    public Location(String name, int capacity, Coordinates gps, String web){
        this.name = name;
        this.capacity = capacity;
        this.gps = gps;
        this.web = web;
    }
    
    /**
     *  The same as above but without web
     * @param name location's name
     * @param capacity location's capacity
     * @param gps gps coordinates of the location
     */
    public Location(String name, int capacity, Coordinates gps){
        this.name = name;
        this.capacity = capacity;
        this.gps = gps;
        this.web = "Unknown";
    }
    
    /**
     * Gets the name of the place
     * @return the name
     */
    public String getName(){
        return name;
    }
    
    /**
     * returns the capacity value
     * @return the capacity of the location
     */
    public int getCapacity(){
        return capacity;
    }
    
    @Override
    public String toString() {
        return "Name location: "+ name +
                "\nCapacity: " + capacity +
                "\nGPS: (" + gps.getX() +", " + gps.getY() + ")" + 
                "\nWeb: " + web;
    }
    
    /**
    * Checks if the name the objects is the same.
    * @param o Object
    * @return true if and only if the name in lowercase is the same and false otherwise
    */
    @Override
    public boolean equals(Object o ) {
        if (o instanceof Location){ 
            Location l = (Location)o;
            return this.getName().toLowerCase().equals(l.getName().toLowerCase());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
