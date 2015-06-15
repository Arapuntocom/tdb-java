/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.ImagenFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Imagen;

@Stateless
public class TestImagenesEJB implements TestImagenesEJBLocal {

    static final Logger logger = Logger.getLogger(TestUsuariosEJB.class.getName());
    
    @EJB
    private ImagenFacadeLocal imagenFacade;
    
    @Override
    public void editar(Imagen imagen) {
        logger.log(Level.INFO, "editar imagen id->{0}", imagen.getIdImagen());
        imagenFacade.edit(imagen);
    }

    @Override
    public Imagen encontrarId(int id) {
        logger.log(Level.INFO, "encontrarId usuario id->{0}", id);        
        return imagenFacade.find(id);
    }

    @Override
    public List<Imagen> encontrarTodos() {
        logger.info("encontrar todas");
        return imagenFacade.findAll();
    }

    @Override
    public int cantidad() {
        logger.info("contar");
        return imagenFacade.count();
    }    

    @Override
    public void crear(Imagen imagen) {
        logger.info("crear imagen");
        imagenFacade.create(imagen);
    }
    
    
}
