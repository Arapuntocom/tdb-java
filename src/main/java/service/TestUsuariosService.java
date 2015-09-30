package service;

import ejb.TestUsuariosEJBLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import model.Usuario;
import model.UsuarioRegistroPost;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("usuariosTest")
public class TestUsuariosService {
    
    static final Logger logger = Logger.getLogger(TestUsuariosService.class.getName());
    
    @EJB
    private TestUsuariosEJBLocal testUsuariosEJBLocal;
    
    @GET
    @Produces("application/json")
    public List<Usuario> findAll(){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "findAll");
        List<Usuario> retorno = testUsuariosEJBLocal.encontrarTodos();
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "findAll", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "findAll", "Sin resultados.");
        return retorno;
    }
    
    @POST
    @Path("editarUsuario")
    @Consumes("application/json")
    public void edit(UsuarioRegistroPost user){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "edit", user.getIdUsuario());
        testUsuariosEJBLocal.editar(user);
        logger.exiting(this.getClass().getName(), "edit");        
    }
}
