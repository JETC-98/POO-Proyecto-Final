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
    private String marca;    
    private float costo_Compra;
    private float costo_Venta;
    private int cantidad;
    
    public Producto(int id, String nombre, int cantidad, float costo_Compra, float costo_Venta) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo_Compra = costo_Compra;
        this.costo_Venta = costo_Venta;
    }
    
    public Producto(int id,String nombre,String marca,float compra,float venta,int cantidad)
    {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;        
        this.costo_Compra = compra;
        this.costo_Venta = venta;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public float getCosto_Compra() {
        return costo_Compra;
    }

    public float getCosto_Venta() {
        return costo_Venta;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
    
}
