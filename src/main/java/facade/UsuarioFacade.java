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
    
}
