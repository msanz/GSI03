/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

/**
 *
 * @author GR03
 */
public class IndividualArtist extends Artist {
    
    
    IndividualArtist(String name, String artWork)
    {
        super(name, artWork);
    }
    
    IndividualArtist(String name, String artWork, String web)
    {
        super(name, artWork);
        this.web = web;
    }
    
    
}
