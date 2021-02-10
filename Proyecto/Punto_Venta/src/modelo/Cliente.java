/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Daniel
 */
public class Cliente {
    
    private int id;
    private String nombre;
    private String direccion;
    private String RFC;
    private int telefono;

    public Cliente(int id, String nombre, String direccion, String RFC, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.RFC = RFC;
        this.telefono = telefono;
        System.out.println("esto es una prueba");
    }

    public Cliente() {
         //To change body of generated methods, choose Tools | Templates.
    }

   
    
    public void hacerFactura(String nombre, String direccion, String RFC, String telefono,JTable tabla){
    
         try{
             Usuario usuario=new Usuario();
             float total=Float.parseFloat(usuario.close_sale(tabla));
             
            File archivo;
            FileWriter w;
            BufferedWriter bw;
            PrintWriter wf;
        
            archivo=new File("Factura"+nombre+".txt");
            w= new FileWriter(archivo);
            bw=new BufferedWriter(w);
            wf=new PrintWriter(bw);
            
            wf.println("Nombre: "+ nombre);
            wf.println("Dirección: "+ direccion);
            wf.println("RFC: "+ RFC);
            wf.println("Telefono: "+ telefono);
            
            int rownum = tabla.getRowCount();
            for(int i=0;i<rownum;i++)
            {
                for (int j=0;j<5;j++)
                {
                    wf.print(String.valueOf(tabla.getValueAt(i, j)));
                    wf.print("    ");
                }
                wf.println(" ");
                
            }
            wf.println("EL TOTAL DE LA COMPRA ES DE: "+total);
            wf.close();
            bw.close();
            
            archivo.createNewFile();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "NO se genero la factura T-T");
        }
        
         
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    
    
}
