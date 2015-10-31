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
import GSILabs.BModel.DateEvent;
import GSILabs.BModel.Location;
import GSILabs.BSystem.BusinessSystem;
import java.io.File;

/**
 * Load a file with festivals and import to system.
 * @author GR03
 * @version 1.0
 */
public class SSTest05 {
    private static BusinessSystem businessSystem;
    /**
     * Main class of SSTest04.
     */
    public static void main(String args[]){ 
        System.out.println("SSTest05");
        businessSystem = generateData();
        if (businessSystem.importFestivals(new File("data.ods"))){
            System.out.println("Festivales importados correctamente");
        }else{
            System.out.println("Error al importar festivales");
        }
    }
    
    private static BusinessSystem generateData(){
       businessSystem = new BusinessSystem(); 
       
       Artist artist1 = new Artist("Bob Dylan", "The boss", "www.bobdylan.com");
       businessSystem.addArtist(artist1);
       
       Location location1 = new Location("Madrid", 300, new Coordinates(123,287));
       businessSystem.addLocation(location1);
       
       Concert concert1 = new Concert("Bob Dylan Madrid", artist1, businessSystem.getLocation("Madrid"), new DateEvent("15/02/1999 11:00","15/02/1999 15:00"));
       businessSystem.addNewConcert(concert1);
       
       return businessSystem;
    }
}