/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.Eliminar_Usuario;
import vistas.Menu;

/**
 *
 * @author black
 */
public class Control_Eliminar_Usuario implements ActionListener{

    Eliminar_Usuario elimuser;
    
    public Control_Eliminar_Usuario(Eliminar_Usuario elimuser) 
    {
        this.elimuser=elimuser;
        this.elimuser.getBregresar().addActionListener(this);
        this.elimuser.getBdeleteuser().addActionListener(this);        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(elimuser.getBdeleteuser()==e.getSource())
        {
            
        }
        if(elimuser.getBregresar()==e.getSource())
        {
            Menu nuevo=new Menu();
            Control_menu cmenu= new Control_menu(nuevo);
            nuevo.setVisible(true);
            elimuser.dispose();               
        }
        
    }
    
}
