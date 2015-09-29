/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.AlbumFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Album;

/**
 *
 * @author Aracelly
 */
@Stateless
public class TestAlbumEJB implements TestAlbumEJBLocal {

    static final Logger logger = Logger.getLogger(TestAlbumEJB.class.getName());
    
    @EJB
    private AlbumFacadeLocal albumFacadeLocal;
    
    @Override
    public List<Album> encontrarTodos() {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "encontrarTodos");
        List<Album> retorno = albumFacadeLocal.findAll();
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "encontrarTodos", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "encontrarTodos", "Sin resutlados");
        return retorno;
    }
    
}
