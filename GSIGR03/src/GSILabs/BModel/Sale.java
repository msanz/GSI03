/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.BModel;

import GSILabs.serializable.XMLRepresentable;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A sale represents that a client buys a ticket
 * @author GR03
 * @version 1.0
 */

public class Sale implements XMLRepresentable{
    Date date;
    int[] ticketID;
    
    /** 
     * Create a new Sale.
     * @param date the moment when the ticket is buyed by the client
     * @param ticketID ids that client buy. Each id represents a pass for the event
     */
    public Sale ( Date date, int[] ticketID){
        this.date = date;
        this.ticketID = ticketID;
    }
    
     /**
     * Rewriting the toString() method
     * @return Other style to show the information
     */
    @Override
    public String toString() {
        String salesTickets = "";
        
        for (int i = 0; i < ticketID.length; i++) {
            salesTickets = salesTickets + "\n" + i + ticketID[i];
        }
        
        return "Date: " + date + "\n" + "ticket ids: " + salesTickets;
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("sale",Sale.class);
        return xstream.toXML(this);
    }

    @Override
    public boolean saveToXML(File f) {
        String xml = this.toXML();
        try (FileWriter writer = new FileWriter(f)) {
            writer.write(xml);
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean saveToXML(String filePath) {
        return saveToXML(new File(filePath));
    }
}