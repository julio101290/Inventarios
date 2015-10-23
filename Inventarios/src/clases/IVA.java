/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author ANDRES
 */
public class IVA {
    
    private Double precio;
    
    
    public IVA(Double precio) {
        this.precio = precio;
       
    }
   
    public  Double calcular_iva()
    { 
        double iva;               
        iva = precio*16/100;
        return iva;
        
    }
    }

