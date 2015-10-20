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
import GSILabs.BModel.Event;
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
 * Ejercicio 5
 * @author GR03
 */
public class SSTest04 {
    private static BusinessSystem businessSystem;
    
    private static Artist artist1;
    private static Artist artist2;
    
    private static Concert concert1;
    private static Concert concert2;
    
    private static Location location1;
    private static Location location2;
    
    public static void main(String args[]){  
       System.out.println("SSTest04");
       
       businessSystem = generateData();
       
       concertSheet();
       
    }
    
    private static BusinessSystem generateData() {
       businessSystem = new BusinessSystem();
        
       artist1 = new Artist("Bob Dylan", "The boss", "bobdylan.com");
       businessSystem.addArtist(artist1);
       
       location1 = new Location("Madrid", 300, new Coordinates(123,287));
       businessSystem.addLocation(location1);
       DateConcert dateConcert1 = new DateConcert("14/2/1999","12:10");
       concert1 = new Concert("Bob Dylan Madrid", artist1, businessSystem.getLocation("Madrid"), dateConcert1);
       businessSystem.addNewConcert(concert1);
       
       return businessSystem;
    }
    
    private static void concertSheet(){
       ArrayList<Event> events = businessSystem.retrieveEventsInvolvePerformer(artist1);
       ArrayList<Concert> concerts = new ArrayList();
       
       //Add events to concert ArrayList
       //This actions is because event interface has not getLocation()
       for (Event e:events){
           concerts.add(businessSystem.retrieveConcert(e));
       }
       
       for (Concert c:concerts){
            System.out.println(c.getName() + " " + c.getPerformers()[0].getName() + " " + c.getStartDate() + " " + c.getLocation().getName());
       }
       
       // Create the file.
       final File file = new File("concerts.ods");

       int row = concerts.size();
       DefaultTableModel model = new DefaultTableModel(row,4);
       
       try {
           SpreadSheet.createEmpty(model).saveAs(file);
           Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
           
           for (int i = 0; i < row; i++) {
               sheet.getCellAt(0,i).setValue(concerts.get(i).getName());
               sheet.getCellAt(1,i).setValue(concerts.get(i).getPerformers()[0].getName());
               sheet.getCellAt(2,i).setValue(concerts.get(i).getStartDate());
               sheet.getCellAt(3,i).setValue(concerts.get(i).getLocation().getName());
           }
           OOUtils.open(sheet.getSpreadSheet().saveAs(file));
       }catch (IOException ex) {
           Logger.getLogger(SSTest04.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
}
