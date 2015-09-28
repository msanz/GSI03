/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

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
     * @param name
     * @param capacity
     * @param gps 
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
     * @return 
     */
    public int getCapacity(){
        return capacity;
    }
    
    @Override
    public String toString() {
        return "Name location: "+ name +
                "\nCapacity: " + capacity +
                "\nGPS: (" + gps.x +", " + gps.y + ")" + 
                "\nWeb: " + web;
    }
    
    @Override
    public boolean equals(Object o ) {
        if (o instanceof Location){ 
            Location l = (Location)o;
            return this.getName().toLowerCase().equals(l.getName().toLowerCase());
        }
        return false;
    }
}
