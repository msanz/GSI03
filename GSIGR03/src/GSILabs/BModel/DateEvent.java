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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * This class managed the date of the events. This class controls the date general (day and time) that a event start and finish)
 * @author GR03
 * @version 1.0
 */
public class DateEvent extends DateGeneral implements XMLRepresentable{
    private final Date dayStart;
    private final Date dayFinish;
    private final SimpleDateFormat simpleDateFormat;
    /** 
     * Create a date event with day and time
     * @param dayStart the day that the concert start
     * @param dayFinish the day that the concert finish
     */
    public DateEvent(String dayStart, String dayFinish) {
        super(dayStart);
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.dayStart = super.dayFormat(dayStart);
        this.dayFinish = super.dayFormat(dayFinish);
    }

    /**
     * Returns the day when the event start.
     * @return the day when the event start
     */
    public Date getDayStart() {
        return dayStart;
    }

    /**
     * Returns the day when the event finish.
     * @return the day when the event finish
     */
    public Date getDayFinish() {
        return dayFinish;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof DateEvent) {
            DateEvent date = (DateEvent) o;
            //comprobar que no es after ni before
            return (super.equals(date));
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return simpleDateFormat.format(dayStart);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.dayStart);
        return hash;
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("dateEvent",DateEvent.class);
        String xml = xstream.toXML(this);
        return xml;
    }

    @Override
    public boolean saveToXML(File f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveToXML(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}