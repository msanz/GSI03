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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class managed the date in general style
 * @author GR03
 */
public class DateGeneral implements XMLRepresentable{
    private final Date day;
    private final SimpleDateFormat simpleDateFormat;
    
    /** 
     * Create a date general with day and time
     * @param dayString string day style "dd/mm/yyyy"
     */
    public DateGeneral (String dayString){
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.day = this.dayFormat(dayString);
    }
    
    /**
     * Returns the day of the date
     * @return the day of the date 
     */
    public Date getDay() {
        return day;
    }
    
    /**
     * Convert string (dd/MM/yyyy hh:mm) to date format
     * @param string day style "dd/MM/yyyy HH:mm"
     * @return return the date object
     */
    Date dayFormat(String string){
        try{
            return simpleDateFormat.parse(string);
        }catch (ParseException ex){
            return null;
        }        
    }
   
    /**
     * Checks if the client is adult (+18)
     * @return true if and only if the birthday is more than 18 years
     */
    public boolean checkBirthday(){
       return (((new Date()).getYear() + 1900) - (day.getYear() + 1900) >= 18 );              
    }
    
    @Override
    public String toString(){
        return simpleDateFormat.format(day);
    }
    
    @Override
    public boolean equals(Object o) {       
        if(o instanceof DateGeneral) {
            DateGeneral date = (DateGeneral) o;
            //comprobar que no es after ni before
            return (!day.after(date.day) && !day.before(date.day));
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.day);
        return hash;
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("dateGeneral",DateGeneral.class);
        String xml = xstream.toXML(this);
        return xml;
    }

    @Override
    public boolean saveToXML(File f) {
                
        String xml = this.toXML();

        try (FileWriter writer = new FileWriter(f)) {
            writer.write(xml);
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(Artist.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    @Override
    public boolean saveToXML(String filePath) {
        return saveToXML(new File(filePath));
    }
}