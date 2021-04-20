/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_pinteno;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Satrux
 */
public class PanelGHP extends JPanel {

    JComboBox ciudadCB, hotelCB;
    JLabel ciudadLB, hotelLB, dniLB, nombreLB, fEntradaLB, fSalidaLB, pvpLB;
    JTextField dniTF, nombreTF, fEntradaTF, fSalidaTF, pvpTF;
    JButton grabarBT, facturaBT;

    JCheckBox[] listadoExtras = null;

    JPanel panelDeExtras;
    JLabel[] labelParaListadoExtras = null;

    private HotelesGHP hoteles = new HotelesGHP();
    private ExtrasGHP extrasAñadirHotel;
    private ClientesGHP clientes = new ClientesGHP();

    private ArrayList<ExtrasGHP> extrasSeleccionados;

    public PanelGHP() {

        this.setLayout(null);
        this.setBounds(10, 10, 760, 525);
        cargaHoteles();
        cargarExtras();
        cargarClientes();

        ciudadLB = new JLabel("Ciudad");
        ciudadLB.setBounds(20, 35, 50, 30);
        this.add(ciudadLB);

        hotelLB = new JLabel("Hotel");
        hotelLB.setBounds(200, 35, 50, 30);
        this.add(hotelLB);

        ciudadCB.setBounds(20, 60, 150, 40);
        this.add(ciudadCB);

        hotelCB.setBounds(200, 60, 200, 40);
        this.add(hotelCB);

        dniLB = new JLabel("DNI:");
        dniLB.setBounds(20, 150, 50, 30);
        this.add(dniLB);

        nombreLB = new JLabel("Nombre: ");
        nombreLB.setBounds(20, 200, 90, 30);
        this.add(nombreLB);

        fEntradaLB = new JLabel("F. Entrada:");
        fEntradaLB.setBounds(20, 250, 120, 30);
        this.add(fEntradaLB);

        fSalidaLB = new JLabel("F. Salida:");
        fSalidaLB.setBounds(20, 300, 50, 30);
        this.add(fSalidaLB);

        dniTF = new JTextField();
        dniTF.setBounds(90, 150, 200, 30);
        this.add(dniTF);

        nombreTF = new JTextField();
        nombreTF.setBounds(90, 200, 200, 30);
        this.add(nombreTF);

        fEntradaTF = new JTextField(LocalDate.now().toString());
        fEntradaTF.setBounds(90, 250, 200, 30);
        this.add(fEntradaTF);

        fSalidaTF = new JTextField(LocalDate.now().toString());
        fSalidaTF.setBounds(90, 300, 200, 30);
        this.add(fSalidaTF);

        pvpLB = new JLabel("precio por día: ");
        pvpLB.setBounds(20, 350, 100, 30);
        this.add(pvpLB);

        pvpTF = new JTextField();
        pvpTF.setBounds(120, 350, 100, 30);
        this.add(pvpTF);

        grabarBT = new JButton("Grabar");
        grabarBT.setBounds(163, 450, 100, 50);
        this.add(grabarBT);

        facturaBT = new JButton("Facturar");
        facturaBT.setBounds(100, 400, 100, 50);

        panelDeExtras = new JPanel();
        panelDeExtras.setLayout(null);
        panelDeExtras.setBounds(450, 10, 295, 500);
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Extras");
        panelDeExtras.setBorder(bordejpanel);
        panelDeExtras.setVisible(false);

        this.add(panelDeExtras);

        ciudadCB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                cargarComboHoteles(ciudadCB.getSelectedItem().toString());

            }
        });

        hotelCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (hotelCB.getSelectedItem() != null) {
                    ponerPrecioDia(hotelCB.getSelectedItem().toString());
                    colocarExtras(hotelCB.getSelectedItem().toString());
                    panelDeExtras.add(facturaBT);
                    facturaBT.setVisible(true);
                }

            }
        });

        grabarBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteGHP cliente = null;
                EstanciaGHP estancia = null;
                BufferedWriter output;

                verificaCliente(dniTF.getText());

                // creo la instancia de la estancia
                for (int i = 0; i < hoteles.getListaHoteles().size(); i++) {

                    if (hoteles.getListaHoteles().get(i).getNomHotel().equals(hotelCB.getSelectedItem().toString())) {

                        estancia = new EstanciaGHP(
                                hoteles.getListaHoteles().get(i).getCodHotel(),
                                hoteles.getListaHoteles().get(i).getNomHotel(),
                                hoteles.getListaHoteles().get(i).getCiudad(),
                                hoteles.getListaHoteles().get(i).getPrecioDia(),
                                LocalDate.parse(fEntradaTF.getText()),
                                LocalDate.parse(fSalidaTF.getText()));

                        for (int j = 0; j < clientes.getListaClientes().size(); j++) {
//                            System.out.println("" + clientes.getListaClientes().get(j).getDni());
                            if (dniTF.getText().equalsIgnoreCase(clientes.getListaClientes().get(j).getDni())) {

                                clientes.getListaClientes().get(j).insertaEstancias(estancia);

                            }
                        }
                    }
                }
                System.out.println("" + estancia.toString());
            }
        }
        );

        facturaBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HotelGHP hotelSelecionado = null;
                FacturaGHP factura = new FacturaGHP();

                for (int i = 0; i < hoteles.getListaHoteles().size(); i++) {
                    if (hoteles.getListaHoteles().get(i).getNomHotel().equals(hotelCB.getSelectedItem().toString())) {
                        hotelSelecionado = hoteles.getListaHoteles().get(i);
                    }
                }

                if ((hotelSelecionado != null) && (dniTF.getText().length() != 0)) {
                    String ficheroSalida = "Nº fra- " + factura.getnFac() + " _ " + hotelSelecionado.getCodHotel() + " _ " + dniTF.getText() + ".txt";
                    BufferedWriter salida = InOutGHP.abreEscritura(ficheroSalida);
                    Double sumaExtras = 0.0;
                    String extrasImprimir = null;
                    for (int i = 0; i < listadoExtras.length; i++) {
                        if (listadoExtras[i].isSelected()) {
                            extrasImprimir += "\n extra: " + listadoExtras[i].toString();
                            sumaExtras += extrasSeleccionados.get(i).getImporteExtra();
                        }
                    }

                    Double precioDiaSeleccionado = hotelSelecionado.getPrecioDia();
                    LocalDate fEc = null;
                    if (fEntradaTF.getText().length() == 0) {
                        fEc = LocalDate.now();
                    } else {
                        fEc = LocalDate.parse(fEntradaTF.getText());
                    }

                    LocalDate fSc = null;
                    if (fSalidaTF.getText().length() == 0) {
                        fSc = fEc.plusDays(1);
                    } else {
                        fSc = LocalDate.parse(fSalidaTF.getText());
                    }

                    int totalDias = Period.between(fEc, fSc).getDays();
                    if (totalDias == 0) {
                        totalDias = 1;
                    }
                    double sumaTotal = (totalDias * precioDiaSeleccionado) + sumaExtras;

                    String textoFactura
                            = "Ciudad: " + hotelSelecionado.getCiudad()
                            + "   "
                            + "Hotel: " + hotelSelecionado.getNomHotel()
                            + "\n\nDNI cliente: " + dniTF.getText()
                            + "     "
                            + "Nombre: " + nombreTF.getText()
                            + "\n\n\n      Total dias: " + totalDias
                            + "\n      Total Extras: " + sumaExtras
                            + "\n\n          TOTAL.- " + sumaTotal;

                    InOutGHP.escribeLinea(salida, textoFactura);
                    InOutGHP.cierraFicheroEscritura(salida);
                }
            }
        });

        this.setVisible(true);
    }// fin del constructor****************************************************

    public void cargaHoteles() {
        String linea;
        String[] division;

        BufferedReader input = InOutGHP.abreLectura("hoteles.txt");

        linea = InOutGHP.leeLinea(input);
        while (linea != null) {
            division = linea.split("/");
            HotelGHP hotel = new HotelGHP(division[0], division[1], division[2], Double.parseDouble(division[3]));
            hoteles.insertaHotel(hotel);
            linea = InOutGHP.leeLinea(input);
        }
        cargarComboCiudad();
    }

    public void cargarClientes() {
        String linea;
        String[] division;

        BufferedReader input = InOutGHP.abreLectura("cliente.txt");

        linea = InOutGHP.leeLinea(input);
        while (linea != null) {
            division = linea.split("/");
            ClienteGHP cliente = new ClienteGHP(division[0], division[1]);
            clientes.insertaCliente(cliente);
            linea = InOutGHP.leeLinea(input);
        }
    }

    public void verificaCliente(String dni) {
        ClienteGHP cliente = null;
        boolean encontrado = true;
        if (clientes.getListaClientes().size() == 0) {
            String clienteNuevo = nombreTF.getText() + "/" + dniTF.getText();
            cliente = new ClienteGHP(nombreTF.getText(), dniTF.getText());
            clientes.insertaCliente(cliente);
            grabarCliente(clienteNuevo);
        } else {
            for (int i = 0; i < clientes.getListaClientes().size(); i++) {
                if (!dni.equalsIgnoreCase(clientes.getListaClientes().get(i).getDni())) {
                    encontrado = false;
                } else {
                    encontrado = true;
                }
            }
            if (!encontrado) {
                String clienteNuevo = nombreTF.getText() + "/" + dniTF.getText();
                cliente = new ClienteGHP(nombreTF.getText(), dniTF.getText());
                clientes.insertaCliente(cliente);
                grabarCliente(clienteNuevo);
                System.out.println("cliente nuevo grabado: " + cliente.getNombreCliente() + cliente.getDni() + dniTF.getText());
            }
        }
    }

    public void grabarCliente(String clienteNuevo) {
        BufferedWriter output = InOutGHP.abreEscrituraAppend("cliente.txt");
        InOutGHP.escribeLineaAppend(output, clienteNuevo);
        InOutGHP.cierraFicheroEscritura(output);
    }

    public void cargarComboCiudad() {

        ciudadCB = new JComboBox();
        hotelCB = new JComboBox();
        String[] ciudadcarga = new String[hoteles.getListaHoteles().size()];
        String[] hotelcarga = new String[hoteles.getListaHoteles().size()];
        int r = 0;
        for (int i = 0; i < hoteles.getListaHoteles().size(); i++) {
            ciudadcarga[i] = hoteles.getListaHoteles().get(i).getCiudad();
        }
        Arrays.sort(ciudadcarga);

        for (r = 0; r < ciudadcarga.length - 1; r++) {
            if (!ciudadcarga[r].equalsIgnoreCase(ciudadcarga[r + 1])) {
                ciudadCB.addItem(ciudadcarga[r]);
            }
        }
        ciudadCB.addItem(ciudadcarga[r]);
    }

    public void cargarComboHoteles(String ciudad) {
        hotelCB.removeAllItems();
        for (int i = 0; i < hoteles.getListaHoteles().size(); i++) {
            if (hoteles.getListaHoteles().get(i).getCiudad().equalsIgnoreCase(ciudad)) {
                hotelCB.addItem(hoteles.getListaHoteles().get(i).getNomHotel());
            }
        }
    }

    public void ponerPrecioDia(String nomHotel) {
        try {
            for (int i = 0; i < hoteles.getListaHoteles().size(); i++) {
                if (hoteles.getListaHoteles().get(i).getNomHotel().equals(nomHotel)) {
                    pvpTF.setText("" + hoteles.getListaHoteles().get(i).getPrecioDia());
                    System.out.println("" + hoteles.getListaHoteles().get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("Fallo en ponerPrecioDia: " + e.getMessage());
        }
    }

    public void cargarExtras() {

        String linea;
        String[] div1 = null;
        String[] div2 = null;
        String[] div3 = null;
        BufferedReader input = InOutGHP.abreLectura("Extras.txt");

        linea = InOutGHP.leeLinea(input);
        while (linea != null) {
            div1 = linea.split("/");
            div2 = div1[1].split(",");

            for (int i = 0; i < hoteles.getListaHoteles().size(); i++) {
                if (div1[0].equalsIgnoreCase(hoteles.getListaHoteles().get(i).getCodHotel())) {
                    for (int jj = 0; jj < div2.length; jj++) {
                        div3 = div2[jj].split(":");
                        extrasAñadirHotel = new ExtrasGHP(div3[0], Double.parseDouble(div3[1]));
                        hoteles.getListaHoteles().get(i).añadeExtra(extrasAñadirHotel);
                    }
                }
            }
            linea = InOutGHP.leeLinea(input);
        }
    }

    public void colocarExtras(String nomHotel) {
        panelDeExtras.removeAll();

        for (int i = 0; i < hoteles.getListaHoteles().size(); i++) {

            if (hoteles.getListaHoteles().get(i).getNomHotel().equalsIgnoreCase(nomHotel)) {
                extrasSeleccionados = hoteles.getListaHoteles().get(i).getExtras();
                listadoExtras = new JCheckBox[extrasSeleccionados.size()];

                for (int j = 0; j < extrasSeleccionados.size(); j++) {

                    listadoExtras[j] = new JCheckBox(extrasSeleccionados.get(j).getTipoExtra() + ": " + extrasSeleccionados.get(j).getImporteExtra() + "€");
                    listadoExtras[j].setBounds(5, 50 + 40 * j, 200, 20);
                    panelDeExtras.add(listadoExtras[j]);
                }
            }
        }
        panelDeExtras.repaint();
        panelDeExtras.setVisible(true);
    }

//    public Loca formatoFecha() {
//        LocalDate hoy = LocalDate.now();
//        String  cambioFormatoFecha =hoy.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        LocalDate pepe = LocalDate.parse(cambioFormatoFecha);
//        return cambioFormatoFecha;
//
//    }
}
