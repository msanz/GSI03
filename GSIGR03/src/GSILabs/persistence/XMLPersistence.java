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
 * Parse a file XML or string in object of the system.
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
        XStream xstream = new XStream();
        xstream.alias("artist", Artist.class);
        return (Artist) xstream.fromXML(f);
    }
    
    public static Client parseClient(String str) {
        XStream xstream = new XStream();
        xstream.alias("client", Client.class);
        return (Client)xstream.fromXML(str);
    }
    
    public static Client parseClient(File f) {
        XStream xstream = new XStream();
        xstream.alias("client", Client.class);
        return (Client)xstream.fromXML(f);
    }
    
    public static Collective parseCollective(String str) {
        XStream xstream = new XStream();
        xstream.alias("collective", Collective.class);
        return (Collective)xstream.fromXML(str);
    }
    
    public static Collective parseCollective(File f) {
        XStream xstream = new XStream();
        xstream.alias("collective", Collective.class);
        return (Collective)xstream.fromXML(f);
    }
    
    public static Concert parseConcert(String str) {
        XStream xstream = new XStream();
        xstream.alias("concert", Concert.class);
        return (Concert)xstream.fromXML(str);
    }
    
    public static Concert parseConcert(File f) {
        XStream xstream = new XStream();
        xstream.alias("concert", Concert.class);
        return (Concert)xstream.fromXML(f);
    }
    
    public static Coordinates parseCoordinates(String str) {
        XStream xstream = new XStream();
        xstream.alias("coordinates", Coordinates.class);
        return (Coordinates)xstream.fromXML(str);
    }
    
    public static Coordinates parseCoordinates(File f) {
        XStream xstream = new XStream();
        xstream.alias("coordinates", Coordinates.class);
        return (Coordinates)xstream.fromXML(f);
    }
    
    public static DateEvent parseDateEvent(String str) {
        XStream xstream = new XStream();
        xstream.alias("dateevent", DateEvent.class);
        return (DateEvent)xstream.fromXML(str);
    }
    
    public static DateEvent parseDateEvent(File f) {
        XStream xstream = new XStream();
        xstream.alias("dateevent", DateEvent.class);
        return (DateEvent)xstream.fromXML(f);
    }
    
    public static DateGeneral parseDateGeneral(String str) {
        XStream xstream = new XStream();
        xstream.alias("dategeneral", DateGeneral.class);
        return (DateGeneral)xstream.fromXML(str);
    }
    
    public static DateGeneral parseDateGeneral(File f) {
        XStream xstream = new XStream();
        xstream.alias("dategeneral", DateGeneral.class);
        return (DateGeneral)xstream.fromXML(f);
    }
    
    public static Event parseEvent(String str) {
        XStream xstream = new XStream();
        xstream.alias("event", Event.class);
        return (Event)xstream.fromXML(str);
    }
    
    public static Event parseEvent(File f) {
        XStream xstream = new XStream();
        xstream.alias("event", Event.class);
        return (Event)xstream.fromXML(f);
    }
    
    public static Exhibition parseExhibition(String str) {
        XStream xstream = new XStream();
        xstream.alias("exhibition", Exhibition.class);
        return (Exhibition)xstream.fromXML(str);
    }
    
    public static Exhibition parseExhibition(File f) {
        XStream xstream = new XStream();
        xstream.alias("exhibition", Exhibition.class);
        return (Exhibition)xstream.fromXML(f);
    }
    
    public static Festival parseFestival(String str) {
        XStream xstream = new XStream();
        xstream.alias("festival", Festival.class);
        return (Festival)xstream.fromXML(str);
    }
    
    public static Festival parseFestival(File f) {
        XStream xstream = new XStream();
        xstream.alias("festival", Festival.class);
        return (Festival)xstream.fromXML(f);
    }
    
    public static Location parseLocation(String str) {
        XStream xstream = new XStream();
        xstream.alias("location", Location.class);
        return (Location)xstream.fromXML(str);
    }
    
    public static Location parseLocation(File f) {
        XStream xstream = new XStream();
        xstream.alias("location", Location.class);
        return (Location)xstream.fromXML(f);
    }
    
    public static Performer parsePerformer(String str) {
        XStream xstream = new XStream();
        xstream.alias("performer", Performer.class);
        return (Performer)xstream.fromXML(str);
    }
    
    public static Performer parsePerformer(File f) {
        XStream xstream = new XStream();
        xstream.alias("performer", Performer.class);
        return (Performer)xstream.fromXML(f);
    }
    
    public static Sale parseSale(String str) {
        XStream xstream = new XStream();
        xstream.alias("sale", Sale.class);
        return (Sale)xstream.fromXML(str);
    }
    
    public static Sale parseSale(File f) {
        XStream xstream = new XStream();
        xstream.alias("sale", Sale.class);
        return (Sale)xstream.fromXML(f);
    }
    
    public static Ticket parseTicket(String str) {
        XStream xstream = new XStream();
        xstream.alias("ticket", Ticket.class);
        return (Ticket)xstream.fromXML(str);
    }
    
    public static Ticket parseTicket(File f) {
        XStream xstream = new XStream();
        xstream.alias("ticket", Ticket.class);
        return (Ticket)xstream.fromXML(f);
    }
    
}
