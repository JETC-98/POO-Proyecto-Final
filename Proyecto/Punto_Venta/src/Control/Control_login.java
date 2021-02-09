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
import vistas.Login;
import vistas.Menu;

/**
 *
 * @author black
 */
public class Control_login implements ActionListener{
    private Login ingresar;
    public Menu nuevo;
    public Control_login(Login ingresar)
    {
        this.ingresar=ingresar;
        ingresar.getBingresar().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(ingresar.getBingresar() == e.getSource())
        {
            boolean verificador;
            Usuario entrar=new Usuario();
            
            try {
                verificador = entrar.log_in(ingresar.getTxtusuario());
                if(verificador == true)
                {
                    System.out.println("hola");
                    if(ingresar.getTxtpass().equals(entrar.getContrasena()))
                    {
                        System.out.println("hola");
                        if(entrar.isAdmin()==1)
                        {
                            System.out.println("hola");
                            Menu nuevo =new Menu();
                            this.nuevo=nuevo;
                            nuevo.setVisible(true);
                            ingresar.dispose();
                            Control_menu cmenu= new Control_menu(this.nuevo);
                        }
                        else
                        {
                            System.out.println("hola");
                            Menu nuevo =new Menu();                            
                            
                            nuevo.getBadd_producto().setVisible(false);
                            nuevo.getBadd_user().setVisible(false);
                            nuevo.getBborrar_producto().setVisible(false);
                            nuevo.getBborrar_user().setVisible(false);
                            nuevo.getBcerrar_sesion().setVisible(false);
                            nuevo.getBedit_producto().setVisible(false);
                            this.nuevo=nuevo;
                            nuevo.setVisible(true);
                            ingresar.dispose();
                            Control_menu cmenu= new Control_menu(this.nuevo);
                            
                        }
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null, "El usuario no existe");
                }                
            } catch (Exception ex) {
                System.out.println("fallo T-T");
                System.out.println(e);
            }
            

        }
    }
    
}
