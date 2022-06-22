
package Models;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import javafx.util.Pair;

public class Grafo {
    
    private Vertice PrimerVertice;
    private Vertice UltimoVertice;
    private double costoEn = 0;
    private Ubicacion ListaParadas;
    
    

    public Grafo(){
        PrimerVertice = null;
        UltimoVertice = null;
    }
    
    public Vertice getPrimerVertice() {
        return PrimerVertice;
    }

    public Vertice getUltimoVertice() {
        return UltimoVertice;
    }
    
    public boolean IsEmpty(){
        if(UltimoVertice == null){
            return true;
        }else{
            return false;
        }
    }
    
    public Vertice ObtenerNodo(String nombre){
        Vertice aux;
        aux = PrimerVertice;
        while(aux != null){
            if(aux.getNombreCiudad() == nombre){
                return aux;
            }
            aux = aux.getSig();
        }
        return null;
    }
    
        //Insertar

    public void InsertarVertice(String Nombre){
        Vertice nuevo = new Vertice();
        nuevo.setNombreCiudad(Nombre);
        nuevo.setAdy(null);
        nuevo.setSig(null);

        if(IsEmpty()){
            PrimerVertice = nuevo;
            UltimoVertice = nuevo;
        }else{
            UltimoVertice.setSig(nuevo);
            UltimoVertice.setAnt(UltimoVertice);
            UltimoVertice = nuevo;
        }

    }

    public void InsertarArista(Vertice origen, Vertice destino, double precio){
        Arista nuevo = new Arista();
        nuevo.setPrecio(precio);
        nuevo.setSig(null);
        nuevo.setAdy(null);

        Arista aux;
        aux = origen.getAdy();

        if(aux == null){
            nuevo.setAdy(destino);
            origen.setAdy(nuevo);  
        }else{
            while(aux.getSig() !=null){
                aux = aux.getSig();
            }
            nuevo.setAdy(destino);
            aux.setSig(nuevo);
            
        }
    }
    
    
    public void EliminarArista(Vertice origen, Vertice destino){
            int bandera = 0;
            Arista actual;
            Arista anterior = null;
            actual = origen.getAdy();

            if(actual == null){
                System.out.println("El vertice o nodo no tiene aristas");
            }else if(actual.getAdy() == destino){
                origen.setAdy(actual.getSig());
                  //se destruye actual
            }else{
                while(actual != null){
                    if(actual.getAdy() == destino){
                        bandera = 1;
                        anterior.setSig(actual.getSig());
                        //se destruye actual
                        break;
                    }
                    anterior = actual;
                    actual = actual.getSig();
                }
                if(bandera == 0){
                    System.out.println("Los vertices no estan conectados");
                }

            }	
    }

    void EliminarVertice(Vertice vert){
            Vertice actual, anterior = null;
            Arista aux;

            actual = PrimerVertice;
            while(actual != null){
                    aux = actual.getAdy();
                    while(aux != null){
                            if(aux.getAdy() == vert){
                                    EliminarArista(actual, aux.getAdy());
                                    break;
                            }
                            aux = aux.getSig();
                    }
                    actual = actual.getSig();
            }
            actual = PrimerVertice;

            if(PrimerVertice == vert){
                    PrimerVertice = PrimerVertice.getSig();
                   // delete(actual);
            }else{
                    while(actual != vert){
                            anterior = actual;
                            actual = actual.getSig();
                    }
                    
                    anterior.setSig(actual.getSig());
                   // delete(actual);
            }
    }
    
    
    //Enviar Costo

    public double getCostoEn() {
        return costoEn;
    }

    public void setCostoEn(double costoEn) {
        this.costoEn = costoEn;
    }

    public Ubicacion getListaParadas() {
        return ListaParadas;
    }

    public void setListaParadas(Ubicacion ListaParadas) {
        this.ListaParadas = ListaParadas;
    }

   
   
    
    
    
    
    
    public void RecorridoProfundidad(Vertice origen){
        int band, band2;
        Vertice actual;
        Stack<Vertice> pila = new Stack();
        ArrayList<Vertice>lista = new ArrayList();
       

        pila.push(origen);

        while(!pila.empty()){
            actual = pila.lastElement();
            pila.pop();

            band = 0;
            for(int i= 0; i!= lista.size(); i++){
                if(lista.get(i) == actual){
                    band = 1;
                }
            }

            if(band == 0){
                System.out.println(actual.getNombreCiudad()+", ");

                lista.add(actual);

                Arista aux;
                aux = actual.getAdy();

                while(aux != null){
                    band2 = 0;

                    for(int i= 0; i!= lista.size(); i++){
                            if(lista.get(i) == aux.getAdy()){
                                band2 = 1;
                            }
                    }
                    if(band2 == 0){

                       pila.push(aux.getAdy());

                    }                             
                    aux = aux.getSig();
                }
            }
        }
    }
    
    
    
    
    
    public void RecorridoAnchura(Vertice origen){
        int band, band2;
        Vertice actual;
        Queue<Vertice> cola = new LinkedList();
        ArrayList<Vertice>lista = new ArrayList();		
        cola.add(origen);

        while(!cola.isEmpty()){
            actual = cola.peek();
            cola.poll();

            band = 0;
            for(int i= 0; i!= lista.size(); i++){
                if(lista.get(i) == actual){
                    band = 1;
                }
            }

            if(band == 0){

                System.out.println(actual.getNombreCiudad()+", ");

                lista.add(actual);

                Arista aux;
                aux = actual.getAdy();

                while(aux != null){
                    band2 = 0;

                    for(int i= 0; i!= lista.size(); i++){
                        if(lista.get(i)== aux.getAdy()){
                            band2 = 1;
                        }
                    }
                    if(band2 == 0){
                        cola.add(aux.getAdy());
                    }
                    aux = aux.getSig();
                }			
            }
        }

}




public void PrimeroMejor(Vertice origen, Vertice Destino){

        // Variable Enviar
        Ubicacion drs = new Ubicacion();
        
        double costo = 0;
        double CostoActual = 0;
        int band,  band2 = 0;
        Vertice VerticeActual, DestinoActual;
        Arista aux;

        ArrayList<VerticePrecio> ListaCostos = new ArrayList();
        ArrayList<VerticePrecio> ListaOrdenada = new ArrayList();;

        Stack<VerticeVertice> pila = new Stack();

        ListaCostos.add(new VerticePrecio(origen,0));
        ListaOrdenada.add(new VerticePrecio(origen,0));

        while (!ListaOrdenada.isEmpty())
        {
            VerticeActual = ListaOrdenada.get(0).getVert();
            CostoActual = ListaOrdenada.get(0).getCosto();
            ListaOrdenada.remove(0);
            
            
            

            if(VerticeActual == Destino){
                
                   
                    band2=1;
                    setCostoEn(0);
                    
                    DestinoActual = Destino;
                    System.out.println(CostoActual);
                    
                    
                    while (!pila.isEmpty())
                    {       
                            
                            
                            drs.setLst(DestinoActual.getNombreCiudad());
                            costo = costo + DestinoActual.getAdy().getPrecio();
                            
 
                           //System.out.println(DestinoActual.getNombreCiudad()+", ");
                            while (!pila.isEmpty() && pila.lastElement().getV2() != DestinoActual)
                            {
                                    pila.pop();
                            }

                            if (!pila.empty())
                            {
                                    DestinoActual = pila.lastElement().getV1();
                            }
                    }
                    
                    setCostoEn(CostoActual);
                    setListaParadas(drs);
                    
                    break;
            }

            aux = VerticeActual.getAdy();

            while (aux != null)
            {
                    band = 0;
                    CostoActual = CostoActual + aux.getPrecio();

                    for (int i = 0; i != ListaCostos.size(); i++)
                    {
                            if (aux.getAdy() == ListaCostos.get(i).getVert())
                            {

                                    band = 1;

                                    if (CostoActual < ListaCostos.get(i).getCosto())
                                    {
                                        ListaCostos.get(i).setCosto(CostoActual);

                                        for (int j = 0; j != ListaOrdenada.size(); j++)
                                        {
                                                if (ListaOrdenada.get(j).getVert() == aux.getAdy())
                                                {
                                                        ListaOrdenada.get(j).setCosto(CostoActual);
                                                }	
                                        }

                                        pila.push(new VerticeVertice(VerticeActual, aux.getAdy()));
                                        CostoActual = CostoActual - aux.getPrecio();
                                }		
                            }				
                    }
                    if (band == 0)
                    {
                            ListaCostos.add(new VerticePrecio(aux.getAdy(), CostoActual));
                            ListaOrdenada.add(new VerticePrecio(aux.getAdy(), CostoActual));
                            //ListaOrdenada.sort();
                            pila.push(new VerticeVertice(VerticeActual, aux.getAdy()));	
                            CostoActual = CostoActual - aux.getPrecio();
                    }
                    aux = aux.getSig();
            }
        }

        if (band2 == 0)
        {
            System.out.println("No se encontraron rutas");			
        }
    }
	        
}
