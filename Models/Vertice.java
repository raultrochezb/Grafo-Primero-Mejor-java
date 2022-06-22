
package Models;

public class Vertice {
    private Vertice Sig;
    private Vertice Ant;
    private Arista Ady;
    private String NombreCiudad;

    public Vertice getSig() {
        return Sig;
    }

    public void setSig(Vertice Sig) {
        this.Sig = Sig;
    }

    public Vertice getAnt() {
        return Ant;
    }

    public void setAnt(Vertice Ant) {
        this.Ant = Ant;
    }

    public Arista getAdy() {
        return Ady;
    }

    public void setAdy(Arista Ady) {
        this.Ady = Ady;
    }

    public String getNombreCiudad() {
        return NombreCiudad;
    }

    public void setNombreCiudad(String NombreCiudad) {
        this.NombreCiudad = NombreCiudad;
    }
    
    
}
