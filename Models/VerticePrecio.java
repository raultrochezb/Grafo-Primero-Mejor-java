
package Models;

public class VerticePrecio {
     private Vertice vert;
    private double costo;

    public VerticePrecio(Vertice vert, double costo) {
        this.vert = vert;
        this.costo = costo;
    }
    
   
    public Vertice getVert() {
        return vert;
    }

    public void setVert(Vertice vert) {
        this.vert = vert;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
   
}
