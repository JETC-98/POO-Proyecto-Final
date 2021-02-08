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
public class Cliente {
    
    private int id;
    private String nombre;
    private String direccion;
    private String RFC;
    private int telefono;

    public Cliente(int id, String nombre, String direccion, String RFC, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.RFC = RFC;
        this.telefono = telefono;
        System.out.println("esto es una prueba");
    }
    
    
    
    
}
