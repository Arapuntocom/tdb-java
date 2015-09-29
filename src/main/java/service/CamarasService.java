/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.CamarasEJBLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import model.Camara;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("camaras")
public class CamarasService {
    
    static final Logger logger = Logger.getLogger(CamarasService.class.getName());
    
    @EJB
    private CamarasEJBLocal camaraEJBLocal;
    
    @GET
    public List<Camara> findAll(){
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "findAll");
        List<Camara> retorno = camaraEJBLocal.encontrarTodas();
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "findAll", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "findAll", "Sin resultados.");
        return retorno;
    }
    
}
