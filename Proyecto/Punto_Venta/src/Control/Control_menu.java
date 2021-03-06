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
import vistas.Editar_Producto;
import vistas.Eliminar_Usuario;
import vistas.Inventario;
import vistas.Login;
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
            Control_ventas cventas=new Control_ventas(venta);
            venta.setVisible(true);                        
        }
        
        if(menu_principal.getBreporte_ventas()== ae.getSource()) 
        {
            Reporte_de_Ventas reporte = new Reporte_de_Ventas();
            reporte.setVisible(true);
            
        }
               
        if(menu_principal.getBinventario()== ae.getSource()) 
        {
            Inventario inventario=new Inventario();
            Control_Inventario cinventario = new Control_Inventario(inventario);
            inventario.setVisible(true);
            
        }
        
        if(menu_principal.getBadd_producto()== ae.getSource()) 
        {
            Agregar_Producto addproduct=new Agregar_Producto();
            Control_Agregar_producto caddproduct=new Control_Agregar_producto(addproduct);
            addproduct.setVisible(true);
            
        }
        if(menu_principal.getBedit_producto()==ae.getSource())
        {
            Editar_Producto editproduct = new Editar_Producto();
            Control_Editar_Producto cedit=new Control_Editar_Producto(editproduct);
            editproduct.setVisible(true);
            
            
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
            Control_Eliminar_Usuario celimuser=new Control_Eliminar_Usuario(usuario);
            usuario.setVisible(true);
            
        }
        if(menu_principal.getBcerrar_sesion()==ae.getSource())
        {
            Login login = new Login();
            Control_login clogin = new Control_login(login);
            login.setVisible(true);
        }
    }
    
}
