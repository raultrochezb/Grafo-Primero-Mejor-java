
package Models;

import java.util.ArrayList;
import java.util.Stack;


public class Ubicacion {
    Stack<String> lst = new Stack();

    public Stack<String> getLst() {
        return lst;
    }

    public void setLst(String lst) {
        this.lst.add(lst);
    }
    
}
