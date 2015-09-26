/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import facade.AlbumFacadeLocal;
import facade.CamaraFacadeLocal;
import facade.ComentarioFacadeLocal;
import facade.EtiquetaFacadeLocal;
import facade.FamiliaFacadeLocal;
import facade.FavoritoFacadeLocal;
import facade.ImagenFacadeLocal;
import facade.PermisoFacadeLocal;
import facade.TagFacadeLocal;
import facade.UsuarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import model.Album;
import model.Camara;
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
@Path("generarDatos")
public class GenerarJson {
    
    @EJB
    AlbumFacadeLocal albumFacadeLocal;
    
    @EJB
    CamaraFacadeLocal camaraFacadeLocal;
    
    @EJB
    ComentarioFacadeLocal comentarioFacadeLocal;
       
    @EJB
    EtiquetaFacadeLocal etiquetaFacadeLocal;
        
    @EJB
    FavoritoFacadeLocal favoritoFacadeLocal;
    
    @EJB
    PermisoFacadeLocal permisoFacadeLocal;
    
    @EJB
    TagFacadeLocal tagFacadeLocal;
    
    @EJB
    ImagenFacadeLocal imagenFacadeLocal;
    
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    
        
    @GET
    @Path("albums")
    @Produces("application/json")
    public List<Album> albums(){
        return albumFacadeLocal.findAll();
    }
    
    @GET
    @Path("camaras")
    @Produces("application/json")
    public List<Camara> camaras(){
        return camaraFacadeLocal.findAll();
    }
    
    @GET
    @Path("comentarios")
    @Produces("application/json")
    public List<Comentario> comentarios(){
        return comentarioFacadeLocal.findAll();
    }
    
    @GET
    @Path("etiquetas")
    @Produces("application/json")
    public List<Etiqueta> etiquetas(){
        return etiquetaFacadeLocal.findAll();
    }
    
    @GET
    @Path("favoritos")
    @Produces("application/json")
    public List<Favorito> favoritos(){
        return favoritoFacadeLocal.findAll();
    }
        
    @GET
    @Path("permisos")
    @Produces("application/json")
    public List<Permiso> permisos(){
        return permisoFacadeLocal.findAll();
    }
    
    @GET
    @Path("tags")
    @Produces("application/json")
    public List<Tag> tags(){
        return tagFacadeLocal.findAll();
    }
    
    @GET
    @Path("imagenes")
    @Produces("application/json")
    public List<Imagen> imagenes(){
        return imagenFacadeLocal.findAll();
    }
        
}
