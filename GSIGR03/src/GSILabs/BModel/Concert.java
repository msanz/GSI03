package GSILabs.BModel;
import java.util.ArrayList;
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
    
    public Concert(){}
    
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
    
    /*public boolean wellForm(){
        return !(performer == null || performers.length == 0);
    }*/
    
    /**
     * Compare two objects by name and location
     * @param o is a object
     * @return true if and only if two objects have the same name and location if not false
     */
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
    
}
