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
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A concert is a impermanent event with one or more performers.
 * @author GR03
 * @version 1.0
 */
public class Concert implements ImpermanentEvent,XMLRepresentable {
    private DateEvent date;
    private String name;
    private Artist performer;
    private Location location;
    private Performer[] performers;
    
    /**
     * Create a new concert void.
     */
    public Concert(){}
    
    /**
     * Create a new concert
     * @param name The name of the concert
     * @param performer The performer who takes in the concert (only one performer)
     * @param location The location where of the concert
     * @param date The date of the concert (day and time)
     */
    public Concert(String name, Artist performer, Location location, DateEvent date){
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
    public Concert(String name, Performer[] performers, Location location, DateEvent date){
        this.date = date;
        this.name = name;
        this.performers = performers;
        this.location = location;
    }
    
    /**
     * Set date concert.
     * @param date date of the concert 
     */
    public void setDateEvent(DateEvent date){
        this.date = date;
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
        }else{
            return false;
        }
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
    
    @Override
    public Date getStartDate() {
        return date.getDayStart();
    }
    
    /**
     * Returns the day that the concert finish
     * @return date The day that the concert finish
     */
    public Date getFinishDate(){
        return date.getDayFinish();
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
     * Set performers to concert
     * @param performers array with one or more performers
     */
    public void setPerformers(Performer[] performers){
        if (performers.length == 1){
            this.performer = (Artist) performers[0];
        }else{
            this.performers = performers;
        }
    }
    
    /**
     * Set location to concert.
     * @param location the location to add at concert
     */
    public void setLocation(Location location){
        this.location = location;
    }
    
    /**
     * Set the name of the concert
     * @param name The name of the concert
     */
    public void setName(String name) {
        this.name = name;
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
        if (performers == null){
            return false;
        }else if (p.getName().toLowerCase().equals(performer.getName().toLowerCase())){
            return true;
        }else{
            for(Performer performer: performers){
                if(performer.getName().toLowerCase().equals(p.getName().toLowerCase())){
                    return true;
                }
            }
            return false;
        }    
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
     * @return True if and only is the same day. False otherwise.
     */
    public boolean collisionDay(Date day){
        return !day.before(this.getStartDate()) && !day.after(this.getFinishDate());
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("Concert",Concert.class);
        return xstream.toXML(this);
    }

    @Override
    public boolean saveToXML(File f) {
        String xml = this.toXML();
        try (FileWriter writer = new FileWriter(f)) {
            writer.write(xml);
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(Concert.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    @Override
    public boolean saveToXML(String filePath) {
        return saveToXML(new File(filePath));
    }
}