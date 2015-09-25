/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.ArrayList;
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
    Performer[] performers;
    String[] links;
    
    public Exhibition(){}

    public Exhibition (String name, String org, DateEvent date, Artist performer, String[] links){
        this.name = name;
        this.org = org;
        this.date = date;
        this.performer = performer;
        this.links = links;
    }
    
    public Exhibition (String name, String org, DateEvent date, Performer[] performers, String[] links){
        this.name = name;
        this.org = org;
        this.date = date;
        this.performers = performers;
        this.links = links;
    }
    
    @Override
    public Date getStartDate() {
        return date.dayStart;
    }

    @Override
    public Date getEndingDate() {
        return date.dayFinish;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date[] getDates() {
        Date[] dates = {date.dayStart};
       return dates;
    }

    @Override
    public boolean involvesPerformer(Performer p) {
        if (p.getName().toLowerCase().equals(this.performer.getName().toLowerCase()))
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
         ArrayList<Performer> list = new ArrayList();
        if (performers == null)
            return null;
        if (performers != null)
            return performers;
        else{
            list.add(performer);
            return (Performer[]) list.toArray();
        }
    }
    
}
