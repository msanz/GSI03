/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BSystem;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Client;
import GSILabs.BModel.Collective;
import GSILabs.BModel.Concert;
import GSILabs.BModel.DateEvent;
import GSILabs.BModel.Event;
import GSILabs.BModel.Exhibition;
import GSILabs.BModel.Festival;
import GSILabs.BModel.Location;
import GSILabs.BModel.Performer;
import GSILabs.BModel.Ticket;
import GSILabs.persistence.XMLParsingException;
import GSILabs.serializable.XMLRepresentable;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * The business system is the main system.
 * @author GR03
 * @version 1.0
 */
public class BusinessSystem implements TicketOffice, XMLRepresentable{
    private final ClientSystem clientSystem;
    private final EventSystem eventSystem;
    private final LocationSystem locationSystem;
    private final TicketSystem ticketSystem;
    private final PerformerSystem performerSystem;
    private final AtomicInteger atomicInteger;
    private BusinessSystem businessSystem;
    
    public BusinessSystem (){
        clientSystem = new ClientSystem();
        eventSystem = new EventSystem();
        locationSystem = new LocationSystem();
        performerSystem = new PerformerSystem();
        ticketSystem = new TicketSystem();
        atomicInteger = new AtomicInteger();
        businessSystem = null;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
    
    @Override
    public boolean addNewConcert(Concert c) {
       if (existPerformerInSystem(c)){
           if ((c.getLocation()) != null){
               return eventSystem.addNewConcert(c);
           }
        }
        return false;
    }

    @Override
    public boolean replaceConcert(Concert c) {
        if (existPerformerInSystem(c)){
            if (c.getLocation() != null){
                if (eventSystem.replaceConcert(c)){
                    return this.addNewConcert(c);
                }
            }
        }
        return false;
    }
            
    @Override
    public boolean deleteConcert(Concert c) {
        return eventSystem.deleteConcert(c);
    }
    
    public Concert retrieveConcert(Event e){
        return eventSystem.retrieveConcert(e);
    }
    
    private boolean existPerformerInSystem(Concert concert){
        Performer[] performers = concert.getPerformers();
        if (!(concert instanceof Concert) || performers == null){
            return false;
        }else if (performers.length == 1){
           if(performerSystem.existsPerformer(performers[0].getName())){
               return true;
           }           
        }else{
            for (Performer p:performers){
                if(!performerSystem.existsPerformer(p.getName())){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean addNewExhibition(Exhibition e) {
       if (existPerformerInSystem(e)){
           return eventSystem.addNewExhibition(e);
       }
       return false;
    }

    @Override
    public boolean replaceExhibition(Exhibition e) {
        if (existPerformerInSystem(e)){
            if (eventSystem.replaceExhibition(e)){
                return this.addNewExhibition(e);
            }
        }
        return false;
    }
    
    private boolean existPerformerInSystem(Exhibition exhibition){
        Performer[] performers = exhibition.getPerformers();
        if (!(exhibition instanceof Exhibition) || performers == null){
            return false;
        }else{
            if (performers.length == 1){
                if(performerSystem.existsPerformer(performers[0].getName())){
                    return true;
                }           
            }else{
                for (Performer p:performers){
                    if(!performerSystem.existsPerformer(p.getName())){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean deleteExhibition(Exhibition e) {
        return eventSystem.deleteExhibition(e);
    }
    
    public Exhibition retrieveExhibition(Event e){
        return eventSystem.retrieveExhibition(e);
    }
    
    @Override
    public boolean addNewFestival(Festival f) {
        if (!existsEvent(f)){
            return eventSystem.addNewFestival(f);
        }else{
            return false;
        }
    }
     
    @Override
    public boolean addConcertToFestival(Festival f, Concert c) {
        return eventSystem.addConcertToFestival(f,c);
    }

    @Override
    public boolean replaceFestival(Festival f) {
        if (eventSystem.replaceFestival(f)){
            return this.addNewFestival(f);
        }
        return false;
    }

    @Override
    public boolean deleteFestival(Festival f) {
        return eventSystem.deleteFestival(f);
    }
    
    /**
     * Look for a festival and returns it if exists.
     * @param e event to look for
     * @return the festival if and only if exists in the system
     */
    public Festival retrieveFestival(Event e){
        return eventSystem.retrieveFestival(e);
    }
    
    private boolean existPerformerInSystem(Festival festival){
        Performer[] performers = festival.getPerformers();
        if (!(festival instanceof Festival) || performers == null){
            return false;
        }else{
            if (performers.length == 1){
                if(performerSystem.existsPerformer(performers[0].getName())){
                    return true;
                }           
            }else{
                for (Performer p:performers){
                    if(!performerSystem.existsPerformer(p.getName())){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }
    
    @Override
    public boolean existsEvent(Event e) {
        return eventSystem.existsEvent(e);
    }
    
    public ArrayList<Event> retrieveEventsInvolvePerformer (Performer performer){
        return eventSystem.retrieveEventsInvolvePerformer(performer);
    }
    
    @Override
    public Event[] retrieveEvents(String name) {
        return eventSystem.retrieveEvents(name);
    }
    
    public Event retrieveEvent(String name) {
        return eventSystem.retrieveEvent(name);
    }
    
    @Override
    public Event[] retrieveEvents(Location loc) {
        return eventSystem.retrieveEvents(loc);
    }

    @Override
    public Event[] retrieveEvents(Date d) {
        return eventSystem.retrieveEvents(d);
    }
    
    @Override
    public boolean addClient(Client c) {
        return clientSystem.addClient(c);
    }

    @Override
    public boolean modifyClient(Client c) {
        return clientSystem.modifyClient(c);
    }

    @Override
    public boolean addCardToClient(Client c, String cCard) {
        return clientSystem.addCardToClient(c,cCard);
    }

    @Override
    public boolean containsClient(Client c) {
        return clientSystem.containsClient(c);
    }

    @Override
    public boolean containsClient(int id) {
        return clientSystem.containsClient(id);
    }

    @Override
    public Client retrieveClient(int identifier) {
        return clientSystem.retrieveClient(identifier);
    }

    @Override
    public Ticket[] getListOfTickets(Client c) {
        return clientSystem.getListOfTickets(c);
    }

    @Override
    public float getTotalSpending(Client c) {
        return clientSystem.getTotalSpending(c);
    }
    
    @Override
    public boolean addNewTicket(Ticket t) {
            return ticketSystem.addNewTicket(t);
    }

    @Override
    public boolean hasIDCollision(Ticket t) {
        return ticketSystem.hasIDCollision(t);
    }

    @Override
    public boolean availableTicketID(Event e, int id) {
        return ticketSystem.availableTicketID(e, id);
    }

    @Override
    public boolean setIDUsed(Ticket t, Event e, int id) {
        return ticketSystem.setIDUsed(t, e, id);
    }

    @Override
    public boolean addSale(Ticket t, Client c, Float price, String cCard) {
        if (clientSystem.containsClient(c)) {
            return ticketSystem.addSale(t, c, price, cCard);
        }else {
            return false;
        }
    }
    
    public Ticket[] getTicketsForEvent(String eventName) {
        return ticketSystem.getTicketsForEvent(eventName);
    }
    
    // Locations management
    
    @Override
    public boolean addLocation(Location loc) {
        return locationSystem.addLocation(loc);
    }

    @Override
    public Location getLocation(String name) {
        return locationSystem.getLocation(name);
    }

    @Override
    public boolean deleteLocation(Location loc) {
        return locationSystem.deleteLocation(loc);
    }

    @Override
    public Location[] getLocations(int minCapacity) {
        return locationSystem.getLocations(minCapacity);
    }
    
    // Performer management
    
    @Override
    public boolean addArtist(Artist a) {
        return performerSystem.addArtist(a);
    }

    @Override
    public boolean addCollective(Collective c) {
        return performerSystem.addCollective(c);
    }
    
    @Override
    public boolean modifyArtist(Artist a) {
       return performerSystem.modifyArtist(a);
    }
    
    @Override
    public boolean modifyCollective(Collective c) {
        return performerSystem.modifyCollective(c);
    }
    
    @Override
    public boolean removePerformer(String performerName) {
        return performerSystem.removePerformer(performerName);
    }
    
    @Override
    public boolean existsPerformer(String performerName) {
       return performerSystem.existsPerformer(performerName);
    }

    @Override
    public boolean existsArtist(String artistName) {
        return performerSystem.existsArtist(artistName);
    }

    @Override
    public boolean existsCollective(String artistName) {
       return performerSystem.existsCollective(artistName);
    }

    @Override
    public Performer retrievePerformer(String performerName) {
       return performerSystem.retrievePerformer(performerName);
    }
    
    public Collective retrieveCollective(String collectiveName) {
       return performerSystem.retrieveCollective(collectiveName);
    }

    /**
     * Import tickets to the system
     * @param file file with data to import
     * @return the number of tickets that have been imported
     */
    public int importTickets (File file){
        int importedTickets = 0;
        try {
            String eventName;
            Ticket t;
            int j = 1;
            int passes;
            int passesConsumed;
            final Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);

            for (int i = 0; i < sheet.getRowCount(); i++) {
                eventName = sheet.getCellAt(0, i).getValue().toString();
                //add the ticket t to the system if and only if the event exists in the system
                if(this.retrieveEvent(eventName) == null) {
                    System.out.println("El evento " +  eventName +" no existe en el sistema. Tickets ignorados");
                }
                //read line and form the object Ticket
                else {
                    t = new Ticket(eventName, atomicInteger);
                    //recorremos las columnas hasta encontrar una vacia
                    passes = 0;
                    passesConsumed = 0;
                    while( (j < sheet.getColumnCount()) && (!sheet.getCellAt(j, i ).isEmpty()) ) {
                        sheet.getCellAt(j+1, i).getValue().toString();
                        if(sheet.getCellAt(j+1, i).getValue().toString().equals(" Used ")) {
                            passesConsumed++;
                        }
                        j = j + 2;
                        passes ++;
                    }
                    t.setNumberOfPersons(passes);
                    for (int k = 0; k < passesConsumed; k++) {
                        t.useTicket();
                    }
                    this.addNewTicket(t);
                    importedTickets++;
                }
            }
            return importedTickets;
        }
        catch(IOException exception) {
            System.out.println(exception.getMessage());
            return importedTickets;
        }
    }
    
    private String[] ODSFestival(File file){
        ArrayList<String> festivals = new ArrayList<>();
        try {
            final Sheet sheet = SpreadSheet.createFromFile(file).getSheet(2);
           
            int row = sheet.getRowCount();
            
            // Take the info
            for (int i = 0; i < row; i++) {
                festivals.add(sheet.getCellAt(0,i).getTextValue()); // Name festival
                festivals.add(sheet.getCellAt(1,i).getTextValue()); // Name concert
                festivals.add(sheet.getCellAt(2,i).getTextValue()); // Performer
                festivals.add(sheet.getCellAt(3,i).getTextValue()); // Date Start
                festivals.add(sheet.getCellAt(4,i).getTextValue()); // Date Finish
                festivals.add(sheet.getCellAt(5,i).getTextValue()); // Location
            }
  
            return festivals.toArray(new String[festivals.size()]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return festivals.toArray(new String[0]);
        }   
    }
    
    public int importFestivals(File f){    
        String[] festivals = this.ODSFestival(f);
        Festival festival;
        Location location;
        ArrayList<Performer> performersList = new ArrayList();
        Performer[] performers;
        String[] namesPerformers;
        Concert concert;
        Performer performer;
        int n = 0;
        
        if (festivals.length == 0){
            return n;
        }
        
        for (int i = 0; i < (festivals.length) ; i = i + 6) {
            //Check if the festival exist
            if (this.retrieveEvent(festivals[i]) != null){
                festival = (Festival) this.retrieveEvent(festivals[i]);
            }else{
                festival = new Festival(festivals[i]);
            }

            //Check if the concert exist
            if (this.retrieveEvent(festivals[i + 1]) != null){
                 concert = (Concert) this.retrieveEvent(festivals[i + 1]);
            }else{
                System.out.println("Error: Concierto no existe en el sistema");
                return 0;
            }

            namesPerformers = festivals[i + 2].split(",");

            // Delete the last split ',' with -1
            // Check if the performer exist
            for (int j = 0; j < namesPerformers.length - 1; j++) {
                if (this.retrievePerformer(namesPerformers[j]) != null){
                    performer = this.retrievePerformer(namesPerformers[j]);
                    performersList.add(performer);
                }
            }

            if (!performersList.isEmpty()){
                performers = new Performer[performersList.size()];
                performers = performersList.toArray(performers);
                concert.setPerformers(performers);
            }else{
                System.out.println("Error: Performers no existen en el sistema");
                return 0;
            }

            // Check if the location exist
            if (this.getLocation(festivals[i + 5]) != null){
                location = this.getLocation(festivals[i + 5]);
                concert.setLocation(location);
            }else{
                System.out.println("Error: Localizacion no existe en el sistema");
                return 0;
            }

            concert.setDateEvent(new DateEvent(festivals[i + 3],festivals[i + 4]));

            addNewFestival(festival);
            festival.addConcert(concert);
            System.out.println("Concierto (" + i + ") importado correctamente");
            n++;
        }
        return n;
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("businessSystem", BusinessSystem.class);
        return xstream.toXML(this);
    }

    @Override
    public boolean saveToXML(File f) {
        String xml = this.toXML();
        try (FileWriter writer = new FileWriter(f)) {
            writer.write(xml);
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean saveToXML(String filePath) {
        return saveToXML(new File(filePath));
    }
    
    public static BusinessSystem parseXMLFile(File f) throws XMLParsingException{
        XStream xstream = new XStream();
        xstream.alias("businessSystem", BusinessSystem.class);
        return (BusinessSystem) xstream.fromXML(f);
    }
    
    public boolean loadXMLFile(File f){
        try{
            XStream xstream = new XStream();
            xstream.alias("businessSystem", BusinessSystem.class);
            businessSystem = (BusinessSystem) xstream.fromXML(f);
            return true;
        }catch(Exception ex){
            Logger.getLogger(BusinessSystem.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public BusinessSystem getBusinessSystem(){
        return businessSystem;
    }
}
