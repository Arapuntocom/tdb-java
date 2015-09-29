/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import ejb.TestAlbumEJBLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import model.Album;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("AlbumTest")
public class TestAlbumService {
    
    static final Logger logger = Logger.getLogger(TestAlbumService.class.getName());
    
    @EJB
    private TestAlbumEJBLocal testAlbumEJBLocal;
    
    @GET
    public List<Album> findAll(){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "findAll");
        List<Album> retorno = testAlbumEJBLocal.encontrarTodos();
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "findAll", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "findAll", "Sin resultados.");
        return retorno;
    }
    
}
