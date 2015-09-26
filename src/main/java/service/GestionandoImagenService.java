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
        if(retorno != null)
            logger.exiting(this.getClass().toString(), "getImagen(id)", retorno.toString());
        else
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
    
    // retorna la lista de comentarios de la imagen
    @GET
    @Path("comentarios")
    @Produces("application/json")
    public List<Comentario> getListComentarios(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListComentarios", idImagen);
        List<Comentario> retorno = gestionandoImagenEJB.getListComentarios(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListComentarios", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListComentarios", "Sin resultados");
        return retorno;        
    }
    
    @GET
    @Path("tags")
    @Produces("application/json")
    public List<Tag> getListTags(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListTags", idImagen);
        List<Tag> retorno = gestionandoImagenEJB.getListTags(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListTags", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListTags", "Sin resultados");
        return retorno;        
    }
    
    @GET
    @Path("etiquetas")
    @Produces("application/json")
    public List<Etiqueta> getListEtiquetas(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListEtiquetas", idImagen);
        List<Etiqueta> retorno = gestionandoImagenEJB.getListEtiquetas(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListEtiquetas", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListEtiquetas", "Sin resultados");
        return retorno;        
    }
    
    @GET
    @Path("favoritos")
    @Produces("application/json")
    public List<Favorito> getListFavoritos(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListFavoritos", idImagen);
        List<Favorito> retorno = gestionandoImagenEJB.getListFavoritos(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListFavoritos", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListFavoritos", "Sin resultados");
        return retorno;        
    }
    
    @GET
    @Path("permisos")
    @Produces("application/json")
    public List<Permiso> getListPermisos(int idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListPermisos", idImagen);
        List<Permiso> retorno = gestionandoImagenEJB.getListPermisos(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListPermisos", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListPermisos", "Sin resultados");
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
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListAlbumes", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListAlbumes", "sin resultados");
        return retorno;
    }
    
    
    @GET
    @Path("{id}/comentarios")
    @Produces("application/json")
    public List<Comentario> getListComentarios(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListComentarios", idImagen);
        List<Comentario> retorno = gestionandoImagenEJB.getListComentarios(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListComentarios", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListComentarios", "Sin resultados");
        return retorno;        
    }    
    
    @GET
    @Path("{id}/tags")
    @Produces("application/json")
    public List<Tag> getListTags(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListTags", idImagen);
        List<Tag> retorno = gestionandoImagenEJB.getListTags(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListTags", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListTags", "Sin resultados");
        return retorno;        
    }
    
    @GET
    @Path("{id}/etiquetas")
    @Produces("application/json")
    public List<Etiqueta> getListEtiquetas(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListEtiquetas", idImagen);
        List<Etiqueta> retorno = gestionandoImagenEJB.getListEtiquetas(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListEtiquetas", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListEtiquetas", "Sin resultados");
        return retorno;        
    }
    
    @GET
    @Path("{id}/favoritos")
    @Produces("application/json")
    public List<Favorito> getListFavoritos(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListFavoritos", idImagen);
        List<Favorito> retorno = gestionandoImagenEJB.getListFavoritos(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListFavoritos", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListFavoritos", "Sin resultados");
        return retorno;        
    }
    
    @GET
    @Path("{id}/permisos")
    @Produces("application/json")
    public List<Permiso> getListPermisos(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListPermisos", idImagen);
        List<Permiso> retorno = gestionandoImagenEJB.getListPermisos(idImagen);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListPermisos", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "getListPermisos", "Sin resultados");
        return retorno;        
    }
    
    @GET
    @Path("{id}/favoritos/count")
    @Produces("application/json")
    public int getCantFavoritos(@PathParam("id") Integer idImagen){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getCantFavoritos", idImagen);
        int retorno = gestionandoImagenEJB.cantFavoritos(idImagen);
        return retorno;        
    }
     
    @GET
    @Path("{idUsuario}/albumes") //para obtener todos los albumes de un usuario.
    @Produces("application/json")
    public List<Album> getListAlbumes(@PathParam("idUsuario") Integer idUsuario){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListAlbumes", idUsuario);
        List<Album> retorno = gestionandoImagenEJB.getAlbumesUsuario(idUsuario);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "getListAlbumes", retorno.size());        
        else
            logger.exiting(this.getClass().getName(), "getListAlbumes", "Sin resultados"); 
        return retorno;
    }
    
    @POST
    @Path("addComentario")
    @Consumes("application/json")
    public List<Comentario> agregarComentario(Comentario comentario) {   
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "create", "comentante "+comentario.getClasificacionComentario()+", en la imagen "+comentario.getIdComentario());
        List<Comentario> retorno = gestionandoImagenEJB.agregarComentario(comentario);
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "create(Comentario)", retorno);
        else
            logger.exiting(this.getClass().getName(), "create(Comentario)", "Sin resultados");
        return retorno;
    }
}
