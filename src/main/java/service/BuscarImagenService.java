/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.BuscarImagenEJBLocal;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import model.Imagen;
import model.Tag;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("buscarImagen")
public class BuscarImagenService {
    
    static final Logger logger = Logger.getLogger(BuscarImagenService.class.getName());
    
    @EJB
    BuscarImagenEJBLocal buscarImagenEJBLocal;
    
    @GET
    @Path("byTags")
    @Produces("application/json")
    public List<Imagen> buscarImagenByTags(List<Tag> tags){
        logger.entering(this.getClass().getName(), "buscarImagenByTags");
        List<Imagen> resultados = null;
        //resultados = buscarImagenEJBLocal.
        logger.entering(this.getClass().getName(), "buscarImagenByTags");        
        return resultados;
    }
    
    @GET
    @Path("byClasificacion")
    @Produces("application/json")
    public List<Imagen> buscarImagenByClasificacion(){
        List<Imagen> resultados = null;
        return resultados;
    }
     
    @GET
    @Produces("application/json")
    public List<Imagen> encontrarTodos() {
        List<Imagen> resultados = null;
        return resultados;
    }
}
