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
public class Usuario {
    
    private int id;
    private String nombre;
    private boolean admin;
    private String password;

    public Usuario(int id, String nombre, boolean admin, String password) {
        this.id = id;
        this.nombre = nombre;
        this.admin = admin;
        this.password = password;
    }
    
    
    
}
