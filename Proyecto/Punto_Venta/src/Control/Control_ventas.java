/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Control_login.permiso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.Usuario;
import vistas.Datos_del_Cliente;
import vistas.Menu;
import vistas.Ventas;

/**
 *
 * @author black
 */
public class Control_ventas implements ActionListener
{
    Ventas venta;
    public Control_ventas(Ventas venta) 
    {
        this.venta=venta;
        
        this.venta.getBaddproduct().addActionListener(this);
        this.venta.getBclosesale().addActionListener(this);
        this.venta.getBdeleteproduct().addActionListener(this);
        this.venta.getBregresar().addActionListener(this);
        this.venta.getBfacturar().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(venta.getBaddproduct()==e.getSource())
        {
            Producto producto;
            Usuario usuario = new Usuario();
            try {
                producto=usuario.getproduct(venta.getTxtid());
                
                if(producto.getId() != 0)
                {
                    venta.setjTable1(usuario.addlista_de_compras(venta.getjTable1(), producto, venta.getSpincantidad()));
                }else
                {
                    JOptionPane.showMessageDialog(null, "El producto no existe intente de nuevo");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(Control_ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(venta.getBdeleteproduct()==e.getSource())
        {
            Usuario usuario=new Usuario();
            venta.setjTable1(usuario.removelista_de_compras(venta.getjTable1()));
        }
        if(venta.getBclosesale()==e.getSource())
        {
            Usuario usuario = new Usuario();
            venta.setLabeltotal(usuario.close_sale(venta.getjTable1()));
            
        }
        if(venta.getBregresar()==e.getSource())
        {
            if(permiso==0)
            {
                Menu nuevo =new Menu();                            
                            
                nuevo.getBadd_producto().setVisible(false);
                nuevo.getBadd_user().setVisible(false);
                nuevo.getBborrar_user().setVisible(false);                            
                nuevo.getBedit_producto().setVisible(false);
                Control_menu cmenu= new Control_menu(nuevo);
                nuevo.setVisible(true);
                venta.dispose();
                
            }else{
                System.out.println("presionando boton");
                Menu nuevo=new Menu();
                Control_menu cmenu= new Control_menu(nuevo);
                nuevo.setVisible(true);
                venta.dispose();
            }
        }
        if(venta.getBfacturar()==e.getSource())
        {
            Datos_del_Cliente datos=new Datos_del_Cliente();
            Control_Datos_Del_Cliente cdatos=new Control_Datos_Del_Cliente(datos,venta.getjTable1());
            datos.setVisible(true);
        }
        
        
    }
    
}
