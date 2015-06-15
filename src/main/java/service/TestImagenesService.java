/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.TestImagenesEJBLocal;
import java.util.List;
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
import model.Imagen;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("imagenesTest")
public class TestImagenesService {
     static final Logger logger = Logger.getLogger(TestImagenesService.class.getName());
       
    @EJB
    TestImagenesEJBLocal testImagenesEJBLocal;
    
    @POST
    @Consumes("application/json")
    public void create(Imagen imagen) {
        testImagenesEJBLocal.crear(imagen);
    }
        
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Integer id, Imagen imagen) {
        logger.info("edit por id->"+id);
        testImagenesEJBLocal.editar(imagen);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Imagen find(@PathParam("id") Integer id) {
        logger.info("consulta por id->"+id);
        return testImagenesEJBLocal.encontrarId(id);
    }

    @GET
    @Produces("application/json")
    public List<Imagen> findAll() {
        logger.info("findAll");
        return testImagenesEJBLocal.encontrarTodos();
    }

    
    @GET
    @Path("count")
    @Produces("text/plain")
    public int countREST() {
        return testImagenesEJBLocal.cantidad();
    }    
}
