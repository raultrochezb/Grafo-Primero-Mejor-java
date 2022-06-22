
package Models;
import java.util.Comparator;

public class Cotizar implements Comparator<VerticePrecio> {
    
     @Override
    public int compare(VerticePrecio a, VerticePrecio b) {
        
        if(a.getCosto() < b.getCosto()){
           return 0;
        }else{
            return 1;
        }
    }
}
