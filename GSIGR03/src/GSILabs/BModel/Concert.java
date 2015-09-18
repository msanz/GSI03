package GSILabs.BModel;

/**
 *
 * @author GR03
 */
public class Concert {
    
    Date date;
    String name;
    Artist performer;
    Location location;
    
    Concert(Date date, String name, Artist performer, Location location)
    {
        this.date = date;
        this.name = name;
        this.performer = performer;
        this.location = location;
    }
    
}
