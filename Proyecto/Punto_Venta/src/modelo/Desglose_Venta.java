/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Daniel
 */
public class Desglose_Venta {
    
    private int id;
    private String productos;
    private int cantidad_Producto;
    private int costo;

    public Desglose_Venta(int id, String productos, int cantidad_Producto, int costo) {
        this.id = id;
        this.productos = productos;
        this.cantidad_Producto = cantidad_Producto;
        this.costo = costo;
    }
    
    
    
}
