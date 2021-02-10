/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vistas.Agregar_Producto;
import vistas.Agregar_Usuario;
import vistas.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author black
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
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error en la conexion por favor vuelva a intentar");
            System.out.println(e);
        }
        return con;
    }    
    
    public void agregar_producto(Agregar_Producto nuevo) throws Exception
    {
        Connection con= null;
            con = getConection();
            ps = con.prepareStatement("INSERT INTO productos (id,nombre,marca,compra,venta,cantidad) VALUES(?,?,?,?,?,?)");            
            ps.setInt(1, nuevo.getTxtaddidentificador());
            ps.setString(2, nuevo.getTxtaddnombre());
            ps.setString(3, nuevo.getTxtaddmarca());
            ps.setFloat(4, nuevo.getTxtaddpcompra());
            ps.setFloat(5, nuevo.getTxtaddpventa());
            ps.setInt(6, nuevo.getSpinneraddcantidad());  
            ps.executeUpdate();
            con.close();      
    }
    
    public void editar_producto(int id, String nombre, String marca, float precioCompra, float precioVenta) throws Exception
    {
        Connection con= null;
            con = getConection();
            ps = con.prepareStatement("UPDATE productos SET nombre='"+nombre+"',marca='"+marca+"',compra="+precioCompra+",venta="+precioVenta+" Where id="+id);             
            ps.executeUpdate();
            con.close();      
    }
    
    public void agregar_usuario(Agregar_Usuario nuevo) throws Exception
    {
        Connection con= null;
        try
        {
            con = getConection();
            ps = con.prepareStatement("INSERT INTO usuarios (nombre,contrasena,permiso) VALUES(?,?,?)");
            ps.setString(1, nuevo.getTxtaddnombre());
            ps.setString(2, nuevo.getTxtaddpass());
            ps.setInt(3, 0);
            
            int res= ps.executeUpdate();            
            con.close();
            
        }catch(Exception e)
        {
            System.err.println(e);
        }      
    }
    
    public boolean log_in(String nuevo) throws Exception
    {
        
        boolean entrar=false;
        Connection con=null;
            con = getConection();
            ps = con.prepareStatement("SELECT * FROM usuarios WHERE nombre = ?");
            ps.setString(1, nuevo);
            rs = ps.executeQuery();
            if(rs.next())
            {                               
                contrasena=rs.getString("contrasena");
                admin=rs.getInt("permiso");
                entrar = true;
            }
                        
            con.close();
            
        return entrar;
    }
    
    public Producto getproduct(int id) throws Exception
    {        
        Producto p;
        Connection con=null;
            con = getConection();
            ps = con.prepareStatement("SELECT * FROM productos WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next())
            {                               
                p=new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getString("marca"), rs.getFloat("compra"), rs.getFloat("venta"), rs.getInt("cantidad"));
                                
            }else
            {
                p=new Producto(0,null,null,0,0,0);
                
            }
            
            con.close();        
            
            return p;
    } 

    public int isAdmin() {
        return admin;
    }
   
    public JTable addlista_de_compras(JTable tabla,Producto producto,int cantidad)
    {
        float total= producto.getCosto_Venta()*cantidad;
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.addRow(new Object[]{producto.getNombre(), producto.getMarca(), producto.getCosto_Venta(), cantidad,total});
        return tabla;
    }
    public JTable preview_edit_product(JTable tabla,Producto producto)
    {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.addRow(new Object[]{producto.getNombre(), producto.getMarca(), producto.getCosto_Compra(), producto.getCosto_Venta()});
        return tabla;
    }    
    public JTable removelista_de_compras(JTable tabla)
    {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int row = tabla.getSelectedRow();
        if(row==-1)
        {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun objeto");
        }else{
            model.removeRow(row);
        }
                
        return tabla;
    }
    
    public String close_sale(JTable tabla)
    {
        float total=0;
        String stotal;
        int rownum;
        rownum = tabla.getRowCount();
        
        for(int i=0;i<rownum;i++)
        {
            total=total + Float.parseFloat((String.valueOf(tabla.getValueAt(i, 4))))  ;
        }
        
        stotal= String.valueOf(total);
        
        return stotal;
    }
    
    public String eliminar_usuario(String usuario,String pass) throws Exception
    {
        String flag="perfecto";
        int flag2;
        
        Connection con=null;
        con = getConection();
        ps = con.prepareStatement("SELECT * FROM usuarios WHERE contrasena = ?");
        ps.setString(1, pass);
        rs = ps.executeQuery();
        
        if(rs.next())
        {
            ps = con.prepareStatement("DELETE FROM usuarios WHERE nombre = ?");
            ps.setString(1, usuario);
            flag2 = ps.executeUpdate();
            if(flag2>0)
            {
                flag = "perfecto";
            }else
            {
                flag="nombre";
            }
        }else{
            flag="contrasena";
        }
        
        con.close();        
        return flag;
    }
    
    public String getContrasena() {
        return contrasena;
    }    
}
