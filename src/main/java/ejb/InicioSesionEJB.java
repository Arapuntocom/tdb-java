/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.UsuarioFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Usuario;

/**
 *
 * @author Aracelly
 */
@Stateless
public class InicioSesionEJB implements InicioSesionEJBLocal{
    
    static final Logger logger = Logger.getLogger(InicioSesionEJB.class.getName());
    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;   
    
    @Override
    public Usuario iniciarSesion(Usuario iniciante){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "iniciarSesion", iniciante.toString());
        String userName = iniciante.getUsername();
        String pass =  iniciante.getPassUsuario();
        iniciante = usuarioFacadeLocal.getUsuario(userName, pass);
        if(iniciante != null){
            logger.exiting(this.getClass().getName(), "iniciarSesion", iniciante.toString());
            return iniciante;
        }else{
            logger.exiting(this.getClass().getName(), "iniciarSesion", "Usuario NO encontrado");
            return null;
        } 
        
    }
}
