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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A festival is an event composed of two or more concerts.
 * @author GR03
 * @version 1.0
 */
public class Festival implements LastingEvent, XMLRepresentable {
    
    private final SortedSet<Concert> concerts;
    private final String name;
    
    /** 
     * Create a new Festival.In locations there are all concerts locations.
     * @param name name of the festival. this name should be unique
     */
    public Festival (String name){
        this.name = name;        
        this.concerts = new TreeSet<>(new ConcertCompareDate());
    }
    
    /**
     * Adds a concert to the festival
     * @param concert the concert to add
     * @return true if and only if the concert is add to the festival
     */
    public boolean addConcert(Concert concert){
        return (concerts.add(concert));
    }
    
    /**
     * Delete a concert from the festival
     * @param concert the concert to remove
     * @return true if and only if the concert is remove from the festival
     */
    public boolean deleteConcert(Concert concert){
        return (concerts.remove(concert));
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
     * @param p performer to look for
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
        for (Concert c:concerts){
            performers.addAll(Arrays.asList(c.getPerformers()));
        }
        
        return (Performer[]) performers.toArray();
    }
    
    /**
     * Get concerts sorted by date
     * @return concerts in the festival sorted by date
     */
    public Concert[] getConcerts(){
        return concerts.toArray(new Concert[concerts.size()]);
    }
    
    /**
     * Get the locations of the festival.
     * @return locations for the festival's concerts.
     */
    public ArrayList<Location> getLocation(){
        ArrayList<Location> list = new ArrayList();
        for (Concert c:concerts){
            list.add(c.getLocation());
        }
        if (list.isEmpty()){
            return null;
        }else{
            return list;
        }
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("festival",Festival.class);
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

    private class ConcertCompareDate implements Comparator<Concert> {
        @Override
        public int compare(Concert c1, Concert c2) {
            if (concerts.isEmpty()){
                return 1;
            } else if (c1.getStartDate().before(c2.getStartDate())) {
                return -1;
            } else if (c1.getStartDate().after(c2.getStartDate())) {
                return 1;
            } else {
                return 0;
            }     
        }
    }
}
