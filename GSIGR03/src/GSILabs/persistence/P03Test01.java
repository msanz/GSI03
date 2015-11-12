/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.persistence;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Client;
import GSILabs.BModel.DateGeneral;
import java.io.File;

/**
 * Create a class test in order to testing XMLRepresentable and XMLPersistence
 * performance in model's classes.
 * @author GR03
 * @version 1.0
 */
public class P03Test01 {
    /**
     * Main class of P03Test01.
     * Checks xml parsing for each class in the model
     * @param args no args needed
     */
    public static void main(String args[]) {  
        
        testArtist();
        testClient();
        testCollective();
        testConcert();
        testCoordinates();
        testDateEvent();
        testDateGeneral();
        testEvent();
        testExhibition();
        testFestival();
        testLocation();
        testPerformer();
        testSale();
        testTicket();
        
    }
    
    private static void testArtist() {
        Artist artistString = new Artist("Maria", "Cantante de opera", "maria.com");
        
        System.out.println("ARTIST TEST"
                +"\nArtist to XML"
                + "\n" + artistString.toXML()
                + "\n\nArtist XML string to object"
                + "\n" + (Artist) XMLPersistence.parseArtist(artistString.toXML()));
        
        System.out.println("\nSaving Artist to XML file"
                + "\n" + artistString.saveToXML("xml/artist.xml")
                + "\n\nArtist XML file to object"
                + "\n" + XMLPersistence.parseArtist(new File("xml/artist.xml")));
    }

    private static void testClient() {
        Client clientString = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956 15:00"));
        String filePath = "client.xml";
        System.out.println("CLIENT TEST"
                +"\nClient to XML"
                + "\n" + clientString.toXML()
                + "\n\nClient XML string to object"
                + "\n" + (Client) XMLPersistence.parseClient(clientString.toXML()));
        
        System.out.println("\nSaving Client to XML file"
                + "\n" + clientString.saveToXML("xml/client.xml")
                + "\n\nClient XML file to object"
                + "\n" + XMLPersistence.parseClient(new File("xml/client.xml")));
        
        
    }

    private static void testCollective() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testConcert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testCoordinates() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testDateEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testDateGeneral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testExhibition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testFestival() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testPerformer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testTicket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testSale() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
