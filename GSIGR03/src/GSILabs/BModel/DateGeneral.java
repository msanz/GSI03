/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author GR03
 */
public class DateGeneral {
    Date day;
    Time time;
    
    DateGeneral (Date day, Time time){
        this.day = day;
        this.time = time;
    }
}