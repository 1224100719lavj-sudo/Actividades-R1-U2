/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
public class Ejercicio1 {

    public static void main(String[] args) {

       

        PilaEstructura pila = new PilaEstructura();

        pila.push(5);
        pila.push(10);
        pila.push(15);
        pila.push(20);

        pila.pop();
        pila.pop();

        System.out.println("Contenido actual de la pila: " + pila.mostrar());
    }
}

public class PilaEstructura {

    private Pila tope; 

    public PilaEstructura() {
        tope = null;
    }

    //  insertar un valor
    public void push(int dato) {
        Pila nuevo = new Pila(dato);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    //  eliminar y devolver el tope
    public int pop() {
        if (tope == null) {
            System.out.println("La pila esta vacía, no se puede eliminar.");
            return -1;
        }
        int valor = tope.getDato();
        tope = tope.getSiguiente();
        return valor;
    }

    // Mostrar la pila 
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        java.util.Stack<Integer> aux = new java.util.Stack<>();
        Pila recorrer = tope;

        while (recorrer != null) {
            aux.push(recorrer.getDato());
            recorrer = recorrer.getSiguiente();
        }

        for (int i = 0; i < aux.size(); i++) {
            sb.append(aux.get(i));
            if (i < aux.size() - 1) sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }
}

public class Pila {

    private int dato;           
    private Pila siguiente;     

    public Pila(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Pila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Pila siguiente) {
        this.siguiente = siguiente;
    }
}

