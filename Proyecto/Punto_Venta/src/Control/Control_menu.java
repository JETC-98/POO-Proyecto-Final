/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.Agregar_Producto;
import vistas.Agregar_Usuario;
import vistas.Borrar_Producto;
import vistas.Editar_Producto;
import vistas.Eliminar_Usuario;
import vistas.Inventario;
import vistas.Menu;
import vistas.Reporte_de_Ventas;
import vistas.Ventas;

/**
 *
 * @author black
 */
public class Control_menu implements ActionListener{
    private Menu menu_principal;
    
    public Control_menu(Menu menu)
    {
        menu_principal=menu;
        menu_principal.getBadd_producto().addActionListener(this);
        menu_principal.getBadd_user().addActionListener(this);
        menu_principal.getBborrar_producto().addActionListener(this);
        menu_principal.getBborrar_user().addActionListener(this);
        menu_principal.getBcerrar_sesion().addActionListener(this);
        menu_principal.getBedit_producto().addActionListener(this);
        menu_principal.getBinventario().addActionListener(this);
        menu_principal.getBreporte_ventas().addActionListener(this);
        menu_principal.getBventas().addActionListener(this);
                
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        menu_principal.dispose();
        if(menu_principal.getBventas()== ae.getSource()) 
        {
            Ventas venta=new Ventas();
            venta.setVisible(true);
            menu_principal.dispose();
            
        }
        
        if(menu_principal.getBreporte_ventas()== ae.getSource()) 
        {
            Reporte_de_Ventas reporte = new Reporte_de_Ventas();
            reporte.setVisible(true);
            menu_principal.dispose();
        }
               
        if(menu_principal.getBinventario()== ae.getSource()) 
        {
            Inventario inventario=new Inventario();
            inventario.setVisible(true);
            menu_principal.dispose();
        }
        
        if(menu_principal.getBadd_producto()== ae.getSource()) 
        {
            Agregar_Producto addproduct=new Agregar_Producto();
            addproduct.setVisible(true);
            menu_principal.dispose();
        }
        if(menu_principal.getBedit_producto()==ae.getSource())
        {
            Editar_Producto editproduct = new Editar_Producto();
            editproduct.setVisible(true);
            menu_principal.dispose();
            
        }
        if(menu_principal.getBborrar_producto()==ae.getSource())
        {
            Borrar_Producto borrarproducto=new Borrar_Producto();
            borrarproducto.setVisible(true);
            menu_principal.dispose();
        }
        if(menu_principal.getBadd_user()==ae.getSource())
        {                    
            Agregar_Usuario Nuser=new Agregar_Usuario();
            Control_Agregar_Usuario adduser=new Control_Agregar_Usuario(Nuser);            
            Nuser.setVisible(true);
            
            
        }        
        if(menu_principal.getBborrar_user()==ae.getSource())
        {
            Eliminar_Usuario usuario=new Eliminar_Usuario();
            usuario.setVisible(true);
            menu_principal.dispose();
        }        
    }
    
}
