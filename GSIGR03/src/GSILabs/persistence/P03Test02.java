/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.persistence;

import GSILabs.BSystem.BusinessSystem;

/**
 * Create a test to exercice 01
 * @author GR03
 * @version 1.0
 */
public class P03Test02 {
    /**
     * Main class of P03Test02.
     */
    public static void main(String args[]){  
        BusinessSystem businessSystem = new BusinessSystem();
        System.out.println("Object to XML");
        System.out.println(businessSystem.toXML());
        
        System.out.println("Save to file");
        businessSystem.saveToXML("./businessSystem");
    }
}
