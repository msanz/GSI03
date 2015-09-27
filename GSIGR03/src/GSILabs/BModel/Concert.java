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
    
    public Concert(String name, Artist performer, Location location, DateConcert date){
        this.date = date;
        this.name = name;
        this.performer = performer;
        this.location = location;
    }
    
    public Concert(String name, Performer[] performers, Location location, DateConcert date){
        this.date = date;
        this.name = name;
        this.performers = performers;
        this.location = location;
    }
    
    /**
     * Compare two objects by name and location
     * @param o is a object
     * @return true if and only if two objects have the same name and location if not false
     */
    @Override
    public boolean equals(Object o ) {
        if (o instanceof Concert){ 
            Concert c = (Concert)o;
            return (this.getName().toLowerCase().equals(c.getName().toLowerCase()) 
                    && this.getLocation().equals(c.getLocation()));
        }
        return false;
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
        if (p.getName().toLowerCase().equals(performer.getName().toLowerCase())){
            return true;
        }else{
            for(Performer performer: performers){
                if(performer.getName().toLowerCase().equals(p.getName().toLowerCase())){
                    return true;
                }
            }
        }    
        return false;
    }

    @Override
    public Performer[] getPerformers() {
        if (performers != null){
            return performers;
        }else{
            Performer[] list = {performer};
            return list;
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
    
    public boolean collisionDay(Date day){
        System.out.println("Date.Daystart: " + date.dayStart + " Date day: " + day);
        if (!day.before(date.dayStart)){
            if (!day.after(date.dayFinish)){
                
                return true;
            }
        }
        
        return false;
    }
}
