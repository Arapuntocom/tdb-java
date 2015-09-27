/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author Aracelly
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    static final Logger logger = Logger.getLogger(AbstractFacade.class.getName());
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        logger.info("AbstractFacade: entidad -> "+entityClass.toString());
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
        logger.info("AbstractFacade: incia 'create(T entity)'");
        try{
            getEntityManager().persist(entity);
        }catch(EntityExistsException e){
            logger.info("AbstractFacade: la entidad ya existe.");
        }catch(IllegalArgumentException e){
            logger.info("AbstractFacade: la instancia no es una entidad.");
        }catch(TransactionRequiredException e){
            logger.info("AbstractFacade: ocurrio un error con la persistencia -> "+e);
        }
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
