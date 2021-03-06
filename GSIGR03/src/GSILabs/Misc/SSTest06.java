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
import GSILabs.BModel.Festival;
import GSILabs.BModel.Location;
import GSILabs.BSystem.BusinessSystem;
import java.io.File;
import java.util.Arrays;

/**
 * Load a file with tickets and import them to the system. 
 * @author GR03
 * @version 1.0
 */
public class SSTest06 { 
    
    private static BusinessSystem businessSystem;
    
    /**
     * Main class of SSTest06
     * @param args no arguments needed
     */
    public static void main(String args[]) {
        
        businessSystem = new BusinessSystem();
        businessSystem.addNewFestival(new Festival("Festival flamenco de las minas 2016"));
        businessSystem.addNewConcert(new Concert("ACDC en VAL 2015", new Artist("ACDC", "metal"), new Location("Valencia", 30000, new Coordinates(34, 543)), null));
        
        int importedTickets = businessSystem.importTickets(new File("P02Ej05.ods"));
        System.out.println("Se han importado " + importedTickets + " tickets: ");
        
        System.out.println("\n" + Arrays.toString(businessSystem.getTicketsForEvent("Festival flamenco de las minas 2016")));
    }
    
}
