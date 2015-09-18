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
public class Artist {
    
    String name;
    String artWork;
    String web;
    
    
    
    Artist(String name, String artWork)
    {
        this.name = name;
        this.artWork = artWork;
    }
    
    Artist(String name, String artWork, String web)
    {
        Artist(name, artWork);
    }
    
}
