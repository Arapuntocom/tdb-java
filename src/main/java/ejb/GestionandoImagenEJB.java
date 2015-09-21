/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.ImagenFacadeLocal;
import java.util.Calendar;
//import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
    
    @EJB
    private ImagenFacadeLocal imagenFacadeLocal;
    
    @Override
    public void editImagen(Imagen imagen){
        logger.entering(this.getClass().toString(), "editImagen(id, imagen)");
        imagenFacadeLocal.edit(imagen);
        logger.exiting(this.getClass().toString(), "editImagen(id, imagen)");
    }
    
    @Override
    public Imagen getImagen(Integer id){
        logger.entering(this.getClass().toString(), "getImagen(id)");
        Imagen retorno = null;
        retorno = imagenFacadeLocal.find(id);
        logger.exiting(this.getClass().toString(), "getImagen(id)");
        return retorno;
    }
   
    @Override
    public void createImagen(Imagen imagen){
        logger.entering(this.getClass().toString(), "createImagen(imagen)");
        //agregar clasificacion.
        imagenFacadeLocal.create(imagen);
        logger.exiting(this.getClass().toString(), "createImagen(imagen)");
    }
    
//    @Override
//    public void agregarComentario(Comentario comentario) {
//        logger.setLevel(Level.ALL);
//        logger.entering("agregarComentarioEJB","agregarComentario");
//        comentario.setClasificacionComentario("desclasificado");
//        comentario.setFechaComentario(Calendar.getInstance().getTime());
//        
//        logger.info("fecha ->"+Calendar.getInstance().getTime());
//        //comentario.setFechaComentario(Date.from(Instant.EPOCH));
//        
//        comentario.setIdComentario(200);
//        comentario.setImagenidimagen(null);
//        comentario.setUsuarioidusuario(null);
//        /*
//        logger.log(Level.FINEST,"Clasificacion->{0}" , comentario.getClasificacionComentario());
//        logger.log(Level.FINEST,"Fecha->{0}" , comentario.getFechaComentario());
//        logger.log(Level.FINEST,"Id->{0}" , comentario.getIdComentario());
//        logger.log(Level.FINEST,"Imagen.Path->{0}" , comentario.getImagenidimagen().getPathImagen());
//        logger.log(Level.FINEST,"Texto->{0}" , comentario.getTextoComentario());
//        logger.log(Level.FINEST,"Usuario.Email->{0}" , comentario.getUsuarioidusuario().getEmailUsuario());        
//        */
//        logger.exiting("agregarComentarioEJB","agregarComentario");
//    }  

        
}
