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
class CreditCard {
    private String number;
    
    CreditCard(String number){
        this.number = number;
    }
    
    public String getCreditCard(){
        return this.number;
    }
}
