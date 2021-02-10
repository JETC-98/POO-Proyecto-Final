/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Control.Control_Editar_Producto;
import vistas.Editar_Producto;

/**
 *
 * @author Daniel
 */
public class Test {
    public static void main(String[] args){
    
        Editar_Producto vista=new Editar_Producto();
        Control_Editar_Producto crl=new Control_Editar_Producto(vista);
        
        vista.setVisible(true);
    }
}
