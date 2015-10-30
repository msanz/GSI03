/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.Misc;

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
        businessSystem = new BusinessSystem();
        businessSystem.importFestivals(new File("data.ods"));            
    }
}