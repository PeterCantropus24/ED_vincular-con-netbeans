/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_pinteno;

/**
 *
 * @author Satrux
 */
public class ExtrasGHP {
    
    private String tipoExtra;
    private double importeExtra;

    public ExtrasGHP(String tipoExtra, double importeExtra) {
        this.tipoExtra = tipoExtra;
        this.importeExtra = importeExtra;
    }

    public String getTipoExtra() {
        return tipoExtra;
    }

    public void setTipoExtra(String tipoExtra) {
        this.tipoExtra = tipoExtra;
    }

    public double getImporteExtra() {
        return importeExtra;
    }

    public void setImporteExtra(double importeExtra) {
        this.importeExtra = importeExtra;
    }
    
    @Override
    public String toString() {
        return "Extra{" + "nombre=" + tipoExtra + ", importe=" + importeExtra + '}';
    }
    
    
}
