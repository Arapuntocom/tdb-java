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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Comentario;
import model.Imagen;
import model.Usuario;

@Stateless
public class TestComentariosEJB implements TestComentariosEJBLocal {

    static final Logger logger = Logger.getLogger(TestComentariosEJB.class.getName());
    
    @EJB
    private ComentarioFacadeLocal comentarioFacade;
    
    @EJB
    private ImagenFacadeLocal imagenFacade;
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    @Override
    public void editar(Comentario comentario) {
        logger.log(Level.INFO, "editar comentario id->{0}", comentario.getIdComentario());
        comentarioFacade.edit(comentario);
    }

    @Override
    public Comentario encontrarId(int id) {
        logger.log(Level.INFO, "encontrar comentario id->{0}", id);
        return comentarioFacade.find(id);
    }

    @Override
    public List<Comentario> encontrarTodos() {
        logger.info("encontrar todos");
        return comentarioFacade.findAll();
    }

    @Override
    public int cantidad() {
        logger.info("contar");
        return comentarioFacade.count();
    }

    @Override
    public void crear(Comentario comentario) {
        logger.info("crear comentario por Objeto");
        comentario.setClasificacionComentario("Neutro");
        comentarioFacade.create(comentario);
    }
        
    @Override
    public void crear(String descripcion, int idUsuarioComenta, int idImagen){
        logger.info("crear comentario por Datos");
        Usuario usuarioComenta = usuarioFacade.find(idUsuarioComenta);
        Imagen imagenComentada = imagenFacade.find(idImagen);
                
        if(usuarioComenta != null && imagenComentada != null){
            
            Comentario nuevo = new Comentario();

            nuevo.setUsuarioidusuario(usuarioFacade.find(idUsuarioComenta));
            nuevo.setImagenidimagen(imagenFacade.find(idImagen));

            nuevo.setClasificacionComentario("Positivo");

            
            Date fechaComentario = new Date(); //fecha y hora actual del sistema 
                        
            nuevo.setFechaComentario(fechaComentario);
                        
            nuevo.setIdComentario(3);

            nuevo.setTextoComentario(descripcion);

            comentarioFacade.create(nuevo);
            
            logger.info("comentario ingresado");
            
        }
        if(usuarioComenta == null){
            logger.severe("no se encontro el usuario");
        }
        if(imagenComentada == null){
            logger.severe("no se encontro la imagen");
        }   
        
        logger.info("fin crear comentario por Datos");
    }
}
