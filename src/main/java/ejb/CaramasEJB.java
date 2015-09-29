/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Camara;

/**
 *
 * @author Aracelly
 */
@Stateless
public class CaramasEJB implements CamarasEJBLocal {
    
    static final Logger logger = Logger.getLogger(CaramasEJB.class.getName());

    @EJB
    private CamarasEJBLocal camarasEJBLocal;
    
    @Override
    public List<Camara> encontrarTodas() {
        logger.setLevel(Level.ALL);
        logger.entering(this.getClass().getName(), "encontrarTodas");
        List<Camara> retorno = camarasEJBLocal.encontrarTodas();
        if(retorno != null)
            logger.exiting(this.getClass().getName(), "encontrarTodas", retorno.size());
        else
            logger.exiting(this.getClass().getName(), "encontrarTodas", "Sin resutlados");
        return retorno;
    }
    
    
}
