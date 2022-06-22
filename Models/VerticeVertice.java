
package Models;


public class VerticeVertice {
      public VerticeVertice(Vertice v1, Vertice v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    private Vertice v1 = null;
    private Vertice v2 = null;

    public Vertice getV1() {
        return v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }
    
}
