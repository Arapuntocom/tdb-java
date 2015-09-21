/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.IOException;

/**
 *
 * @author Aracelly
 */
public interface Clasificador {
    
    public String clasificar(String texto) throws IOException, Exception;
}
