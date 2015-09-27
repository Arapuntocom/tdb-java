/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import model.Favorito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aracelly
 */
@Stateless
public class FavoritoFacade extends AbstractFacade<Favorito> implements FavoritoFacadeLocal {
    @PersistenceContext(unitName = "help-tdb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FavoritoFacade() {
        super(Favorito.class);
    }
    
}
