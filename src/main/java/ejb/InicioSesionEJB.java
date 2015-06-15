/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.UsuarioFacadeLocal;
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
    private UsuarioFacadeLocal usuarioFacade;

    public InicioSesionEJB() {
        
    }   
    
    
    @Override
    public Usuario iniciarSesion(Usuario iniciante){
        String userName = iniciante.getUsername();
        String pass =  iniciante.getPassUsuario();
        iniciante = usuarioFacade.getUsuario(userName, pass);
        if(iniciante != null){
            logger.info("Usuario encontrado, id->"+iniciante.getIdUsuario());
            return iniciante;
        }else{
            logger.info("Usuario No encontrado");
            return null;
        }       
    }
}
