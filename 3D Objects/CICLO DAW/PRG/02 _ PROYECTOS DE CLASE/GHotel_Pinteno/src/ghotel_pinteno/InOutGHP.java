/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_pinteno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Satrux
 */
public class InOutGHP {

    // *****************     abrir ficheros    *********************************    
    public static ObjectInputStream abrirEntrada(String fichero) {
        ObjectInputStream entradaDesdeFichero = null;
        try {
            entradaDesdeFichero = new ObjectInputStream(new FileInputStream(fichero));
            return entradaDesdeFichero;
        } catch (Exception e) {
            System.out.println("error apertura fichero de entrada");
            return null;
        }
    }

    public static ObjectOutputStream abrirSalida(String fichero) {
        ObjectOutputStream abrirSalida = null;

        try {
            abrirSalida = new ObjectOutputStream(new FileOutputStream(fichero));
            return abrirSalida;
        } catch (Exception e) {
            System.out.println("error apertura fichero de salida");
            return null;
        }
    }

// *****************     cerrar ficheros    ********************************* 
    public static void cerrarFicheroEntrada(ObjectInputStream abrirEntrada) {
        try {
            if (abrirEntrada != null) {
                abrirEntrada.close();
            }

        } catch (Exception e2) {
            System.out.println("error cerrar fichero entrada");
        }
    }

    public static void cerrarFicheroSalida(ObjectOutputStream abrirSalida) {
        try {
            if (abrirSalida != null) {
                abrirSalida.close();
            }
        } catch (Exception e) {
            System.out.println("error cerrar fichero de salida");
        }
    }
// *****************     IO ficheros    *********************************  

    public static Object leerFichero(ObjectInputStream entrada) {
        try {
            return entrada.readObject();

        } catch (Exception e) {
            System.out.println("no se puede leer fichero de entrada");
            return null;
        }
    }

    public static void escribirEnFichero(ObjectOutputStream salida, Object datosGrabar) {
        try {
            salida.writeObject(datosGrabar);

        } catch (Exception e) {
            System.out.println("error al grabar los datos");
        }
    }

    // *****************     IO Buffered    *********************************  
    static BufferedReader abreLectura(String fichero) {
        BufferedReader input = null;
        try {
            return input = new BufferedReader(new FileReader(fichero));

        } catch (Exception e) {
            System.out.println("error al abrir fichero con metodo abreLectura");
            return null;
        }
    }

    static BufferedWriter abreEscritura(String fichero) {
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(fichero));
        } catch (Exception e) {
            System.out.println("error al abrir fichero metodo abreEscritura");
        }
        return output;
    }
    
    static BufferedWriter abreEscrituraAppend(String fichero) {
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(fichero,true));
        } catch (Exception e) {
            System.out.println("error al abrir fichero metodo abreEscritura");
        }
        return output;
    }

    static String leeLinea(BufferedReader input) {
        String linea = "";
        try {
            linea = input.readLine();
        } catch (Exception e) {
            System.out.println("error en metodo leeLinea");
        }
        return linea;
    }

    static void escribeLinea(BufferedWriter output, String linea) {
        try {
            output.write(linea);
        } catch (Exception e) {
            System.out.println("error en metodo escribeLinea");
        }
    }
    
    static void escribeLineaAppend(BufferedWriter output, String linea) {
        try {
            output.append(linea+"\n");
        } catch (Exception e) {
            System.out.println("error en metodo escribeLinea");
        }
    }

    

    static void cierraFicheroLectura(BufferedReader input) {
        try {
            input.close();
        } catch (Exception e) {
            System.out.println("error metodo cierraFicheroLectura");
        }
    }

    static void cierraFicheroEscritura(BufferedWriter output) {
        try {
            output.close();
        } catch (Exception e) {
            System.out.println("error metodo cierraFicheroEscritura");
        }
    }

}
