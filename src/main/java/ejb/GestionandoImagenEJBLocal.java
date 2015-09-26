/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
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
@Local
public interface GestionandoImagenEJBLocal {

   // public void agregarComentario(Comentario comentario);

    public void editImagen(Imagen imagen);

    public Imagen getImagen(Integer id);

    public void createImagen(Imagen imagen);
    
    public List<Comentario> getListComentarios(int idImagen);
    
    public List<Tag> getListTags(int idImagen);
    
    public List<Etiqueta> getListEtiquetas(int idImagen);
    
    public List<Favorito> getListFavoritos(int idImagen);
    
    public List<Permiso> getListPermisos(int idImagen);
    
    public int cantFavoritos(int idImagen);
    
    public List<Album> getAlbumesUsuario(int idUsuario);
    
    public List<Comentario> agregarComentario(Comentario comentario);
}
