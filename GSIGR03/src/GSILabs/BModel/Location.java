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
public class Location {
    
    String name;
    int capacity;
    Coordinates gpsCoordinates;
    String oficialWeb;
    
    Location(String name, int capacity, Coordinates gpsCoordinates, String oficialWeb)
    {
        this.name = name;
        this.capacity = capacity;
        this.gpsCoordinates = gpsCoordinates;
        this.oficialWeb = oficialWeb;
    }

    Location(String name, int capacity, Coordinates gpsCoordinates)
    {
        this.name = name;
        this.capacity = capacity;
        this.gpsCoordinates = gpsCoordinates;
    }
    
    
}
