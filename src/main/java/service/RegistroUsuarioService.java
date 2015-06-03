package service;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import ejb.RegistroUsuarioEJBLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.PathParam;
import model.Usuario;
import model.UsuarioRegistroPost;

@Stateless
@Path("nuevo")
public class RegistroUsuarioService {
        
    static final Logger logger = Logger.getLogger(RegistroUsuarioService.class.getName());
       
    @EJB
    RegistroUsuarioEJBLocal registroUsuarioEJBLocal;
    
    @POST
    @Consumes("application/json")
    public void create(UsuarioRegistroPost usuarioPost) {   
        
        logger.info("Logger name->"+logger.getName());
        logger.info("service: inicia creación, con objeto UsuarioRegistroPost.");
        logger.info("service: dia->"+usuarioPost.getDia());
        logger.info("service: genero->"+usuarioPost.getSexo());
        logger.info("service: fono->"+usuarioPost.getFono());
        
        registroUsuarioEJBLocal.agregarUsuario(usuarioPost);
        //registroUsuarioEJBLocal.agregarUsuario(usuarioPost.getEmail(), usuarioPost.getPass(), usuarioPost.getPass2(), usuarioPost.getNombre(), usuarioPost.getDia(), usuarioPost.getMes(), usuarioPost.getYear(), usuarioPost.getTelefono(), usuarioPost.getGenero(), 200);
        logger.info("service: finalizada la creación.");
    }
    
    @POST
    @Consumes("application/json")
    @Path("{email}/{pass}/{pass2}/{nombre}/{dia}/{mes}/{year}/{fono}/{sexo}/{id}")
    public void create(@PathParam("email") String email,@PathParam("pass") Integer pass,
            @PathParam("pass2") Integer pass2,@PathParam("nombre") String nombre,
            @PathParam("dia") Integer dia,@PathParam("mes") Integer mes,@PathParam("year") Integer year,
            @PathParam("fono") String fono,@PathParam("sexo") String sexo,@PathParam("id") Integer id) {
        logger.info("service: inicia la creación con datos. Algunos datos son: email-> "+email+" pass-> "+pass+" nombre-> "+nombre);
        registroUsuarioEJBLocal.agregarUsuario(email, pass, pass2, nombre, dia, mes, year, fono, sexo, id);
        logger.info("service: finalizada la creación.");
    }

}
