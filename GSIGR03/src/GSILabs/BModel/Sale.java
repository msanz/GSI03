/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.Date;
/**
 *
 * @author linux1
 */
public class Sale {
    Date date;
    int[] ticketID;
    
    public Sale ( Date date, int[] ticketID)
    {
        this.date = date;
        this.ticketID = ticketID;
    }
    
}
