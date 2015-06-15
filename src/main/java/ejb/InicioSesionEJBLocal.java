/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import model.Usuario;

/**
 *
 * @author Aracelly
 */
@Local
public interface InicioSesionEJBLocal {
    
    public Usuario iniciarSesion(Usuario iniciante);
}
