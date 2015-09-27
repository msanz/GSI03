/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author GR03
 */
public class Festival implements LastingEvent, Comparable<Concert> {
    private SortedSet<Concert> concerts;
    private HashSet<Location> locations;
    String name;
    DateEvent date;
    
    public Festival(){}
    public Festival (String name){
        this.name = name;        
        this.locations = new HashSet<Location>();
        this.concerts = new TreeSet<Concert>();
    }
    
    public boolean addConcert(Concert concert){
        date = concert.date;
        return (locations.add(concert.getLocation()) && concerts.add(concert));
    }
    
    public boolean deleteConcert(Concert concert){
        return (locations.remove(concert.getLocation()) && concerts.remove(concert));
    }
    
    @Override
    public Date getStartDate() {
        return concerts.first().date.dayStart;
    }

    @Override
    public Date getEndingDate() {
        return concerts.last().date.dayFinish;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date[] getDates() {
        ArrayList<Date> dates = new ArrayList();
        for (Concert c:concerts){
             dates.add(c.getDates()[0]);
        }
        return (Date[]) dates.toArray();
    }

    @Override
    public boolean involvesPerformer(Performer p) {
        for (Concert c:concerts){
            if(c.involvesPerformer(p)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Performer[] getPerformers() {
       ArrayList<Performer> performers = new ArrayList();
        for (Concert c:concerts)
            performers.addAll(Arrays.asList(c.getPerformers()));
        
        return (Performer[]) performers.toArray();
    }
    
    public SortedSet<Concert> getConcerts(){
        return concerts;
    }
    
    public HashSet<Location> getLocation(){
        return locations;
    }

    @Override
    public int compareTo(Concert t) {
        return 0;
    }
}
