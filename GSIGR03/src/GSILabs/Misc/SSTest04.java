/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.Misc;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Concert;
import GSILabs.BModel.Coordinates;
import GSILabs.BModel.DateConcert;
import GSILabs.BModel.DateEvent;
import GSILabs.BModel.Event;
import GSILabs.BModel.Exhibition;
import GSILabs.BModel.Festival;
import GSILabs.BModel.Location;
import GSILabs.BSystem.BusinessSystem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * Save on sheets the information of concerts, exhibitions and festivals.
 * @author GR03
 * @version 1.0
 */
public class SSTest04 {
    private static BusinessSystem businessSystem;
    
    private static Artist artist1;
 
    private static Concert concert1;
    
    private static DateConcert dateConcert1;
    
    private static Exhibition exhibition1;
    
    private static DateEvent dateEvent1;
    
    private static Festival festival1;
    
    private static Location location1;
    private static Location location2;
    
    /**
     * Main class of SSTest04.
     */
    public static void main(String args[]){  
        try {
            System.out.println("SSTest04");
            
            businessSystem = generateData();
            
            //Create the file.
            final File file = new File("data.ods");
            
            SpreadSheet spreadSheet = SpreadSheet.createEmpty(new DefaultTableModel());
            spreadSheet = concertSheet(spreadSheet);
            spreadSheet = exhibitionSheet(spreadSheet);
            spreadSheet = festivalSheet(spreadSheet);

            OOUtils.open(spreadSheet.saveAs(file));
        } catch (IOException ex) {
            Logger.getLogger(SSTest04.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static BusinessSystem generateData() {
       businessSystem = new BusinessSystem();
        
       artist1 = new Artist("Bob Dylan", "The boss", "bobdylan.com");
       businessSystem.addArtist(artist1);
       
       location1 = new Location("Madrid", 300, new Coordinates(123,287));
       businessSystem.addLocation(location1);
       
       dateConcert1 = new DateConcert("14/2/1999","12:10"); 
       
       concert1 = new Concert("Bob Dylan Madrid", artist1, businessSystem.getLocation("Madrid"), dateConcert1);
       businessSystem.addNewConcert(concert1);
       
       dateEvent1 = new DateEvent("15/12/2000", "20:00");
       dateEvent1.setDayFinish("20/12/2000");
       dateEvent1.setTimeFinish("17:00");
       
       location2 = new Location("Barcelona", 300, new Coordinates(456,787));
       businessSystem.addLocation(location2);
       
       String[] links = {"http://www.elpais.com"};
       
       exhibition1 = new Exhibition("Bod Dylan Expo", "Bob Dylan Foundation", dateEvent1, artist1, location2, links);
       businessSystem.addNewExhibition(exhibition1);
       
       festival1 = new Festival("Ragge 2015");
       businessSystem.addNewFestival(festival1);
       
       businessSystem.addConcertToFestival(festival1, concert1);
       
       return businessSystem;
    }
    
    private static SpreadSheet concertSheet(SpreadSheet spreadSheet){
        ArrayList<Event> events = businessSystem.retrieveEventsInvolvePerformer(artist1);
        ArrayList<Concert> concerts = new ArrayList();

        //Add events to concert ArrayList
        //This actions is because event interface has not getLocation()
        for (Event e:events){
            if (businessSystem.retrieveConcert(e) != null){
                concerts.add((Concert) e);
            }
        }

        int row = concerts.size();
        int col = 4;
        
        //Create the sheet
        Sheet sheet = spreadSheet.getSheet(0);
        sheet.setName("Concerts");
        
        //Merge the default table mode with new col and row
        sheet.merge(new DefaultTableModel(), col, row);
        
        for (int i = 0; i < row; i++) {
            sheet.getCellAt(0,i).setValue(concerts.get(i).getName());
            sheet.getCellAt(1,i).setValue(concerts.get(i).getPerformers()[0].getName());
            sheet.getCellAt(2,i).setValue(concerts.get(i).getStartDate());
            sheet.getCellAt(3,i).setValue(concerts.get(i).getLocation().getName());
        }
        
        return spreadSheet;
    }
    
    private static SpreadSheet exhibitionSheet(SpreadSheet spreadSheet){
        ArrayList<Event> events = businessSystem.retrieveEventsInvolvePerformer(artist1);
        ArrayList<Exhibition> exhibitions = new ArrayList();

        //Add events to concert ArrayList
        //This actions is because event interface has not getLocation()
        for (Event e:events){
            if (businessSystem.retrieveExhibition(e) != null){
                exhibitions.add((Exhibition) e);
            }
        }

        int row = exhibitions.size();
        int col = 7;
        
        //Create the sheet
        Sheet sheet = spreadSheet.addSheet("Exhibition");
        
        //Merge the default table mode with new col and row
        sheet.merge(new DefaultTableModel(), col, row);
        
        for (int i = 0; i < row; i++) {
            sheet.getCellAt(0,i).setValue(exhibitions.get(i).getName());
            sheet.getCellAt(1,i).setValue(exhibitions.get(i).getOrganization());
            sheet.getCellAt(2,i).setValue(exhibitions.get(i).getPerformers()[0].getName());
            sheet.getCellAt(3,i).setValue(exhibitions.get(i).getStartDate());
            sheet.getCellAt(4,i).setValue(exhibitions.get(i).getEndingDate());
            sheet.getCellAt(5,i).setValue(exhibitions.get(i).getLocation().getName());
            sheet.getCellAt(6,i).setValue(exhibitions.get(i).getLinks()[0]);
        }
        return spreadSheet;
       
    }
    
    public static SpreadSheet festivalSheet(SpreadSheet spreadSheet){
        ArrayList<Event> events = businessSystem.retrieveEventsInvolvePerformer(artist1);
        ArrayList<Festival> festivals = new ArrayList();
        Concert[] concerts;

        //Add events to festival ArrayList
        for (Event e:events){
            if (businessSystem.retrieveFestival(e) != null){
                festivals.add((Festival) e);
            }
        }

        int row = festivals.size();
        int col = 5;
        
        //Create the sheet
        Sheet sheet = spreadSheet.addSheet("Festivals");

        //Merge the default table mode with new col and row
        sheet.merge(new DefaultTableModel(), col, row);

        for (int i = 0; i < row; i++) {
            concerts = festivals.get(i).getConcerts();
            sheet.getCellAt(0,i).setValue(festivals.get(i).getName());
            for (Concert concert : concerts) {
                sheet.getCellAt(1,i).setValue(concert.getName());
                sheet.getCellAt(2,i).setValue(concert.getPerformers()[0].getName());
                sheet.getCellAt(3,i).setValue(concert.getStartDate());
                sheet.getCellAt(4,i).setValue(concert.getLocation().getName());
            }
        }
        return spreadSheet;
    }
}
