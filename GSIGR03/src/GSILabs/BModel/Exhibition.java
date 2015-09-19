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
    Performer[] performers;
    String[] links;

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
        //Hacer la resta entre el primer y ultimo dia
        return null;
    }

    @Override
    public boolean involvesPerformer(Performer p) {
        //Comprobar si un artista esta en alguno de los conciertos
        return false;
    }

    @Override
    public Performer[] getPerformers() {
        return performers;
    }
    
}
