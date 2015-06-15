/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.TestComentariosEJBLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Comentario;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("comentariosTest")
public class TestComentariosService {
    
    static final Logger logger = Logger.getLogger(TestComentariosService.class.getName());
       
    @EJB
    TestComentariosEJBLocal testComentariosEJBLocal;
    
    @POST
    @Consumes("application/json")
    public void create(Comentario comentario) {
        testComentariosEJBLocal.crear(comentario);
    }
    
    @POST
    @Path("{idImagen}/{idUsuarioComenta}/{descripcion}")
    @Consumes("application/json")
    public void create(@PathParam("idImagen") Integer idImagen,
            @PathParam("idUsuarioComenta") Integer idUsuarioComenta, 
            @PathParam("descripcion") String descripcion) {
        
        testComentariosEJBLocal.crear(descripcion, idUsuarioComenta, idImagen);
    }    
        
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Integer id, Comentario comentario) {
        logger.log(Level.INFO, "edit por id->{0}", id);
        testComentariosEJBLocal.editar(comentario);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Comentario find(@PathParam("id") Integer id) {
        logger.log(Level.INFO, "consulta por id->{0}", id);
        return testComentariosEJBLocal.encontrarId(id);
    }

    @GET
    @Produces("application/json")
    public List<Comentario> findAll() {
        logger.info("findAll");
        return testComentariosEJBLocal.encontrarTodos();
    }

    
    @GET
    @Path("count")
    @Produces("text/plain")
    public int countREST() {
        return testComentariosEJBLocal.cantidad();
    } 
}
