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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import model.Comentario;

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
        
        
        
        logger.info("service: inicia creación, con objeto ComentarioPost.");
        //gestionandoImagenEJB.agregarComentario(comentario);
        logger.exiting("GestionandoImagenService", "create(Comentario)");
    }    
       
}
