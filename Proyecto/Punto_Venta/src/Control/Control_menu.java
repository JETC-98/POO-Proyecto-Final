/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.Menu;

/**
 *
 * @author black
 */
public class Control_menu implements ActionListener{
    Menu menu_principal;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(menu_principal.getBventas()== ae.getSource()) 
        {
            
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
