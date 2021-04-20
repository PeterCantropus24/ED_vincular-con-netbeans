/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_pinteno;

import java.util.ArrayList;

/**
 *
 * @author Satrux
 */
public class HotelesGHP {
    
    private ArrayList<HotelGHP> listaHoteles;

    public HotelesGHP() {
        listaHoteles = new ArrayList<HotelGHP>();
    }

    public void insertaHotel(HotelGHP h){
        listaHoteles.add(h);
        
    }
    public ArrayList<HotelGHP> getListaHoteles() {
        return listaHoteles;
    }

    public void setListaHoteles(ArrayList<HotelGHP> listaHoteles) {
        this.listaHoteles = listaHoteles;
    }

    @Override
    public String toString() {
        return "Hoteles{" + "listaHoteles=" + listaHoteles + '}';
    }
    
    
    
}
