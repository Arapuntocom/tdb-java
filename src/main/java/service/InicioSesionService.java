/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.InicioSesionEJBLocal;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Usuario;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("inicio")
public class InicioSesionService {
    static final Logger logger = Logger.getLogger(InicioSesionService.class.getName());
    //logger-> service.InicioSesionService
    @EJB
    InicioSesionEJBLocal inicioSesionEJBLocal;
    
    /*Retorno Usuario, funciona bn.
    * retorna status 200 y datos de usuario encontrado.
    * retorna 204 si no se encuentra el usuario.
    */
    @POST 
    @Consumes("application/json")
    public Usuario iniciarSesion(Usuario user){
        logger.info("inicia sesion Objeto, retorno objeto");
        logger.info("User name->"+user.getUsername());
        logger.info("User pass->"+user.getPassUsuario());
        
        return inicioSesionEJBLocal.iniciarSesion(user);
    }
    
    @GET 
    @Produces("application/json")
    @Path("/{username}/{passUsuario}")
    public Usuario iniciarSes(@PathParam("username") String username, @PathParam("passUsuario") String passUsuario){
        
        System.out.println("username->"+username);
        System.out.println("pass->"+passUsuario);
        logger.info("inicia sesion GET");
       // logger.info("Get para User name->"+user.getUsername());
        //logger.info("Get para User pass->"+user.getPassUsuario());
        
        //return inicioSesionEJBLocal.iniciarSesion(user);
        Usuario a = new Usuario();
        a.setUsername(username);
        a.setPassUsuario(passUsuario);
        a.setIdUsuario(28);
        return a;
    }
    
    // con retorno String, no hace nada, status 200
    
    /*
    // tipo void, cualquier caso siempre queda el status 204, e indica que ha fallado la aplicación.    
    @POST 
    @Produces("application/json")
    public void iniciarSesion(Usuario user){
        logger.info("inicia sesion Objeto");
        logger.info("Objeto user name->"+user.getUsername());
        logger.info("Objeto user pass->"+user.getPassUsuario());
       // logger.info("id encontrado ->"+inicioSesionEJBLocal.iniciarSesion(user).getIdUsuario());
    }
    */
  
}
