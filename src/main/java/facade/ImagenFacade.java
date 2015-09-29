/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import static facade.AbstractFacade.logger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import model.Imagen;
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
public class ImagenFacade extends AbstractFacade<Imagen> implements ImagenFacadeLocal {
    @PersistenceContext(unitName = "help-tdb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagenFacade() {
        super(Imagen.class);
    }
    
    @Override
    public List<String> busquedaImagenByPais(String pais){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "busquedaImagenByPais");                
        List<String> ids = null;
        try{
            Query query = em.createNativeQuery("{call buscarImagenPorPais(?)}").setParameter(1, pais);
            ids = (List<String>) query.getResultList();
        }catch(IllegalArgumentException e){
            logger.severe("ImagenFacade: el nombre o el parametro de la Query no existe -> "+e);
        }
        catch(NoResultException e){
            logger.severe("ImagenFacade: No hay resultados -> "+e);
        }
        catch(IllegalStateException e){
            logger.severe("ImagenFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(QueryTimeoutException e){
            logger.severe("ImagenFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(TransactionRequiredException e){
            logger.severe("ImagenFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(PessimisticLockException e){
            logger.severe("ImagenFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(LockTimeoutException e){
            logger.severe("ImagenFacade: ocurrio un problema con la consulta -> "+e);
        }
        catch(PersistenceException e){
            logger.severe("ImagenFacade: ocurrio un problema con la consulta -> "+e);
        }
        if(ids != null)
            logger.exiting(this.getClass().getName(), "busquedaImagenByPais", ids.size());
        else
            logger.exiting(this.getClass().getName(), "busquedaImagenByPais", "Sin resultados");
        return ids;        
    }
}

