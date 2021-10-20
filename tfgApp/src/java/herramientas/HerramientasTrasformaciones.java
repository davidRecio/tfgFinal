/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class HerramientasTrasformaciones {
    
    
    public ArrayList<String>  ArrayToArrayList(String[] array){
    ArrayList <String> result = new ArrayList();
    
    for(int i=1; i<array.length;i++){
    result.add(array[i]);
      
         
    }
    
    return result;
    
    
    }
    
}
