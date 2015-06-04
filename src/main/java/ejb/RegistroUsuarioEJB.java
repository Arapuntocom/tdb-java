package ejb;

import facade.UsuarioFacadeLocal;
import java.util.Date;
import java.util.logging.Handler;
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
    
    public RegistroUsuarioEJB() {
       //logger.info("RegistroUsuarioEJB: ya me construi! =D");
    }
    
    /**
     * agregamos un nuevo usuario a la bd.
     * @param usuarioPost
     */                
    @Override
    public void agregarUsuario(UsuarioRegistroPost usuarioPost){
        logger.info("RegistroUsuarioEJB: inicia la creacion de usuario, con Objeto UsuarioRegistroPost.");
        
        Usuario nuevo = new Usuario();
        
        nuevo.setEmailUsuario(usuarioPost.getEmail());     
        nuevo.setPassUsuario(""+usuarioPost.getPass());
        nuevo.setNombreUsuario(usuarioPost.getNombre());
        nuevo.setNumeroMovilusuario(usuarioPost.getFono());
        nuevo.setSexoUsuario(usuarioPost.getSexo());
        Date nacimiento = new Date(usuarioPost.getYear()-1900, usuarioPost.getMes()-1, usuarioPost.getDia());
        nuevo.setFechaNacimientousuario(nacimiento);
               
        
        nuevo.setIdUsuario(200);
        nuevo.setApellidoUsuario("ApellidoDefault");
        nuevo.setPaisUsuario("PaisDefault");        
        
        /*mostrando en el log los datos ingresados*/
        logger.log(Level.INFO, "RegistroUsuarioEJB: id->\t\t{0}", nuevo.getIdUsuario());
        logger.log(Level.INFO, "RegistroUsuarioEJB: pass->\t{0}", nuevo.getPassUsuario());
        logger.log(Level.INFO, "RegistroUsuarioEJB: nombre->\t{0}", nuevo.getNombreUsuario());
        logger.log(Level.INFO, "RegistroUsuarioEJB: apellido->\t{0}", nuevo.getApellidoUsuario());
        logger.log(Level.INFO, "RegistroUsuarioEJB: email->\t{0}", nuevo.getEmailUsuario());
        logger.log(Level.INFO, "RegistroUsuarioEJB: fono->\t{0}", nuevo.getNumeroMovilusuario());
        logger.log(Level.INFO, "RegistroUsuarioEJB: nacimiento->\t{0}", nuevo.getFechaNacimientousuario());
        logger.log(Level.INFO, "RegistroUsuarioEJB: genero->\t{0}", nuevo.getSexoUsuario());
        logger.log(Level.INFO, "RegistroUsuarioEJB: pa\u00eds->\t{0}", nuevo.getPaisUsuario());
        
        if(usuarioFacade.esNuevo(nuevo.getEmailUsuario())){
            usuarioFacade.create(nuevo);
            logger.info("RegistroUsuarioEJB: usuario creado, la cantidad de usuarios es: "+usuarioFacade.count());
        }else{
           logger.severe("RegistroUsuarioEJB: No se ha podido registrar al nuevo usuario, el email ya se encuentra registrado");
        }      
        
    }    

    @Override
    public void agregarUsuario(String email, Integer pass, Integer pass2, String nombre, Integer dia, Integer mes, Integer year, String fono, String sexo, Integer id) {
        logger.setLevel(Level.ALL);
        
        logger.entering(RegistroUsuarioEJB.class.getName(),"agregarUsuario");
        
        logger.info("RegistroUsuarioEJB: inicia la creacion de usuario, por datos.");
        
        Usuario nuevo = new Usuario();
        logger.info("RegistroUsuarioEJB: instancia a un nuevo Usuario");
        
        nuevo.setApellidoUsuario("apellido1");
        nuevo.setEmailUsuario(email);
        nuevo.setPassUsuario(""+pass);
        Date nacimiento = new Date(year-1900, mes-1, dia);
        nuevo.setFechaNacimientousuario(nacimiento);
        nuevo.setNombreUsuario(nombre);
        nuevo.setNumeroMovilusuario(""+fono);
        nuevo.setPaisUsuario("Chilito");
        nuevo.setSexoUsuario(sexo);
        nuevo.setIdUsuario(id);
        nuevo.setUsername("userNameDefault");
        
        if(nuevo.getSexoUsuario()==null){
            nuevo.setSexoUsuario("indefinidoDefault");
        }
        
        /*mostrando en el log los datos ingresados*/
        logger.log(Level.INFO, "se muestra finest->{0}", logger.isLoggable(Level.FINEST));
        
        logger.log(Level.FINEST, "RegistroUsuarioEJB: id->\t\t{0}", nuevo.getIdUsuario());
        logger.log(Level.FINEST, "RegistroUsuarioEJB: pass->\t{0}", nuevo.getPassUsuario());
        logger.log(Level.FINEST, "RegistroUsuarioEJB: nombre->\t{0}", nuevo.getNombreUsuario());
        logger.log(Level.FINEST, "RegistroUsuarioEJB: apellido->\t{0}", nuevo.getApellidoUsuario());
        logger.log(Level.FINEST, "RegistroUsuarioEJB: email->\t{0}", nuevo.getEmailUsuario());
        logger.log(Level.FINEST, "RegistroUsuarioEJB: fono->\t{0}", nuevo.getNumeroMovilusuario());
        logger.log(Level.FINEST, "RegistroUsuarioEJB: nacimiento->\t{0}", nuevo.getFechaNacimientousuario());
        logger.log(Level.FINEST, "RegistroUsuarioEJB: genero->\t{0}", nuevo.getSexoUsuario());
        logger.log(Level.FINEST, "RegistroUsuarioEJB: pa\u00eds->\t{0}", nuevo.getPaisUsuario());
        
        if(usuarioFacade.esNuevo(nuevo.getEmailUsuario())){
            usuarioFacade.create(nuevo);
            logger.info("RegistroUsuarioEJB: usuario creado, la cantidad de usuarios es: "+usuarioFacade.count());
        }else{
           logger.severe("RegistroUsuarioEJB: No se ha podido registrar al nuevo usuario, el email ya se encuentra registrado");
        }   
        logger.exiting(RegistroUsuarioEJB.class.getName(),"agregarUsuario");
    }   
    
}
