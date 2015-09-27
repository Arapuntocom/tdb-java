/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import static facade.AbstractFacade.logger;
import java.util.List;
import java.util.logging.Level;
import model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author Aracelly
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "help-tdb-ejbPU")
    private EntityManager em;   

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario getUsuario(String userName, String pass) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "getUsuario", "user: "+userName+"pass: "+pass);
        Usuario usuario = null;
        try{
            Query qq = (Query) em.createNamedQuery("Usuario.findby userName and pass", Usuario.class).setParameter("username", userName).setParameter("passUsuario", pass);
            usuario = (Usuario) qq.getSingleResult();
        }catch(IllegalArgumentException e){
            logger.severe("UsuarioFacade: el nombre o el parametro de la Query no existe -> "+e);
        }
        catch(NoResultException e){
            logger.severe("No hay resultados -> "+e);
        }
        catch(NonUniqueResultException e){
            logger.severe("hay mas de un resulado -> "+e);
        }
        catch(IllegalStateException e){
            logger.severe("UsuarioFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(QueryTimeoutException e){
            logger.severe("UsuarioFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(TransactionRequiredException e){
            logger.severe("UsuarioFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(PessimisticLockException e){
            logger.severe("UsuarioFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(LockTimeoutException e){
            logger.severe("UsuarioFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(PersistenceException e){
            logger.severe("UsuarioFacade: ocurrio un problema con la consulta -> "+e);
        }     
        
        if(usuario == null){
            logger.exiting(this.getClass().getName(), "getUsuario", null);
            return null;
        }else{
            logger.exiting(this.getClass().getName(), "getUsuario", usuario.toString());
            return usuario;
        }
    }

    @Override
    public boolean existeEmail(String emailUsuario) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "existeEmail", emailUsuario);
        List<Usuario> list = null;
        try{
            Query qq = (Query) em.createNamedQuery("Usuario.findByEmailUsuario", Usuario.class).setParameter("emailUsuario", emailUsuario);
            list = qq.getResultList();
            
        }catch(IllegalArgumentException e){
            logger.severe("el nombre o el parametro de la Query no existe -> "+e);
        }catch(IllegalStateException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(QueryTimeoutException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(TransactionRequiredException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(PessimisticLockException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(LockTimeoutException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(PersistenceException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }      
        
        if(list != null){
                if(list.isEmpty()){
                    logger.exiting(this.getClass().getName(), "existeEmail", false);
                    return false;
                }else{
                    logger.exiting(this.getClass().getName(), "existeEmail", true);
                    return true;
                }
        }
        else{
            logger.exiting(this.getClass().getName(), "existeEmail", "falla en la consulta (true)");
            return true;
        }
    }

    @Override
    public boolean existeUserName(String username) {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "existeUserName", username);
        List<Usuario> list = null;
        try{
            Query qq = (Query) em.createNamedQuery("Usuario.findByUsername", Usuario.class).setParameter("username", username);
            list = qq.getResultList();
            
        }catch(IllegalArgumentException e){
            logger.severe("el nombre o el parametro de la Query no existe -> "+e);
        }catch(IllegalStateException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(QueryTimeoutException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(TransactionRequiredException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(PessimisticLockException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(LockTimeoutException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }
        catch(PersistenceException e){
            logger.severe("ocurrio un problema con la consulta -> "+e);
        }      
        
        if(list != null){
                if(list.isEmpty()){
                    logger.exiting(this.getClass().getName(), "existeUserName", false);
                    return false;
                }else{
                    logger.exiting(this.getClass().getName(), "existeUserName", true);
                    return true;
                }
        }
        else{
            logger.exiting(this.getClass().getName(), "existeUserName", "falla en la consulta (true)");
            return true;
        }
    }
    
}
