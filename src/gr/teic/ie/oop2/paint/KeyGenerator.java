/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teic.ie.oop2.paint;

import java.util.ArrayList;

/**
 *
 * @author labuser
 */
public class KeyGenerator {
    private static ArrayList<Observer> obs = new ArrayList<Observer>();
    private static int Key = 0;
    
    public static int ProduceKey(){
    
        return Key++;
    }
    

}
