/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

/**
 * The coordinates X and Y of the location festival, concert or exhibition
 * @author GR03
 */
public class Coordinates {
    
    int x;
    int y;
    
    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    /**
     * Return the Coordinates object
     * @return coordinates object
     */
    public Coordinates get()
    {
        return this;
    }
    
    /**
     * Set values X and Y of the location.
     * @param x coordinate value X of the location
     * @param y coordinate value Y of the location
     */
    public void set(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
