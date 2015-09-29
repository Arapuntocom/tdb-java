/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.ComentarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Comentario;
import Buscador.Lucene;
import facade.ImagenFacadeLocal;
import facade.UsuarioFacadeLocal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Imagen;
import model.Usuario;

/**
 *
 * @author Aracelly
 */
@Stateless
public class BusquedaEJB implements BusquedaEJBLocal {

    static final Logger logger = Logger.getLogger(BusquedaEJB.class.getName());

    @EJB
    private ComentarioFacadeLocal comentarioFacadeLocal;

    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    
    @EJB
    private ImagenFacadeLocal imagenFacadeLocal;

    @Override
    public List<Comentario> busquedaComentarios(String texto) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "busquedaComentarios", texto);
        List<Comentario> retorno = null;
        Lucene bb = new Lucene();
        try {
            retorno = new ArrayList<>();
            String[][] resultados = bb.buscar(texto, "id_comentario", "texto_comentario", "comentario", 20, 1);

            for (String[] resultado : resultados) {
                retorno.add(comentarioFacadeLocal.find(Integer.parseInt(resultado[0])));
            }
            logger.exiting(this.getClass().getName(), "busquedaComentarios", retorno.size());
            return retorno;
        } catch (IOException ioe) {
            logger.severe("Error al buscar, IOException: " + ioe);
        } catch (SQLException sqle) {
            logger.severe("Error al buscar, SQLException: " + sqle);
        } 
        logger.exiting(this.getClass().getName(), "busquedaComentarios", null);
        return retorno;
    }

    @Override
    public List<Usuario> busquedaPersonas(String username) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "busquedaPersonas", username);
        List<Usuario> retorno = null;
        Lucene bb = new Lucene();
        try {
            retorno = new ArrayList<>();
            String[][] resultados = bb.buscar(username, "id_usuario", "username", "usuario", 20, 1);
            for (String[] resultado : resultados) {
                retorno.add(usuarioFacadeLocal.find(Integer.parseInt(resultado[0])));
            }
            logger.exiting(this.getClass().getName(), "busquedaPersonas", retorno.size());
            return retorno;
        } catch (IOException ioe) {
            logger.severe("Error al buscar, IOException: " + ioe);
        } catch (SQLException sqle) {
            logger.severe("Error al buscar, SQLException: " + sqle);
        } 
        logger.exiting(this.getClass().getName(), "busquedaPersonas", null);
        return retorno;
    }

    @Override
    public List<Imagen> busquedaImagenByPais(String texto) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "busquedaImagenByPais", texto);
        List<String> ids = imagenFacadeLocal.busquedaImagenByPais(texto);
        if(ids != null){
            List<Imagen> imagenes = new ArrayList<>();
            for(int i =0; i<ids.size(); i++){
                imagenes.add(imagenFacadeLocal.find(ids.get(i)));
            }
            logger.exiting(this.getClass().getName(), "busquedaImagenByPais", imagenes.size());
            return imagenes;
        }
        else
            logger.exiting(this.getClass().getName(), "busquedaImagenByPais", "Sin resultados");
        return null;
    }
    
}
