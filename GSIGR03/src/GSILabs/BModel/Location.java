/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

/**
 *
 * @author GR03
 */
public class Location {
    
    String name;
    int capacity;
    Coordinates gps;
    String web;
    
    public Location(String name, int capacity, Coordinates gps, String web){
        this.name = name;
        this.capacity = capacity;
        this.gps = gps;
        this.web = web;
    }

    public Location(String name, int capacity, Coordinates gps){
        this.name = name;
        this.capacity = capacity;
        this.gps = gps;
        this.web = "Unknown";
    }
    
    public String getName(){
        return name;
    }
    
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
        if (o == null) return false;
        Location l = (Location)o;
        return this.getName().equals(l.getName());
    }
}
