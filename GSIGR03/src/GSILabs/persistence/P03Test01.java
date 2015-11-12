/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.persistence;

import GSILabs.BModel.Artist;

/**
 * Create a test to exercice 01
 * @author GR03
 * @version 1.0
 */
public class P03Test01 {
    /**
     * Main class of SSTest01.
     */
    public static void main(String args[]){  
        Artist artistString = new Artist("Maria", "Cantante de opera", "maria.com");
        System.out.println("Object to XML");
        System.out.println(artistString.toXML());
        
        System.out.println("XML to object");
        Artist artistXML = (Artist) XMLPersistence.parseArtist(artistString.toXML());
        System.out.println(artistXML);
    }
}
