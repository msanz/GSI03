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
class Coordinates {
    
    private int x;
    private int y;
    
    Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Coordinates get()
    {
        return this;
    }
    
    public void set(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
