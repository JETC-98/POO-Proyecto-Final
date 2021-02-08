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
public class Producto {
    
    private int id;
    private String nombre;
    private int cantidad;
    private float costo_Compra;
    private float costo_Venta;

    public Producto(int id, String nombre, int cantidad, float costo_Compra, float costo_Venta) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo_Compra = costo_Compra;
        this.costo_Venta = costo_Venta;
    }
    
    
    
}
