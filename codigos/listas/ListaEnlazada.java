/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class MainLista {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        //generar una lista aleatoria de elementos 
        System.out.println(" 10 NUMEROS ALEATORIOS...");
        for (int i = 0; i < 10; i++) {//desde 1 hasta 100 
            int num = (int)(Math.random() * 100) + 1; 
            lista.insertarFinal(num);
        }

        //mostrar la lista que se creo 
        lista.recorrer();

        //agregamos un limmite y eliminamos lo sque lo exedan 
        System.out.print("\nIngresa un valor limite para eliminar: ");
        int limite = sc.nextInt();

        lista.eliminarMayores(limite);

        // Mostrar lista final
        System.out.println("\nLista despues de eliminar mayores a " + limite + ":");
        lista.recorrer();
    }
}
//-----------------------------------------
public class ListaEnlazada {
//nodo cabeza 
    private Nodo inicio; 

    public ListaEnlazada() {
        inicio = null;
    }

    //agregamos un nuevo nodo al final 
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo temp = inicio;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
        }
    }

    //recorremos la lista 
    public void recorrer() {
        Nodo temp = inicio;

        if (temp == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.println("Contenido de la lista:");
        while (temp != null) {
            System.out.print("[" + temp.getDato() + "] -> ");
            temp = temp.getSiguiente();
        }
        System.out.println("null");
    }

   //eliminar nodo que exeda el limite 
    public void eliminarMayores(int limite) {

        //borrar duplicados 
        while (inicio != null && inicio.getDato() > limite) {
            inicio = inicio.getSiguiente();
        }

        Nodo actual = inicio;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.getDato() > limite) {
                anterior.setSiguiente(actual.getSiguiente());
                actual = actual.getSiguiente();
            } else {
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }
    }

  //getter y setter
    
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getInicio() {
        return inicio;
    }
}
//00000000000000000000000000000000000000000000000000000000000000000000
public class Nodo {


    private int dato;        
    private Nodo siguiente;  


   //constructor de la clase 

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }


   //getter y setter 

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}
