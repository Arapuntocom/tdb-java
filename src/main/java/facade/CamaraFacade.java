/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Camara;

/**
 *
 * @author Aracelly
 */
@Stateless
public class CamaraFacade extends AbstractFacade<Camara> implements CamaraFacadeLocal {
    @PersistenceContext(unitName = "alfa2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CamaraFacade() {
        super(Camara.class);
    }
    
}
