/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Favorito;

/**
 *
 * @author Aracelly
 */
@Stateless
public class FavoritoFacade extends AbstractFacade<Favorito> implements FavoritoFacadeLocal {
    @PersistenceContext(unitName = "alfa2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FavoritoFacade() {
        super(Favorito.class);
    }
    
}
