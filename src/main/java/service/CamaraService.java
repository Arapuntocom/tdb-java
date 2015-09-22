/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.CamaraEJBLocal;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Camara;

/**
 *
 * @author Aracelly
 */
@Stateless
@Path("CamaraService")
public class CamaraService {
    
    static final Logger logger = Logger.getLogger(CamaraService.class.getName());
    
    @EJB
    private CamaraEJBLocal camaraEJBLocal;
    
    @GET
    @Produces("application/json")
    public List<Camara> getCamaras(){
        logger.entering(this.getClass().getName(), "getCamaras");
        List<Camara> retorno = camaraEJBLocal.getCamaras();
        if(retorno.isEmpty()){
            logger.exiting(this.getClass().getName(), "getCamaras", false);
            return null;
        }
        logger.exiting(this.getClass().getName(), "getCamaras");
        return retorno;       
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Camara getCamara(@PathParam("id") Integer id){
        logger.entering(this.getClass().getName(), "getCamara", id);
        Camara retorno = null;
        retorno = camaraEJBLocal.getCamara(id);
        logger.exiting(this.getClass().getName(), retorno.toString());
        return retorno;
    }
}
