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
public class ClientesGHP {

    private ArrayList<ClienteGHP> listaClientes;

    public ClientesGHP() {

        listaClientes = new ArrayList<ClienteGHP>();
    }

    public ArrayList<ClienteGHP> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<ClienteGHP> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void insertaCliente(ClienteGHP cliente) {
        listaClientes.add(cliente);

    }

}
