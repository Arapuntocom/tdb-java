/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.CamaraFacadeLocal;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Camara;

/**
 *
 * @author Aracelly
 */
@Stateless
public class CamaraEJB implements CamaraEJBLocal {
    
    static final Logger logger = Logger.getLogger(CamaraEJB.class.getName());
    
    @EJB
    private CamaraFacadeLocal camaraFacadeLocal;
    
    @Override
    public List<Camara> getCamaras(){
        logger.entering(this.getClass().getName(), "getCamaras");
        List<Camara> retorno = camaraFacadeLocal.findAll();
        //falta rankear (mostrar las mas usadas)
        if(retorno.isEmpty()){
            logger.exiting(this.getClass().getName(), "getCamaras", false);
            return null;
        }
        logger.exiting(this.getClass().getName(), "getCamaras", true);
        return retorno;       
    }
    
    @Override
    public Camara getCamara(int id){
        logger.entering(this.getClass().getName(), "getCamara");
        Camara retorno;
        retorno = camaraFacadeLocal.find(id);
        if(retorno == null){
            logger.exiting(this.getClass().getName(), "getCamara", false);
            return null;
        }        
        logger.exiting(this.getClass().getName(), "getCamara", retorno.toString());
        return retorno;
    }
}
