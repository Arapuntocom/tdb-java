/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.TestUsuariosEJBLocal;
import facade.AlbumFacadeLocal;
import facade.UsuarioFacadeLocal;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Album;
import model.Usuario;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("usuariosTest")
public class TestUsuariosService {
    
    static final Logger logger = Logger.getLogger(TestUsuariosService.class.getName());
       
    @EJB
    TestUsuariosEJBLocal testUsuariosEJBLocal;
    
    @EJB
    UsuarioFacadeLocal UsuarioFacadeLocal;
    
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Integer id, Usuario usuario) {
        logger.info("edit por id->"+id);
        testUsuariosEJBLocal.editar(usuario);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Usuario find(@PathParam("id") Integer id) {
        logger.info("consulta por id->"+id);
        return testUsuariosEJBLocal.encontrarId(id);
    }

    @GET
    @Produces("application/json")
    public List<Usuario> findAll() {
        logger.info("findAll");
        return testUsuariosEJBLocal.encontrarTodos();
    }

    
    @GET
    @Path("count")
    @Produces("text/plain")
    public int countREST() {
        return testUsuariosEJBLocal.cantidad();
    }
    
    @GET
    @Path("albumes")
    @Produces("application/json")
    public List<Album> albumesUser(){
        int idUser = 5;
        Usuario user = UsuarioFacadeLocal.find(idUser);        
        if(user!=null){
            List<Album> retorno = user.getAlbumList();
            if(retorno.isEmpty()){
                return null;
            }
            else{
                return retorno;
            }
        }else{            
            return null;
        }       
    }
    
}
