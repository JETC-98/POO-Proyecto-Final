/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cliente;
import vistas.Datos_del_Cliente;

/**
 *
 * @author Daniel
 */
public class Control_Datos_Del_Cliente implements ActionListener{
    
    Datos_del_Cliente vista;

    public Control_Datos_Del_Cliente(Datos_del_Cliente vista) {
        this.vista = vista;
        
        this.vista.getbHacerFactura().addActionListener(this);
        this.vista.getbNoHacerFactura().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(vista.getbHacerFactura()==e.getSource()){
            
            Cliente cliente=new Cliente();
            
            String nombre=vista.txtNombre.getText();
            String direccion=vista.txtDireccion.getText();
            String rfc=vista.txtRfc.getText();
            String telefono=vista.getTxtTelefono();
            
            cliente.hacerFactura(nombre, direccion, rfc, telefono);
            vista.dispose();
            
            
        }
        if(vista.getbNoHacerFactura()==e.getSource()){
            vista.dispose();
        }
    }
    
    
}
