/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static com.sun.webkit.perf.WCGraphicsPerfLogger.reset;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vistas.Agregar_Usuario;
import vistas.Menu;

/**
 *
 * @author black
 */
public class Control_Agregar_Usuario implements ActionListener
{
    private Agregar_Usuario Nuser;
    public Control_Agregar_Usuario(Agregar_Usuario Nuser) 
    {
        this.Nuser=Nuser;        
        this.Nuser.getBadduser().addActionListener(this);
        this.Nuser.getBregresar().addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(Nuser.getBadduser()==e.getSource())
        {
            if(Nuser.getTxtaddpasconfirm().equals(Nuser.getTxtaddpass()))
            {
                Usuario usuario= new Usuario();
                
                try {
                    usuario.agregar_usuario(Nuser);
                    JOptionPane.showMessageDialog(null, "El usuario fue agregado exitosamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar persona");
                    System.out.println(ex);
                }
                
            }else
            {
                JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
            }
        }
        if(Nuser.getBregresar()==e.getSource())
        {                        
            Menu nuevo=new Menu();
            Control_menu cmenu= new Control_menu(nuevo);
            nuevo.setVisible(true);
            Nuser.dispose();            
        }
        
    }
    
}
