/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.ComentarioFacadeLocal;
import facade.ImagenFacadeLocal;
import facade.UsuarioFacadeLocal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
//import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Album;
import model.Comentario;
import model.Etiqueta;
import model.Favorito;
import model.Imagen;
import model.Permiso;
import model.Tag;
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

    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;

    @EJB
    private ClasificadorWekaLocal clasificadorWekaLocal;
    
    @EJB
    private ComentarioFacadeLocal comentarioFacadeLocal;

    @Override
    public void editImagen(Imagen imagen) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().toString(), "editImagen(id, imagen)");
        imagenFacadeLocal.edit(imagen);
        logger.exiting(this.getClass().toString(), "editImagen(id, imagen)");
    }

    @Override
    public Imagen getImagen(Integer id) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().toString(), "getImagen(id)");
        Imagen retorno = null;
        retorno = imagenFacadeLocal.find(id);
        if(retorno != null)
            logger.exiting(this.getClass().toString(), "getImagen(id)", retorno.toString());
        else
            logger.exiting(this.getClass().toString(), "getImagen(id)", "No se encuentra imagen "+id);
        return retorno;
    }

    @Override
    public void createImagen(Imagen imagen) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().toString(), "createImagen(imagen)");
        //agregar clasificacion.
        imagenFacadeLocal.create(imagen);
        logger.exiting(this.getClass().toString(), "createImagen(imagen)");
    }

    @Override
    public List<Comentario> getListComentarios(int idImagen) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListComentarios", idImagen);
        Imagen imagen = imagenFacadeLocal.find(idImagen);
        List<Comentario> retorno = null;
        if (imagen != null) {
            retorno = imagen.getComentarioList();
            if (retorno != null) {
                if (!retorno.isEmpty()) {
                    logger.exiting(this.getClass().getName(), "getListComentarios", retorno.size());
                    return retorno;
                }
            }
        }
        logger.exiting(this.getClass().getName(), "getListComentarios", idImagen);
        return retorno;
    }

    @Override
    public List<Tag> getListTags(int idImagen) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListTags", idImagen);
        Imagen imagen = imagenFacadeLocal.find(idImagen);
        List<Tag> retorno = null;
        if (imagen != null) {
            retorno = imagen.getTagList();
            if (retorno != null) {
                if (!retorno.isEmpty()) {
                    logger.exiting(this.getClass().getName(), "getListTags", retorno.size());
                    return retorno;
                }
            }
        }
        logger.exiting(this.getClass().getName(), "getListTags", idImagen);
        return retorno;
    }

    @Override
    public List<Etiqueta> getListEtiquetas(int idImagen) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListEtiquetas", idImagen);
        Imagen imagen = imagenFacadeLocal.find(idImagen);
        List<Etiqueta> retorno = null;
        if (imagen != null) {
            retorno = imagen.getEtiquetaList();
            if (retorno != null) {
                if (!retorno.isEmpty()) {
                    logger.exiting(this.getClass().getName(), "getListEtiquetas", retorno.size());
                    return retorno;
                }
            }
        }
        logger.exiting(this.getClass().getName(), "getListEtiquetas", idImagen);
        return retorno;
    }

    @Override
    public List<Favorito> getListFavoritos(int idImagen) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListFavoritos", idImagen);
        Imagen imagen = imagenFacadeLocal.find(idImagen);
        List<Favorito> retorno = null;
        if (imagen != null) {
            retorno = imagen.getFavoritoList();
            if (retorno != null) {
                if (!retorno.isEmpty()) {
                    logger.exiting(this.getClass().getName(), "getListFavoritos", retorno.size());
                    return retorno;
                }
            }
        }
        logger.exiting(this.getClass().getName(), "getListFavoritos", idImagen);
        return retorno;
    }

    @Override
    public List<Permiso> getListPermisos(int idImagen) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getListPermisos", idImagen);
        Imagen imagen = imagenFacadeLocal.find(idImagen);
        List<Permiso> retorno = null;
        if (imagen != null) {
            retorno = imagen.getPermisoList();
            if (retorno != null) {
                if (!retorno.isEmpty()) {
                    logger.exiting(this.getClass().getName(), "getListPermisos", retorno.size());
                    return retorno;
                }
            }
        }
        logger.exiting(this.getClass().getName(), "getListPermisos", idImagen);
        return retorno;
    }

    @Override
    public int cantFavoritos(int idImagen) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "cantFavoritos", idImagen);
        Imagen imagen = imagenFacadeLocal.find(idImagen);
        List<Favorito> listaFavoritos = null;
        int retorno = 0;
        if (imagen != null) {
            listaFavoritos = imagen.getFavoritoList();
            if (listaFavoritos != null) {
                retorno = listaFavoritos.size();
                logger.exiting(this.getClass().getName(), "cantFavoritos", retorno);
                return retorno;

            }
        }
        logger.exiting(this.getClass().getName(), "cantFavoritos", idImagen);
        return retorno;
    }

    @Override
    public List<Album> getAlbumesUsuario(int idUsuario) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getAlbumesUsuario", idUsuario);
        Usuario usuario = usuarioFacadeLocal.find(idUsuario);
        List<Album> retorno = null;
        if (usuario != null) {
            retorno = usuario.getAlbumList();
            if (retorno != null) {
                if (!retorno.isEmpty()) {
                    logger.exiting(this.getClass().getName(), "getAlbumesUsuario", retorno.size());
                    return retorno;
                }
            }
        }
        logger.exiting(this.getClass().getName(), "getAlbumesUsuario", idUsuario);
        return retorno;
    }
       
    @Override
    public List<Comentario> agregarComentario(Comentario comentario) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "agregarComentario");
        int clasificacion = 69;
        /*try {
        clasificacion = clasificadorWekaLocal.clasificar(comentario.getTextoComentario());
        } catch (Exception ex) {
        Logger.getLogger(GestionandoImagenEJB.class.getName()).log(Level.SEVERE, "Error, no se pudo clasificar ", ex);
        }*/
        Imagen imagen = imagenFacadeLocal.find(comentario.getIdComentario());   // en ese campo viene el id de la imagen
        Usuario usuarioComentante = usuarioFacadeLocal.find(comentario.getClasificacionComentario());

        GregorianCalendar gc = new GregorianCalendar();
        Date fechaActual = new Date();
        fechaActual.setTime(gc.getTimeInMillis());

        if (imagen != null && usuarioComentante != null) {
            Comentario nuevo = new Comentario();
            nuevo.setClasificacionComentario(clasificacion);
            nuevo.setFechaComentario(fechaActual);
            nuevo.setIdComentario(Integer.MIN_VALUE);
            nuevo.setImagenidimagen(imagen);
            nuevo.setTextoComentario(comentario.getTextoComentario());
            nuevo.setUsuarioidusuario(usuarioComentante);
            
            comentarioFacadeLocal.create(nuevo);
            
            List<Comentario> comentarios = imagen.getComentarioList();
            
            
            logger.exiting(this.getClass().getName(), "agregarComentario", comentarios.size());
            return comentarios;
        }
        else{
            logger.exiting(this.getClass().getName(), "agregarComentario", "No se pudo agregar el comentario");
            return null;
        }
        
    }
}
