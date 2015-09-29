/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.BusquedaEJBLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Comentario;
import model.DatosBusqueda;
import model.Imagen;
import model.Usuario;


/**
 *
 * @author Aracelly
 */
@Stateless
@Path("busqueda")
public class BusquedaService {
    
    static final Logger logger = Logger.getLogger(BusquedaService.class.getName());
    
    @EJB
    private BusquedaEJBLocal busquedaEJBLocal; 
    
    @POST
    @Path("comentarios") 
    @Consumes("application/json")
    public List<Comentario> buscarComentarios(DatosBusqueda datosBusqueda){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "buscarComentariosPOST", datosBusqueda.getTexto());
        List<Comentario> retorno = busquedaEJBLocal.busquedaComentarios(datosBusqueda.getTexto());
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "buscarComentariosPOST", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "buscarComentariosPOST", "Sin resultados");
        return retorno;     
    }
    
    @GET
    @Path("comentarios/{texto}")
    @Produces("application/json")
    public List<Comentario> buscarComentarios(@PathParam("texto") String texto){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "buscarComentariosGET", texto);
        List<Comentario> retorno = busquedaEJBLocal.busquedaComentarios(texto);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "buscarComentariosGET", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "buscarComentariosGET", "Sin resultados");
        return retorno;     
    }
    
    @POST
    @Path("usuarios")
    @Consumes("application/json")
    public List<Usuario> buscarUsuariosByUsername(DatosBusqueda datosBusqueda){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "buscarUsuariosByUsernamePOST", datosBusqueda.getTexto());
        List<Usuario> retorno = busquedaEJBLocal.busquedaPersonas(datosBusqueda.getTexto());
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "buscarUsuariosByUsernamePOST", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "buscarUsuariosByUsernamePOST", "Sin resultados");
        return retorno; 
    }
    
    @GET
    @Path("usuarios/{username}")
    @Produces("application/json")
    public List<Usuario> buscarUsuariosByUsername(@PathParam("username") String username){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "buscarUsuariosByUsernamePOST", username);
        List<Usuario> retorno = busquedaEJBLocal.busquedaPersonas(username);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "buscarUsuariosByUsernamePOST", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "buscarUsuariosByUsernamePOST", "Sin resultados");
        return retorno; 
    }
    
    @POST
    @Path("imagenes")
    @Consumes("application/json")
    public List<Imagen> buscarImagenesByComentarios(DatosBusqueda datosBusqueda){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "buscarImagenesByComentarios");
        List<Imagen> retorno = busquedaEJBLocal.busquedaImagenByPais(datosBusqueda.getTexto());
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "buscarImagenesByComentarios", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "buscarImagenesByComentarios", "Sin resultados");
        return retorno; 
    }
    
    @GET
    @Path("imagenes/{pais}")
    @Produces("application/json")
    public List<Imagen> buscarImagenesByPais(@PathParam("pais") String texto){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "buscarImagenesByComentarios");
        List<Imagen> retorno = busquedaEJBLocal.busquedaImagenByPais(texto);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "buscarImagenesByComentarios", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "buscarImagenesByComentarios", "Sin resultados");
        return retorno; 
    }
}
