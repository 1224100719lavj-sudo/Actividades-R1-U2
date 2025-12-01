/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

        System.out.println("Ingrese una cadena de texto:");
        String cadena = sc.nextLine();

        for (int i = 0; i < cadena.length(); i++) {
            lista.insertar(cadena.charAt(i));
        }

        lista.ordenar();

        System.out.println("Lista ordenada:");
        lista.mostrar();
    }
}


public class NodoDoble {

    private char caracter;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    public NodoDoble(char caracter) {
        this.caracter = caracter;
        this.anterior = null;
        this.siguiente = null;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
        
    }
    
}

public class ListaDoblementeEnlazada {

    private NodoDoble inicio;

    public ListaDoblementeEnlazada() {
        inicio = null;
        
    }

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getInicio() {
        return inicio;
    }

    // Insertar al final
    public void insertar(char c) {
        NodoDoble nuevo = new NodoDoble(c);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoDoble temp = inicio;

            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }

            temp.setSiguiente(nuevo);
            nuevo.setAnterior(temp);
        }
    }

    // Ordenamiento burbuja por caracteres
    public void ordenar() {
        if (inicio == null || inicio.getSiguiente() == null) {
            return;
        }

        boolean cambio;
        do {
            cambio = false;
            NodoDoble actual = inicio;

            while (actual.getSiguiente() != null) {
                NodoDoble sig = actual.getSiguiente();

                if (actual.getCaracter() > sig.getCaracter()) {
                    char temp = actual.getCaracter();
                    actual.setCaracter(sig.getCaracter());
                    sig.setCaracter(temp);
                    cambio = true;
                }

                actual = sig;
            }

        } while (cambio);
    }

    // Mostrar lista completa
    public void mostrar() {
        NodoDoble temp = inicio;
        while (temp != null) {
            System.out.print(temp.getCaracter() + " ");
            temp = temp.getSiguiente();
        }
        System.out.println();
    }
    
}



