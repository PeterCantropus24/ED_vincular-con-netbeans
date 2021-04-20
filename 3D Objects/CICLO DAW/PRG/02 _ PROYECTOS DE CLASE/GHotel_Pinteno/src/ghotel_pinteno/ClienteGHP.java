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
public class ClienteGHP {

    private String nombreCliente;
    private String dni;

    private ArrayList<EstanciaGHP> listaEstancias;

    public ClienteGHP(String nombreCliente, String dni) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
//        verificaDni(dni);
        listaEstancias = new ArrayList<EstanciaGHP>();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<EstanciaGHP> getListaEstancias() {
        return listaEstancias;
    }

    public void setListaEstancias(ArrayList<EstanciaGHP> listaEstancias) {
        this.listaEstancias = listaEstancias;
    }

    public void insertaEstancias(EstanciaGHP estancia) {
        listaEstancias.add(estancia);
    }

    public void verificaDni(String dni) {

    }

}
