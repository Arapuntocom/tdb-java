/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.UsuarioFacadeLocal;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Usuario;

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
    public void editar(Usuario usuario){
        logger.info("editar usuario id->"+usuario.getIdUsuario());
        usuarioFacade.edit(usuario);
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
