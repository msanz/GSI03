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

/**
 *
 * @author GR03
 */
public class Festival implements LastingEvent {
    SortedSet<Concert> concerts;
    HashSet<Location> locations;
    String name;
    DateEvent date;
    
    public Festival(){}
    public Festival (String name, DateEvent date){
        this.name = name;
        this.date = date;
    }
    
    public boolean addConcert(Concert concert){
        return concerts.add(concert);
    }
    
    public boolean deleteConcert(Concert concert){
        return concerts.remove(concert);
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
        //Comprobar si un artista esta en alguno de los conciertos
        return false;
    }

    @Override
    public Performer[] getPerformers() {
       ArrayList<Performer> performers = new ArrayList();
        for (Concert c:concerts)
            performers.addAll(Arrays.asList(c.getPerformers()));
        
        return (Performer[]) performers.toArray();
    }
}
