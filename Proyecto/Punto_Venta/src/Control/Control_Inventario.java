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
import javax.swing.JTable;
import modelo.Producto;
import modelo.Usuario;
import vistas.Inventario;
import vistas.Menu;

/**
 *
 * @author black
 */
public class Control_Inventario implements ActionListener
{
    Inventario inventario;
    public Control_Inventario(Inventario inventario) 
    {
        this.inventario = inventario;
        this.inventario.getBbuscar().addActionListener(this);
        this.inventario.getBregresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(inventario.getBbuscar()==e.getSource())
        {
            if(inventario.getTxtid().isEmpty()==false)
            {
                System.out.println("a");
                int id=Integer.parseInt(inventario.getTxtid());
                
                Producto producto;
                Usuario usuario = new Usuario();
                try {
                    producto=usuario.getproduct(id);
                    inventario.setjTable1(usuario.addlista_de_compras(inventario.getjTable1(), producto));


                } catch (Exception ex) {
                    Logger.getLogger(Control_ventas.class.getName()).log(Level.SEVERE, null, ex);
                }                
                
            }else if(inventario.getTxtmarca().isEmpty()==false)
            {
                System.out.println("b");
                Usuario usuario = new Usuario();
                try {                
                    JTable x=usuario.setinventariomarca(inventario.getjTable1(), inventario.getTxtmarca());
                    inventario.setjTable1(x);
                } catch (Exception ex) {
                    Logger.getLogger(Control_Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(inventario.getTxtnombre().isEmpty()==false)
            {
                System.out.println("c");
                Usuario usuario = new Usuario();
                try {                  
                    JTable tabla = usuario.setinventario(inventario.getjTable1(), inventario.getTxtnombre());
                    inventario.setjTable1(tabla);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Control_Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                Usuario usuario = new Usuario();
                try {
                    JTable tabla = usuario.getallinventario(inventario.getjTable1());
                    inventario.setjTable1(tabla);
                } catch (Exception ex) {
                    Logger.getLogger(Control_Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(inventario.getBregresar()==e.getSource())
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
                inventario.dispose();
                
            }else{
                System.out.println("presionando boton");
                Menu nuevo=new Menu();
                Control_menu cmenu= new Control_menu(nuevo);
                nuevo.setVisible(true);
                inventario.dispose();
            }            
        }
        
    }
    
}
