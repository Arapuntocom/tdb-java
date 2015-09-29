package ejb;

import facade.UsuarioFacadeLocal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Usuario;
import model.UsuarioRegistroPost;


/**
 * Session Bean implementation  
 */
@Stateless
public class RegistroUsuarioEJB implements RegistroUsuarioEJBLocal {
    
    static final Logger logger = Logger.getLogger(RegistroUsuarioEJB.class.getName());
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;    
        
    /**
     * agregamos un nuevo usuario a la bd.
     * @param usuarioPost
     * @return 
     */                
    @Override
    public Usuario agregarUsuario(UsuarioRegistroPost usuarioPost){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "agregarUsuario", "UsuarioRegistroPost");        
        Usuario nuevo = new Usuario();
        
        nuevo.setIdUsuario(200);        
        nuevo.setUsername(usuarioPost.getNombre_usuario());
        nuevo.setPassUsuario(""+usuarioPost.getPass());
        nuevo.setNombreUsuario(usuarioPost.getNombre());
        nuevo.setApellidoUsuario(usuarioPost.getApellido());
        nuevo.setEmailUsuario(usuarioPost.getEmail());           
        nuevo.setNumeroMovilusuario(usuarioPost.getFono());                 
        GregorianCalendar c = new GregorianCalendar(usuarioPost.getYear(), usuarioPost.getMes()-1, usuarioPost.getDia());
        Date nacimiento = new Date(c.getTimeInMillis());          
        nuevo.setFechaNacimientousuario(nacimiento);
        nuevo.setSexoUsuario(usuarioPost.getSexo());  
        nuevo.setPaisUsuario(usuarioPost.getPais());  
        nuevo.setFotosSubidas(0);
        nuevo.setCantidadAlbunes(0);                
                
        if(!usuarioFacade.existeEmail(nuevo.getEmailUsuario()) && !usuarioFacade.existeUserName(nuevo.getUsername())){            
            usuarioFacade.create(nuevo);
            logger.exiting(this.getClass().getName(), "agregarUsuario", "(a persistencia)");
            return nuevo;
        }else{
            logger.severe("RegistroUsuarioEJB: No se ha podido registrar al nuevo usuario, el userName o el email ya se encuentra registrado");
            logger.exiting(this.getClass().getName(), "agregarUsuario", "usuario o email ya registrado");
            return null;
        }         
    }    
    
}
