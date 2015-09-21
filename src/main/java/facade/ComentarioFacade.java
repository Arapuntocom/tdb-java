/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Comentario;
import ejb.Clasificador;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aracelly
 */
@Stateless
public class ComentarioFacade extends AbstractFacade<Comentario> implements ComentarioFacadeLocal {
    @PersistenceContext(unitName = "alfa2PU")
    private EntityManager em;
    
    @EJB
    private Clasificador clasificador;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentarioFacade() {
        super(Comentario.class);
    }
    
    @Override
    public void create(Comentario comentario){
        try {
            comentario.setClasificacionComentario(clasificador.clasificar(comentario.getTextoComentario()));
        } catch (Exception ex) {
            Logger.getLogger(ComentarioFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.persist(comentario);
    }
    
}
