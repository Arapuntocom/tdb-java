/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import facade.UsuarioFacadeLocal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Usuario;
import model.UsuarioRegistroPost;

/**
 *
 * @author Aracelly
 */
@Stateless
public class TestUsuariosEJB implements TestUsuariosEJBLocal {

    static final Logger logger = Logger.getLogger(TestUsuariosEJB.class.getName());
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    public TestUsuariosEJB() {
    }
    
    @Override
    public void editar(UsuarioRegistroPost usuarioPost){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "editar", usuarioPost.getIdUsuario());        
        Usuario editado = usuarioFacade.find(usuarioPost.getIdUsuario());
        if(editado != null){
            
            logger.info(usuarioPost.getApellido());
            logger.info(usuarioPost.getEmail());
            logger.info(usuarioPost.getFono());
            logger.info(usuarioPost.getNombre());
            logger.info(usuarioPost.getNombre_usuario());
            logger.info(usuarioPost.getPais());
            logger.info(usuarioPost.getPass());
            logger.info(usuarioPost.getSexo());
            
            editado.setUsername(usuarioPost.getNombre_usuario());
            editado.setNombreUsuario(usuarioPost.getNombre());
            editado.setApellidoUsuario(usuarioPost.getApellido());
            editado.setEmailUsuario(usuarioPost.getEmail());           
            editado.setNumeroMovilusuario(usuarioPost.getFono());                 
            GregorianCalendar c = new GregorianCalendar(usuarioPost.getYear(), usuarioPost.getMes()-1, usuarioPost.getDia());
            Date nacimiento = new Date(c.getTimeInMillis());          
            editado.setFechaNacimientousuario(nacimiento);
            editado.setSexoUsuario(usuarioPost.getSexo());  
            editado.setPaisUsuario(usuarioPost.getPais()); 
            
            
            //usuarioFacade.edit(editado);
            logger.exiting(this.getClass().getName(), "editar", "(a persistencia)");
        }              
        else
            logger.exiting(this.getClass().getName(), "editar", "No se pudo editar");        
    }
    
    @Override
    public Usuario encontrarId(int id){
        logger.info("encontrarId usuario id->"+id);
        return usuarioFacade.find(id);
    }
    
    @Override
    public List<Usuario> encontrarTodos(){
        logger.info("encontrarTodos");
        return usuarioFacade.findAll();
    }
    
    @Override
    public int cantidad(){
        logger.info("contar");
        return usuarioFacade.count();
    }
}
