/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;
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
            String fallos="Fallo en la base de datos";
            Usuario usuario = new Usuario();
            try {
                fallos=usuario.eliminar_usuario(elimuser.getTxtnombre(), elimuser.getTxtadminpass());
            } catch (Exception ex) {
                System.out.println("Fallo T-T");
                System.out.println(ex);
            }
            if(fallos.equalsIgnoreCase("contrasena"))
            {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
            }
            else if(fallos.equalsIgnoreCase("nombre"))
            {
                JOptionPane.showMessageDialog(null, "No existe ese usuario");
            }
            else if(fallos.equalsIgnoreCase("perfecto"))
            {
                JOptionPane.showMessageDialog(null, "Se a eliminado el usuario");
            }
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
