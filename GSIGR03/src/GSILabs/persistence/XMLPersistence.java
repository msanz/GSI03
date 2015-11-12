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
import GSILabs.BModel.Event;
import GSILabs.BModel.Exhibition;
import GSILabs.BModel.Festival;
import GSILabs.BModel.Location;
import GSILabs.BModel.Performer;
import GSILabs.BModel.Sale;
import GSILabs.BModel.Ticket;
import com.thoughtworks.xstream.XStream;
import java.io.File;

/**
 * Read a file XML
 * @author GR03
 * @version 1.0
 */
public class XMLPersistence {
   
    public static Artist parseArtist(String str) {
        XStream xstream = new XStream();
        xstream.alias("artist", Artist.class);
        return (Artist)xstream.fromXML(str);
    }
    
    public static Artist parseArtist(File f) {
        return null;
    }
    
    public static Client parseClient(String str) {
        XStream xstream = new XStream();
        xstream.alias("client", Client.class);
        return (Client)xstream.fromXML(str);
    }
    
    public static Client parseClient(File f) {
        return null;
    }
    
    public static Collective parseCollective(String str) {
        XStream xstream = new XStream();
        xstream.alias("collective", Collective.class);
        return (Collective)xstream.fromXML(str);
    }
    
    public static Collective parseCollective(File f) {
        return null;
    }
    
    public static Concert parseConcert(String str) {
        XStream xstream = new XStream();
        xstream.alias("concert", Concert.class);
        return (Concert)xstream.fromXML(str);
    }
    
    public static Concert parseConcert(File f) {
        return null;
    }
    
    public static Coordinates parseCoordinates(String str) {
        XStream xstream = new XStream();
        xstream.alias("coordinates", Coordinates.class);
        return (Coordinates)xstream.fromXML(str);
    }
    
    public static Coordinates parseCoordinates(File f) {
        return null;
    }
    
    public static DateEvent parseDateEvent(String str) {
        XStream xstream = new XStream();
        xstream.alias("dateevent", DateEvent.class);
        return (DateEvent)xstream.fromXML(str);
    }
    
    public static DateEvent parseDateEvent(File f) {
        return null;
    }
    
    public static DateGeneral parseDateGeneral(String str) {
        XStream xstream = new XStream();
        xstream.alias("dategeneral", DateGeneral.class);
        return (DateGeneral)xstream.fromXML(str);
    }
    
    public static DateGeneral parseDateGeneral(File f) {
        return null;
    }
    
    public static Event parseEvent(String str) {
        XStream xstream = new XStream();
        xstream.alias("event", Event.class);
        return (Event)xstream.fromXML(str);
    }
    
    public static Event parseEvent(File f) {
        return null;
    }
    
    public static Exhibition parseExhibition(String str) {
        XStream xstream = new XStream();
        xstream.alias("exhibition", Exhibition.class);
        return (Exhibition)xstream.fromXML(str);
    }
    
    public static Exhibition parseExhibition(File f) {
        return null;
    }
    
    public static Festival parseFestival(String str) {
        XStream xstream = new XStream();
        xstream.alias("festival", Festival.class);
        return (Festival)xstream.fromXML(str);
    }
    
    public static Festival parseFestival(File f) {
        return null;
    }
    
    public static Location parseLocation(String str) {
        XStream xstream = new XStream();
        xstream.alias("location", Location.class);
        return (Location)xstream.fromXML(str);
    }
    
    public static Location parseLocation(File f) {
        return null;
    }
    
    public static Performer parsePerformer(String str) {
        XStream xstream = new XStream();
        xstream.alias("performer", Performer.class);
        return (Performer)xstream.fromXML(str);
    }
    
    public static Performer parsePerformer(File f) {
        return null;
    }
    
    public static Sale parseSale(String str) {
        XStream xstream = new XStream();
        xstream.alias("sale", Sale.class);
        return (Sale)xstream.fromXML(str);
    }
    
    public static Sale parseSale(File f) {
        return null;
    }
    
    public static Ticket parseTicket(String str) {
        XStream xstream = new XStream();
        xstream.alias("ticket", Ticket.class);
        return (Ticket)xstream.fromXML(str);
    }
    
    public static Ticket parseTicket(File f) {
        return null;
    }
    
}
