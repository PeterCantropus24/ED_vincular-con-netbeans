/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_pinteno;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Satrux
 */
public class HotelGHP implements Serializable {

    private String nomHotel;
    private String ciudad;
    private String codHotel;
    private double precioDia;
    private ArrayList<ExtrasGHP> extras;

    public HotelGHP(String ciudad, String codHotel, String nomHotel, double precioDia) {
        this.ciudad = ciudad;
        this.nomHotel = nomHotel;
        this.codHotel = codHotel;
        this.precioDia = precioDia;
        extras = new ArrayList<ExtrasGHP>();
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(String codHotel) {
        this.codHotel = codHotel;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public ArrayList<ExtrasGHP> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<ExtrasGHP> extras) {
        this.extras = extras;
    }

    public void añadeExtra(ExtrasGHP extra) {
        extras.add(extra);
    }

    @Override
    public String toString() {
        return "\nHotel{" + "nombre=" + ciudad + ", ciudad=" + ciudad + "\n" + ", precio dia=" + precioDia;
    }

}
