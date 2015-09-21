package GSILabs.BModel;
import java.util.Date;
import sun.util.logging.resources.logging;

/**
 *
 * @author GR03
 */
public class Concert implements ImpermanentEvent{
    DateConcert date;
    String name;
    Artist performer;
    Location location;
    Performer[] performers;
    
    public Concert(DateConcert date, String name, Artist performer, Location location)
    {
        this.date = date;
        this.name = name;
        this.performer = performer;
        this.location = location;
    }
    
    public Concert(DateConcert date, String name, Performer[] performers, Location location)
    {
        this.date = date;
        this.name = name;
        this.performers = performers;
        this.location = location;
    }
    
    @Override
    public Date getStartDate() {
        return date.dayStart;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public java.util.Date[] getDates() {
        //¿Solo implementar en Festival?
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
