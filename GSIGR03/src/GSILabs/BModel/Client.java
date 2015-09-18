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
public class Client {
    int DNI;
    String name;
    String surName1;
    String surName2;
    Date birthday;
    List<CreditCard> creditCard;
    
    public Client (int DNI, String name, String surName1, String surName2, Date birthday){
        this.DNI = DNI;
        this.name = name;
        this.surName1 = surName1;
        this.surName2 = surName2;
        this.birthday = birthday;
    }
    
}
