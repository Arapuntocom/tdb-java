/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;
import model.Usuario;

/**
 *
 * @author Aracelly
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "alfa2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    /*
    Esta funcion comprueba si el email ingresado en el parametro se encuentra
    en la base de datos.
    En caso de que el email se encuentre, retorna verdadero.
    */
    @Override
    public boolean existeEmail(String email){
        List<Usuario> list = null;
        try{
            Query qq = (Query) em.createNamedQuery("Usuario.findByEmailUsuario", Usuario.class).setParameter("emailUsuario", email);
            list = qq.getResultList();
            if(list != null){
                if(list.isEmpty()){
                    logger.info("no se encontro ningún usuario con ese email");
                    return false;
                }else{
                    logger.info("ya existe(n) usuario(s) con ese email, cantidad="+list.size());
                    return true;
                }
            }
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
        return !list.isEmpty();
    }
    
    
    /*
    Esta funcion comprueba si el user name ingresado en el parametro se encuentra
    en la base de datos.
    En caso de que el user name se encuentre, retorna verdadero.
    */
    @Override
    public boolean existeUserName(String username){
        List<Usuario> list = null;
        try{
            Query qq = (Query) em.createNamedQuery("Usuario.findByUsername", Usuario.class).setParameter("username", username);
            list = qq.getResultList();
            if(list != null){
                if(list.isEmpty()){
                    logger.info("no se encontro ningún usuario con ese username");
                    return false;
                }else{
                    logger.info("ya existe(n) usuario(s) con ese username, cantidad="+list.size());
                    return true;
                }
            }
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
        return !list.isEmpty();
    }
    
    /*
    Esta función comprueba si un usuario es nuevo mediate la comprobación de su email.
    busca una lista de usuarios con el mismo email, si dicha lista esta vacía,
    quiere decir que nadie se ha registrado con dicho email.
    retorna verdadero si la lista esta vacia. 
    */
    @Override
    public boolean esNuevo(String email){
        List<Usuario> list = null;
        try{
            Query qq = (Query) em.createNamedQuery("Usuario.findByEmailUsuario", Usuario.class).setParameter("emailUsuario", email);
            list = qq.getResultList();
            if(!list.isEmpty()){
                logger.info("UsuarioFacade: ya existe(n) usuario(s) con ese email, cantidad="+list.size());
            }else{
                logger.info("UsuarioFacade: no se encontro ningún usuario con ese email");
            }
            logger.info("UsuarioFacade: esNuevo() -> "+list.isEmpty());
        }catch(IllegalArgumentException e){
            logger.severe("UsuarioFacade: el nombre o el parametro de la Query no existe -> "+e);
        }catch(IllegalStateException e){
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
        return list.isEmpty();
    }
    
    @Override
    public Usuario getUsuario(String userName, String pass){
        
        Usuario usuario = null;
        try{
            Query qq = (Query) em.createNamedQuery("Usuario.findby userName and pass", Usuario.class).setParameter("username", userName).setParameter("passUsuario", pass);
            usuario = (Usuario) qq.getSingleResult();
            if(usuario ==null){
                logger.info("No se encuentra usuario y contraseña indicados");
            }else{
                logger.info("Se retorna el usuario de id->"+usuario.getIdUsuario());
                return usuario;
            }
        }catch(IllegalArgumentException e){
            logger.severe("UsuarioFacade: el nombre o el parametro de la Query no existe -> "+e);
        }catch(IllegalStateException e){
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
        return null;       
    }    
}
