/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSTest07DELETEME;

import GSILabs.BModel.Artist;
import GSILabs.BSystem.BusinessSystem;
import java.io.File;

/**
 *
 * @author linux1
 */
public class java { 
    
    private static BusinessSystem businessSystem;
    
    /**
     * Main class of SSTest06
     * @param args no arguments needed
     */
    public static void main(String args[]) {
        Artist artist = new Artist("Disturbed","metal");
        File file = new File("file.xml");
        artist.saveToXML(file);
        
    }
    
}

