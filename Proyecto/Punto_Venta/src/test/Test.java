/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Control.Control_Datos_Del_Cliente;
import vistas.Datos_del_Cliente;

/**
 *
 * @author Daniel
 */
public class Test {
    public static void main(String[] args) {
        
        
        Datos_del_Cliente vista= new Datos_del_Cliente();
        Control_Datos_Del_Cliente crl=new Control_Datos_Del_Cliente(vista);
        
        vista.setVisible(true);
    
    }
}
