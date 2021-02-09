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
import vistas.Agregar_Producto;
import vistas.Menu;

/**
 *
 * @author black
 */
public class Control_Agregar_producto implements ActionListener{
    Agregar_Producto addproduct;
    
    public Control_Agregar_producto(Agregar_Producto addproduct)
    {
        this.addproduct=addproduct;
        this.addproduct.getBagregar().addActionListener(this);
        this.addproduct.getBregresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("accion realizada");
        
        if(addproduct.getBagregar()==e.getSource())
        {
            Usuario usuario=new Usuario();
            try {
                usuario.agregar_producto(addproduct);
                JOptionPane.showMessageDialog(null, "El producto se ha guardado exitosamente");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error por favor intente de nuevo");
                System.out.println("fallo T-T");
                Logger.getLogger(Control_Agregar_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        if(addproduct.getBregresar()==e.getSource())
        {
            System.out.println("boton regresar");
            Menu nuevo=new Menu();
            Control_menu cmenu= new Control_menu(nuevo);
            nuevo.setVisible(true);
            addproduct.dispose();            
        }
    }
}
