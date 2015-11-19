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
import GSILabs.BModel.Collective;
import GSILabs.BModel.Concert;
import GSILabs.BModel.Coordinates;
import GSILabs.BModel.DateEvent;
import GSILabs.BModel.DateGeneral;
import GSILabs.BModel.Exhibition;
import GSILabs.BModel.Location;
import GSILabs.BModel.Sale;
import java.io.File;
import java.util.Date;

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
        testExhibition();
        testFestival();
        testLocation();
        testPerformer();
        testSale();
        testTicket();
        
    }
    
    private static void testArtist() {
        Artist artistString = new Artist("Maria", "Cantante de opera", "maria.com");
        String filePath = "xml/artis.xml";
        
        System.out.println("ARTIST TEST"
                +"\nArtist to XML"
                + "\n" + artistString.toXML()
                + "\n\nArtist XML string to object"
                + "\n" + (Artist) XMLPersistence.parseArtist(artistString.toXML()));
        
        System.out.println("\nSaving Artist to XML file"
                + "\n" + artistString.saveToXML(filePath)
                + "\n\nArtist XML file to object"
                + "\n" + XMLPersistence.parseArtist(new File("xml/artist.xml")));
    }

    private static void testClient() {
        Client clientString = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956 15:00"));
        String filePath = "xml/client.xml";
        System.out.println("CLIENT TEST"
                +"\nClient to XML"
                + "\n" + clientString.toXML()
                + "\n\nClient XML string to object"
                + "\n" + (Client) XMLPersistence.parseClient(clientString.toXML()));
        
        System.out.println("\nSaving Client to XML file"
                + "\n" + clientString.saveToXML(filePath)
                + "\n\nClient XML file to object"
                + "\n" + XMLPersistence.parseClient(new File(filePath)));
    }

    private static void testCollective() {
        Collective collectiveString = new Collective("Maria", "cantante");
        String filePath = "xml/collective.xml";
        System.out.println("Collective TEST"
                +"\nCollective to XML"
                + "\n" + collectiveString.toXML()
                + "\n\nCollective XML string to object"
                + "\n" + (Collective) XMLPersistence.parseCollective(collectiveString.toXML()));
        
        System.out.println("\nSaving Collective to XML file"
                + "\n" + collectiveString.saveToXML(filePath)
                + "\n\nCollective XML file to object"
                + "\n" + XMLPersistence.parseCollective(new File(filePath)));
    }

    private static void testConcert() {
        Concert concertString = new Concert("ACDC-Barcelona", new Artist("AC-DC", "metalGroup"), new Location("Madrid", 300, new Coordinates(123,287)), new DateEvent("12/7/2015 21:30", "12/7/2015 22:30"));
        String filePath = "xml/concert.xml";
        System.out.println("Concert TEST"
                +"\nConcert to XML"
                + "\n" + concertString.toXML()
                + "\n\nConcert XML string to object"
                + "\n" + (Concert) XMLPersistence.parseConcert(concertString.toXML()));
        
        System.out.println("\nSaving Concert to XML file"
                + "\n" + concertString.saveToXML(filePath)
                + "\n\nConcert XML file to object"
                + "\n" + XMLPersistence.parseConcert(new File(filePath)));
    }

    private static void testCoordinates() {
        Coordinates coordinatesString = new Coordinates(123,287);
        String filePath = "xml/coordinates.xml";
        System.out.println("COORDINATES TEST"
                +"\nCoordinates to XML"
                + "\n" + coordinatesString.toXML()
                + "\n\nCoordinates XML string to object"
                + "\n" + (Coordinates) XMLPersistence.parseCoordinates(coordinatesString.toXML()));
        
        System.out.println("\nSaving Coordinates to XML file"
                + "\n" + coordinatesString.saveToXML(filePath)
                + "\n\nCoordinates XML file to object"
                + "\n" + XMLPersistence.parseCoordinates(new File(filePath)));
    }

    private static void testDateEvent() {
        DateEvent dateEventString = new DateEvent("14/2/1956", "21/2/1956");
        String filePath = "xml/dateEvent.xml";
        System.out.println("EVENT DATE TEST"
                +"\nDateEvent to XML"
                + "\n" + dateEventString.toXML()
                + "\n\nDateEvent XML string to object"
                + "\n" + (DateEvent) XMLPersistence.parseDateEvent(dateEventString.toXML()));
        
        System.out.println("\nSaving DateEvent to XML file"
                + "\n" + dateEventString.saveToXML(filePath)
                + "\n\nDateEvent XML file to object"
                + "\n" + XMLPersistence.parseDateEvent(new File(filePath)));
    }

    private static void testDateGeneral() {
        DateGeneral dateGeneralString = new DateGeneral("14/2/1956 15:00");
        String filePath = "xml/dateGeneral.xml";
        System.out.println("GENERAL DATE TEST"
                +"\nGeneralDate to XML"
                + "\n" + dateGeneralString.toXML()
                + "\n\nGeneralDate XML string to object"
                + "\n" + (DateGeneral) XMLPersistence.parseDateGeneral(dateGeneralString.toXML()));
        
        System.out.println("\nSaving GeneralDate to XML file"
                + "\n" + dateGeneralString.saveToXML(filePath)
                + "\n\nGeneralDate XML file to object"
                + "\n" + XMLPersistence.parseDateGeneral(new File(filePath)));
    }
    
    private static void testExhibition() {
        DateEvent date = new DateEvent("14/2/1956", "21/2/1956");
        Artist artist = new Artist("Maria", "sculptor");
        String[] links = {"link"};
        Exhibition exhibitionString = new Exhibition("exhibition", "asdf", date, artist, new Location("Madrid", 300, new Coordinates(123,287)), links);
        
        String filePath = "xml/client.xml";
        System.out.println("CLIENT TEST"
                +"\nClient to XML"
                + "\n" + exhibitionString.toXML()
                + "\n\nClient XML string to object"
                + "\n" + (Client) XMLPersistence.parseClient(exhibitionString.toXML()));
        
        System.out.println("\nSaving Client to XML file"
                + "\n" + exhibitionString.saveToXML(filePath)
                + "\n\nClient XML file to object"
                + "\n" + XMLPersistence.parseClient(new File(filePath)));
    }

    private static void testFestival() {
        Client clientString = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956 15:00"));
        String filePath = "xml/client.xml";
        System.out.println("CLIENT TEST"
                +"\nClient to XML"
                + "\n" + clientString.toXML()
                + "\n\nClient XML string to object"
                + "\n" + (Client) XMLPersistence.parseClient(clientString.toXML()));
        
        System.out.println("\nSaving Client to XML file"
                + "\n" + clientString.saveToXML(filePath)
                + "\n\nClient XML file to object"
                + "\n" + XMLPersistence.parseClient(new File(filePath)));
    }

    private static void testLocation() {
        Client clientString = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956 15:00"));
        String filePath = "xml/client.xml";
        System.out.println("CLIENT TEST"
                +"\nClient to XML"
                + "\n" + clientString.toXML()
                + "\n\nClient XML string to object"
                + "\n" + (Client) XMLPersistence.parseClient(clientString.toXML()));
        
        System.out.println("\nSaving Client to XML file"
                + "\n" + clientString.saveToXML(filePath)
                + "\n\nClient XML file to object"
                + "\n" + XMLPersistence.parseClient(new File(filePath)));
    }

    private static void testPerformer() {
        Client clientString = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956 15:00"));
        String filePath = "xml/client.xml";
        System.out.println("CLIENT TEST"
                +"\nClient to XML"
                + "\n" + clientString.toXML()
                + "\n\nClient XML string to object"
                + "\n" + (Client) XMLPersistence.parseClient(clientString.toXML()));
        
        System.out.println("\nSaving Client to XML file"
                + "\n" + clientString.saveToXML(filePath)
                + "\n\nClient XML file to object"
                + "\n" + XMLPersistence.parseClient(new File(filePath)));
    }

    private static void testTicket() {
        Client clientString = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956 15:00"));
        String filePath = "xml/client.xml";
        System.out.println("CLIENT TEST"
                +"\nClient to XML"
                + "\n" + clientString.toXML()
                + "\n\nClient XML string to object"
                + "\n" + (Client) XMLPersistence.parseClient(clientString.toXML()));
        
        System.out.println("\nSaving Client to XML file"
                + "\n" + clientString.saveToXML(filePath)
                + "\n\nClient XML file to object"
                + "\n" + XMLPersistence.parseClient(new File(filePath)));
    }

    private static void testSale() {
        int[] ticketId = {1};
        Sale saleString = new Sale(new Date("14/2/1956 15:00"), ticketId);
        String filePath = "xml/sale.xml";
        System.out.println("SALE TEST"
                +"\nSale to XML"
                + "\n" + saleString.toXML()
                + "\n\nSale XML string to object"
                + "\n" + (Sale) XMLPersistence.parseSale(saleString.toXML()));
        
        System.out.println("\nSaving Sale to XML file"
                + "\n" + saleString.saveToXML(filePath)
                + "\n\nSale XML file to object"
                + "\n" + XMLPersistence.parseClient(new File(filePath)));
    }
    
    
    
}
