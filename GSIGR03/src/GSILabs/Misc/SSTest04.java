/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.Misc;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Concert;
import GSILabs.BModel.Coordinates;
import GSILabs.BModel.DateConcert;
import GSILabs.BModel.Location;
import GSILabs.BSystem.BusinessSystem;

/**
 * Ejercicio 5
 * @author GR03
 */
public class SSTest04 {
    private static BusinessSystem businessSystem;
    
    private static Artist artist1;
    private static Artist artist2;
    
    private static Concert concert1;
    private static Concert concert2;
    
    private static Location location1;
    private static Location location2;
    
    public static void main(String args[]){  
       System.out.println("SSTest04");
       businessSystem = generateData();
    }
    
    private static BusinessSystem generateData() {
       businessSystem = new BusinessSystem();
        
       artist1 = new Artist("Bob Dylan", "The f*cking boss", "bobdylan.com");
       businessSystem.addArtist(artist1);
       
       location1 = new Location("Madrid", 300, new Coordinates(123,287));
       businessSystem.addLocation(location1);
       
       concert1 = new Concert("Bob Dylan Madrid", artist1, businessSystem.getLocation("Madrid"), new DateConcert("14/2/1999","12:10"));
       
       Concert c = businessSystem.retrieveConcert(concert1);
       //System.out.println(c.getName() + " " + c.getPerformers()[0].getName() + " " + c.getDates()[0] + " " + c.getLocation().getName());
       
       return  businessSystem;
    }
}
