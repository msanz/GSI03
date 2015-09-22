package GSILabs.BModel;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author GR03
 */
public class Concert implements ImpermanentEvent {
    DateConcert date;
    String name;
    Artist performer;
    Location location;
    Performer[] performers;
    
    public Concert(DateConcert date, String name, Artist performer, Location location){
        this.date = date;
        this.name = name;
        this.performer = performer;
        this.location = location;
    }
    
    public Concert(DateConcert date, String name, Performer[] performers, Location location){
        this.date = date;
        this.name = name;
        this.performers = performers;
        this.location = location;
    }

    @Override
    public boolean equals(Object o ) {
        if (o == null) return false;
        Concert c = (Concert)o;
        return ((this.getName().equals(c.getName())) 
                && (this.getLocation().equals(c.getLocation())));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.location);
        return hash;
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
        return performers;
    }
    
}
