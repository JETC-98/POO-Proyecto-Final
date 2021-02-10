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
import modelo.Usuario;
import vistas.Editar_Producto;

/**
 *
 * @author Daniel
 */
public class Control_Editar_Producto implements ActionListener{
    
    Editar_Producto vista;

    public Control_Editar_Producto(Editar_Producto vista) {
        this.vista = vista;
        
        this.vista.getbEditar().addActionListener(this);
        this.vista.getbRegresar().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
    
        if(vista.getbEditar()==e.getSource()){
            String id=vista.txtId.getText();
            String nombre=vista.txtNombre.getText();
            String marca=vista.txtMarca.getText();
            float precioCompra=Float.parseFloat(vista.txtPrecioCompra.getText());
            float precioVenta=Float.parseFloat(vista.txtPrecioVenta.getText());
            
            Usuario user = new Usuario();
            
            try {
                user.editar_producto(id, nombre, marca, precioCompra, precioVenta);
            } catch (Exception ex) {
                Logger.getLogger(Control_Editar_Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    
    }
}
