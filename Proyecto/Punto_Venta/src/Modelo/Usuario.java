/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import vistas.Agregar_Producto;

/**
 *
 * @author Daniel
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private boolean admin;
    private String password;

    private static final String URL = "jdbc:mysql://localhost:3306/Escuela";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    PreparedStatement ps;
    ResultSet rs;    
    
    public Usuario(int id, String nombre, boolean admin, String password) {
        this.id = id;
        this.nombre = nombre;
        this.admin = admin;
        this.password = password;
    }    
    
    private static Connection getConection()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            JOptionPane.showMessageDialog(null, "conexion exitosa");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }    
    
    public void agregar_Producto_Almacen(Agregar_Producto nuevo_producto)
    {
        Connection con= null;
        try
        {
            con = getConection();
            ps = con.prepareStatement("INSERT INTO producto (ID,nombre,marca,compra,venta,cantidad) VALUES(?,?,?,?,?,?)");
            
            ps.setInt(1, nuevo_producto.getTxtaddidentificador());
            ps.setString(2, nuevo_producto.getTxtaddnombre());
            ps.setString(3, nuevo_producto.getTxtaddmarca());
            ps.setInt(4, nuevo_producto.getTxtaddpcompra());
            ps.setInt(5, nuevo_producto.getTxtaddpventa());
            ps.setInt(6, nuevo_producto.getSpinneraddcantidad());
            
            int res= ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Producto guardado");
//                limpiarcajas();
            }else
            {
                JOptionPane.showMessageDialog(null, "Error al guardar producto intente de nuevo");
//                limpiarcajas();
            }
            
            con.close();
            
        }catch(Exception e)
        {
            System.err.println(e);
        }        
    }    
    
    
}
