/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import model.Comentario;

/**
 *
 * @author Aracelly
 */
@Local
public interface GestionandoImagenEJBLocal {

    public void agregarComentario(Comentario comentario);
}
