
import Control.Control_login;
import vistas.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author black
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Login login=new Login();
        Control_login clogin=new Control_login(login);
        login.setVisible(true);
    }
    
}
