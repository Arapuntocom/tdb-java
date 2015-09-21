/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.GestionandoImagenEJBLocal;
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
import model.Imagen;
import static service.TestImagenesService.logger;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("gestionandoImagen")
public class GestionandoImagenService {
    
    @EJB
    private GestionandoImagenEJBLocal gestionandoImagenEJB;
    
    static final Logger logger = Logger.getLogger(GestionandoImagenEJBLocal.class.getName());
      
    @PUT
    @Consumes("application/json")
    public void editImagen(Imagen imagen){
        logger.entering(this.getClass().toString(), "editImagen(imagen)");
        gestionandoImagenEJB.editImagen(imagen);
        logger.exiting(this.getClass().toString(), "editImagen(imagen)");
    }   
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Imagen getImagen(@PathParam("id") Integer id){
        logger.entering(this.getClass().toString(), "getImagen(id)");
        Imagen retorno = gestionandoImagenEJB.getImagen(id);
        logger.exiting(this.getClass().toString(), "getImagen(id)");
        return retorno;    
    }
    
    @POST
    @Consumes("application/json")
    public void createImagen(Imagen imagen){
        logger.entering(this.getClass().toString(), "createImagen(imagen)");
        gestionandoImagenEJB.createImagen(imagen);       
        logger.exiting(this.getClass().toString(), "createImagen(imagen)");
    }
    
    
    /*  
    @POST
    @Consumes("application/json")
    public void create(Comentario comentario) {   
        logger.setLevel(Level.ALL);
        logger.entering("GestionandoImagenService", "create(Comentario)");
        logger.log(Level.FINEST,"Clasificacion->{0}" , comentario.getClasificacionComentario());
        logger.log(Level.FINEST,"Fecha->{0}" , comentario.getFechaComentario());
        logger.log(Level.FINEST,"Id->{0}" , comentario.getIdComentario());
        logger.log(Level.FINEST,"Imagen.Path->{0}" , comentario.getImagenidimagen().getPathImagen());
        logger.log(Level.FINEST,"Texto->{0}" , comentario.getTextoComentario());
        logger.log(Level.FINEST,"Usuario.Email->{0}" , comentario.getUsuarioidusuario().getEmailUsuario());            
        
        logger.info("service: inicia creación, con objeto Comentario.");
        //gestionandoImagenEJB.agregarComentario(comentario);
        logger.exiting("GestionandoImagenService", "create(Comentario)");
    }    
    */
}
