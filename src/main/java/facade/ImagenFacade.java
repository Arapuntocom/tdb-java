/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import model.Imagen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
