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
import modelo.Producto;
import modelo.Usuario;
import vistas.Editar_Producto;
import vistas.Menu;

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
        this.vista.getBpreview().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
    
        if(vista.getbEditar()==e.getSource()){
            System.out.println("presionando boton");
            int id=Integer.parseInt(vista.txtId.getText());
            String nombre=vista.txtNombre.getText();
            String marca=vista.txtMarca.getText();
            float precioCompra=Float.parseFloat(vista.txtPrecioCompra.getText());
            float precioVenta=Float.parseFloat(vista.txtPrecioVenta.getText());
            
            Usuario user = new Usuario();
            
            try {
                user.editar_producto(id, nombre, marca, precioCompra, precioVenta);
            } catch (Exception ex) {
                System.out.println(ex);
            }            
        }
        if(vista.getBpreview()==e.getSource())
        {
            Producto producto;
            Usuario usuario = new Usuario();
            try {
                producto=usuario.getproduct(Integer.parseInt(vista.getTxtId().getText()));
                
                if(producto.getId() != 0)
                {
                    vista.setjTable1(usuario.preview_edit_product(vista.getjTable1(), producto));
                }else
                {
                    JOptionPane.showMessageDialog(null, "El producto no existe intente de nuevo");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(Control_ventas.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        if(vista.getbRegresar()==e.getSource())
        {
            Menu nuevo=new Menu();
            Control_menu cmenu= new Control_menu(nuevo);
            nuevo.setVisible(true);
            vista.dispose();             
        }
    
    
    }
}
