/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.List;

/**
 *
 * @author GR03
 */
public class Collective extends Artist {
     
    //mirar que coleccion conviene utilizar
    public List<Artist> members;
    
    public Collective(String name, String artWork) {
        super(name, artWork);
    }

    public Collective(String name, String artWork, String web) {
        super(name, artWork);
        this.web = web;
    }

}
