/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

/** This provides the credit card object. A simply string
 * 
 * @author GR03
 */
class CreditCard {
    private String number;
    
    /**
     * initialice the creditcard number
     * @param number the credit card number to be added
     */
    CreditCard(String number){
        this.number = number;
    }
    
    /**
     * Returns the string value of this credit card
     * @return a string with the number
     */
    public String getCreditCard(){
        return this.number;
    }
}
