/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.GestionandoImagenEJBLocal;
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
import model.Album;
import model.Comentario;
import model.Etiqueta;
import model.Favorito;
import model.Imagen;
import model.Permiso;
import model.Tag;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("gestionandoImagen")
public class GestionandoImagenService {
    
    @EJB
    private GestionandoImagenEJBLocal gestionandoImagenEJB;
    
    static final Logger logger = Logger.getLogger(GestionandoImagenService.class.getName());
      
    @PUT
    @Consumes("application/json")
    public void editImagen(Imagen imagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().toString(), "editImagen(imagen)");
        gestionandoImagenEJB.editImagen(imagen);
        logger.exiting(this.getClass().toString(), "editImagen(imagen)");
    }   
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Imagen getImagen(@PathParam("id") Integer id){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().toString(), "getImagen(id)");
        Imagen retorno = gestionandoImagenEJB.getImagen(id);
        logger.exiting(this.getClass().toString(), "getImagen(id)");
        return retorno;    
    }
    
    @POST
    @Consumes("application/json")
    public void createImagen(Imagen imagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().toString(), "createImagen(imagen)");
        gestionandoImagenEJB.createImagen(imagen);       
        logger.exiting(this.getClass().toString(), "createImagen(imagen)");
    }
    
    
    @GET
    @Path("comentarios")
    @Produces("application/json")
    public List<Comentario> getListComentarios(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListComentarios", idImagen);
        List<Comentario> retorno = gestionandoImagenEJB.getListComentarios(idImagen);
        logger.exiting(this.getClass().getName(), "getListComentarios", retorno.size());
        return retorno;        
    }
    
    @GET
    @Path("tags")
    @Produces("application/json")
    public List<Tag> getListTags(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListTags", idImagen);
        List<Tag> retorno = gestionandoImagenEJB.getListTags(idImagen);
        logger.exiting(this.getClass().getName(), "getListTags", retorno.size());
        return retorno;        
    }
    
    @GET
    @Path("etiquetas")
    @Produces("application/json")
    public List<Etiqueta> getListEtiquetas(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListEtiquetas", idImagen);
        List<Etiqueta> retorno = gestionandoImagenEJB.getListEtiquetas(idImagen);
        logger.exiting(this.getClass().getName(), "getListEtiquetas", retorno.size());
        return retorno;        
    }
    
    @GET
    @Path("favoritos")
    @Produces("application/json")
    public List<Favorito> getListFavoritos(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListFavoritos", idImagen);
        List<Favorito> retorno = gestionandoImagenEJB.getListFavoritos(idImagen);
        logger.exiting(this.getClass().getName(), "getListFavoritos", retorno.size());
        return retorno;        
    }
    
    @GET
    @Path("permisos")
    @Produces("application/json")
    public List<Permiso> getListPermisos(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListPermisos", idImagen);
        List<Permiso> retorno = gestionandoImagenEJB.getListPermisos(idImagen);
        logger.exiting(this.getClass().getName(), "getListPermisos", retorno.size());
        return retorno;        
    }
    
    @GET
    @Path("favoritos/count")
    @Produces("application/json")
    public int getCantFavoritos(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getCantFavoritos", idImagen);
        int retorno = gestionandoImagenEJB.cantFavoritos(idImagen);
        logger.exiting(this.getClass().getName(), "getCantFavoritos", retorno);
        return retorno;        
    }
    
    @GET
    @Path("albumes") //para obtener todos los albumes de un usuario.
    @Produces("application/json")
    public List<Album> getListAlbumes(int idUsuario){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListAlbumes", idUsuario);
        List<Album> retorno = gestionandoImagenEJB.getAlbumesUsuario(idUsuario);
        logger.exiting(this.getClass().getName(), "getListAlbumes", retorno.size());
        return retorno;
    }
    
    
    @GET
    @Path("{id}/comentarios")
    @Produces("application/json")
    public List<Comentario> getListComentarios(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListComentarios", idImagen);
        List<Comentario> retorno = gestionandoImagenEJB.getListComentarios(idImagen);
        logger.exiting(this.getClass().getName(), "getListComentarios", retorno.size());
        return retorno;        
    }    
    
    @GET
    @Path("{id}/tags")
    @Produces("application/json")
    public List<Tag> getListTags(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListTags", idImagen);
        List<Tag> retorno = gestionandoImagenEJB.getListTags(idImagen);
        logger.exiting(this.getClass().getName(), "getListTags", retorno.size());
        return retorno;        
    }
    
    @GET
    @Path("{id}/etiquetas")
    @Produces("application/json")
    public List<Etiqueta> getListEtiquetas(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListEtiquetas", idImagen);
        List<Etiqueta> retorno = gestionandoImagenEJB.getListEtiquetas(idImagen);
        logger.exiting(this.getClass().getName(), "getListEtiquetas", retorno.size());
        return retorno;        
    }
    
    @GET
    @Path("{id}/favoritos")
    @Produces("application/json")
    public List<Favorito> getListFavoritos(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListFavoritos", idImagen);
        List<Favorito> retorno = gestionandoImagenEJB.getListFavoritos(idImagen);
        logger.exiting(this.getClass().getName(), "getListFavoritos", retorno.size());
        return retorno;        
    }
    
    @GET
    @Path("{id}/permisos")
    @Produces("application/json")
    public List<Permiso> getListPermisos(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListPermisos", idImagen);
        List<Permiso> retorno = gestionandoImagenEJB.getListPermisos(idImagen);
        logger.exiting(this.getClass().getName(), "getListPermisos", retorno.size());
        return retorno;        
    }
    
    @GET
    @Path("{id}/favoritos/count")
    @Produces("application/json")
    public int getCantFavoritos(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getCantFavoritos", idImagen);
        int retorno = gestionandoImagenEJB.cantFavoritos(idImagen);
        logger.exiting(this.getClass().getName(), "getCantFavoritos", retorno);
        return retorno;        
    }
     
    @GET
    @Path("{idUsuario}/albumes") //para obtener todos los albumes de un usuario.
    @Produces("application/json")
    public List<Album> getListAlbumes(@PathParam("idUsuario") Integer idUsuario){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListAlbumes", idUsuario);
        List<Album> retorno = gestionandoImagenEJB.getAlbumesUsuario(idUsuario);
        logger.exiting(this.getClass().getName(), "getListAlbumes", retorno.size());
        return retorno;
    }
    
    @POST
    @Path("newComentario")
    @Consumes("application/json")
    public void create(Comentario comentario) {   
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "create", comentario.getTextoComentario());
       /* logger.log(Level.FINEST,"Clasificacion->{0}" , comentario.getClasificacionComentario());
        logger.log(Level.FINEST,"Fecha->{0}" , comentario.getFechaComentario());
        logger.log(Level.FINEST,"Id->{0}" , comentario.getIdComentario());
        logger.log(Level.FINEST,"Imagen.Path->{0}" , comentario.getImagenidimagen().getPathImagen());
        logger.log(Level.FINEST,"Texto->{0}" , comentario.getTextoComentario());
        logger.log(Level.FINEST,"Usuario.Email->{0}" , comentario.getUsuarioidusuario().getEmailUsuario());            
        
        logger.info("service: inicia creación, con objeto Comentario.");
        //gestionandoImagenEJB.agregarComentario(comentario);
        */
        logger.exiting("GestionandoImagenService", "create(Comentario)");
    }
}
