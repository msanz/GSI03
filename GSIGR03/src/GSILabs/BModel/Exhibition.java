/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.Date;

/**
 *
 * @author GR03
 */
public class Exhibition implements LastingEvent {
    String name;
    String org;
    DateEvent date;
    Artist performer;
    Location location;
    Performer[] performers;
    String[] links;
    
    public Exhibition(){}

    public Exhibition (String name, String org, DateEvent date, Artist performer, Location location, String[] links){
        this.name = name;
        this.org = org;
        this.date = date;
        this.performer = performer;
        this.location = location;
        this.links = links;
    }
    
    public Exhibition (String name, String org, DateEvent date, Performer[] performers, String[] links){
        this.name = name;
        this.org = org;
        this.date = date;
        this.performers = performers;
        this.links = links;
    }
    
    public Location getLocation(){
        return location;
    }
    
    @Override
    public Date getStartDate() {
        return date.getDayStart();
    }

    @Override
    public Date getEndingDate() {
        return date.getDayFinish();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date[] getDates() {
       Date[] dates = {date.getDayStart(), date.getDayFinish()};
       return dates;
    }

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

    @Override
    public Performer[] getPerformers() {
        if (performers == null)
            return null;
        if (performers != null)
            return performers;
        else{
            Performer[] list = {performer};
            return list;
        }
    }
    
}
