/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.persistence;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Performer;
import GSILabs.BSystem.BusinessSystem;
import java.io.File;

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
        Artist artistString = new Artist("Maria", "Cantante de opera", "maria.com");
        businessSystem.addArtist(artistString);
        System.out.println("Object to XML" + businessSystem.toXML());
        
        System.out.println("Save to file");
        businessSystem.saveToXML("businessSystem.xml");
        BusinessSystem businessSystemXML = null;
        try{
            businessSystemXML = BusinessSystem.parseXMLFile(new File("businessSystem"));
        }catch(XMLParsingException e){
            e.errorParsingException("Error al cargar XML");
        }
        
        Performer performer = businessSystemXML.retrievePerformer("Maria");
        System.out.println(performer);
        
    }
}
