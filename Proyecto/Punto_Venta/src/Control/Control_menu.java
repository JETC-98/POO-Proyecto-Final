/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.Menu;
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
        
        if(menu_principal.getBventas()== ae.getSource()) 
        {
            System.out.println("hola");
            Ventas venta=new Ventas();
            venta.setVisible(true);
            menu_principal.dispose();
            
        }
        
        if(menu_principal.getBreporte_ventas()== ae.getSource()) 
        {
            
        }
               
        if(menu_principal.getBinventario()== ae.getSource()) 
        {
            
        }
        
        if(menu_principal.getBadd_producto()== ae.getSource()) 
        {
            
        }
        if(menu_principal.getBedit_producto()==ae.getSource())
        {
            
        }
        if(menu_principal.getBborrar_producto()==ae.getSource())
        {
            
        }
        if(menu_principal.getBadd_user()==ae.getSource())
        {
            
        }        
        if(menu_principal.getBborrar_user()==ae.getSource())
        {
            
        }        
    }
    
}
