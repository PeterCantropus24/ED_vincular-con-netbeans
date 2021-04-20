/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_pinteno;

import java.io.Serializable;

/**
 *
 * @author Satrux
 */
public class FacturaGHP implements Serializable{
    
    private static int nFac=0;

    public FacturaGHP() {
        nFac++;
    }

    public int getnFac() {
        return nFac;
    }
    
        
}
