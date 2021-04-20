/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_pinteno;

import java.time.LocalDate;

/**
 *
 * @author Satrux
 */
public class EstanciaGHP {
    
    String codHotel;
    String nomHotel;
    String ciudad;
    double precioDia;
    LocalDate fEntrada;
    LocalDate fSalida;

    public EstanciaGHP(String codHotel, String nomHotel, String ciudad, double precioDia, LocalDate fEntrada, LocalDate fSalida) {
        this.codHotel = codHotel;
        this.nomHotel = nomHotel;
        this.ciudad = ciudad;
        this.precioDia = precioDia;
        this.fEntrada = fEntrada;
        this.fSalida = fSalida;
    }

    public String getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(String codHotel) {
        this.codHotel = codHotel;
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

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public LocalDate getfEntrada() {
        return fEntrada;
    }

    public void setfEntrada(LocalDate fEntrada) {
        this.fEntrada = fEntrada;
    }

    public LocalDate getfSalida() {
        return fSalida;
    }

    public void setfSalida(LocalDate fSalida) {
        this.fSalida = fSalida;
    }
    
     @Override
    public String toString() {
        return "Estancia{" + "codigoHotel=" + codHotel + ", nomHotel=" + 
                nomHotel + ", ciudad=" + ciudad + ", precioDia=" + precioDia + 
                ", fechaEntrada=" + fEntrada + ", fechaSalida=" + fSalida + '}';
    }
    
    
    
}
