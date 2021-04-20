/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_pinteno;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Satrux
 */
public class VentanaGHP extends JFrame {

    PanelGHP panel;

    public VentanaGHP() {
        panel = new PanelGHP();
        this.setLayout(null);
        this.setTitle("GHotel Pinteno");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 100, 800, 600);

        this.add(panel);
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Datos Estancia");
        panel.setBorder(bordejpanel);

        this.setVisible(true);

    }

}
