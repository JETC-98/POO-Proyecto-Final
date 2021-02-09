/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import vistas.Agregar_Producto;
import vistas.Agregar_Usuario;
import vistas.Login;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Daniel
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private int admin;
    private String contrasena;
    
    public static final String URL = "jdbc:mysql://localhost:3306/Escuela";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";    
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario(int id, String nombre, int admin, String password) {
        this.id = id;
        this.nombre = nombre;
        this.admin = admin;
        this.contrasena = password;
    }
    
    public Usuario()
    {
        
    }
    
    public static Connection getConection()
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
    
    public void agregar_producto(Agregar_Producto nuevo) throws Exception
    {
        Connection con= null;
            con = getConection();
            ps = con.prepareStatement("INSERT INTO productos (ID,nombre,marca,compra,venta,cantidad) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, nuevo.getTxtaddidentificador());
            ps.setString(2, nuevo.getTxtaddnombre());
            ps.setString(3, nuevo.getTxtaddmarca());
            ps.setFloat(4, nuevo.getTxtaddpcompra());
            ps.setFloat(5, nuevo.getTxtaddpventa());
            ps.setInt(6, nuevo.getSpinneraddcantidad());            
            
            int res= ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Persona guardada");
                //limpiarcajas();
            }else
            {
                JOptionPane.showMessageDialog(null, "Error al guardar persona");
                //limpiarcajas();
            }
            
            con.close();      
    }
    
    public void agregar_usuario(Agregar_Usuario nuevo) throws Exception
    {
        Connection con= null;
            con = getConection();
            ps = con.prepareStatement("INSERT INTO usuarios (nombre,contrasena,permiso) VALUES(?,?,?)");
            ps.setString(1, nuevo.getTxtaddnombre());
            ps.setString(2, nuevo.getTxtaddpass());           
            ps.setInt(3, 0);
            
            int res= ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Persona guardada");
                //limpiarcajas();
            }else
            {
                JOptionPane.showMessageDialog(null, "Error al guardar persona");
                //limpiarcajas();
            }
            
            con.close();       
    }
    
    public boolean log_in(String nuevo) throws Exception
    {
        String novo=nuevo;
        boolean permiso=false;
        Connection con=null;
            con = getConection();
            ps = con.prepareStatement("SELECT * FROM usuarios WHERE nombre = ?");
            ps.setString(1, nuevo);
            rs = ps.executeQuery();
            if(rs.next())
            {                               
                contrasena=rs.getString("contrasena");
                admin=rs.getInt("permiso");
                permiso = true;
            }
                        
            con.close();
            
        return permiso;
    }

    public int isAdmin() {
        return admin;
    }

    public String getContrasena() {
        return contrasena;
    }
        
}
