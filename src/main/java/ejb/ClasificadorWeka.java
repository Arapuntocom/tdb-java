/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import classifier.ClassifierSentiment;
import clean.NormalizerTweets;
import clean.SimpleTokenizer;
import clean.StopWordsRemoval;
import clean.Tokenizer;
import java.io.IOException;
import java.util.Locale;
import javax.ejb.Stateless;

/**
 *
 * @author Aracelly
 */
@Stateless
public class ClasificadorWeka implements ClasificadorWekaLocal {

    @Override
    public int clasificar(String texto) throws IOException, Exception {
        NormalizerTweets normalizer = new NormalizerTweets();
        Tokenizer tokenizer = new SimpleTokenizer(new Locale("ES"));
        StopWordsRemoval stopWordsRemoval = new StopWordsRemoval();
        String clasificador = "svm.model";
        String atributos = "attrs.dat";        
        String content;
        content = texto;
        ClassifierSentiment clasificado = new ClassifierSentiment(clasificador, atributos, normalizer, tokenizer, stopWordsRemoval);
        double clasificacion = clasificado.classify(content);
        String resultado = clasificado.aString(clasificacion);
        switch (resultado) {
            case "Negativo":
                return -1;
            case "Positivo":
                return 1;
            case "Neutro":
                return 0;
            default:
                return 7;
        }
    }

//    public static void main(String args[]) {
//    ClasificadorWeka nn = new ClasificadorWeka();
//    String comentario = "te felicitico, muy buen trabajo";
//        try {
//            System.out.println("La clasificacion de '" + comentario + "' es -> " + nn.clasificar(comentario));
//        } catch (Exception ex) {
//           // Logger.getLogger(ClasificadorWeka.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("No se puede clasificar: "+ex);
//        }
//    }

}
