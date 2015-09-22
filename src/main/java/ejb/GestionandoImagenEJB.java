/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.sql.Date;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Comentario;
import model.Imagen;
import model.Usuario;

/**
 *
 * @author Aracelly
 */
@Stateless
public class GestionandoImagenEJB implements GestionandoImagenEJBLocal {

    static final Logger logger = Logger.getLogger(GestionandoImagenEJB.class.getName());
    
    @Override
    public void agregarComentario(Comentario comentario) {
        logger.setLevel(Level.ALL);
        logger.entering("agregarComentarioEJB","agregarComentario");
        comentario.setClasificacionComentario("desclasificado");
        comentario.setFechaComentario(Date.from(Instant.EPOCH));
        
        comentario.setIdComentario(200);
        comentario.setImagenidimagen(null);
        comentario.setUsuarioidusuario(null);
        /*
        logger.log(Level.FINEST,"Clasificacion->{0}" , comentario.getClasificacionComentario());
        logger.log(Level.FINEST,"Fecha->{0}" , comentario.getFechaComentario());
        logger.log(Level.FINEST,"Id->{0}" , comentario.getIdComentario());
        logger.log(Level.FINEST,"Imagen.Path->{0}" , comentario.getImagenidimagen().getPathImagen());
        logger.log(Level.FINEST,"Texto->{0}" , comentario.getTextoComentario());
        logger.log(Level.FINEST,"Usuario.Email->{0}" , comentario.getUsuarioidusuario().getEmailUsuario());        
        */
        logger.exiting("agregarComentarioEJB","agregarComentario");
    }  


    
}
