/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.Date;
import java.util.List;
import java.util.SortedSet;

/**
 *
 * @author GR03
 */
public class Festival implements LastingEvent {
    SortedSet<Concert> concerts;
    List<Location> locations;
    String name;
    DateEvent date;
    
    public Festival (String name, DateEvent date){
    
    }

    @Override
    public Date getStartDate() {
        //Devolver la apertura de puertas del primer concierto
        return null;
    }

    @Override
    public Date getEndingDate() {
        //Devolver el cierre de puertas del ultimo concierto
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date[] getDates() {
        //Hacer la resta entre el primer y ultimo concierto
        return null;
    }

    @Override
    public boolean involvesPerformer(Performer p) {
        //Comprobar si un artista esta en alguno de los conciertos
        return false;
    }

    @Override
    public Performer[] getPerformers() {
        //Devolver la lista de todos los artistas de los conciertos
        return null;
    }
}
