/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import GSILabs.serializable.XMLRepresentable;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 * A location is the site where a event can be placed
 * @author GR03
 */
public class Location implements XMLRepresentable{
    
    private String name;
    private int capacity;
    private Coordinates gps;
    private String web;
    
    /**
     * Create a new location void.
     */
    public Location(){}
    
    /**
     * This sets a new location
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
     * Gets the name of the place
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Returns the capacity value
     * @return the capacity of the location
     */
    public int getCapacity(){
        return capacity;
    }
    
     /**
     * Rewriting the toString() method
     * @return show location's information in another style
     */
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
        }else{
            return false;
        }
    }

    /** 
     * Generate a hashCode based in location's name
     * @return hashCode for the new location
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("location",Location.class);
        String xml = xstream.toXML(this);
        return xml;    
    }

    @Override
    public boolean saveToXML(File f) {
                
        String xml = this.toXML();

        try (FileWriter writer = new FileWriter(f)) {
            writer.write(xml);
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(Artist.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    @Override
    public boolean saveToXML(String filePath) {
        return saveToXML(new File(filePath));
    }
}