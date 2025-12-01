/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class UndoManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Crear pila de acciones con tamaño suficiente
        PilaAcciones pila = new PilaAcciones(100);

        while (true) {

            System.out.print("Accion (UNDO/FIN): ");
            String accion = sc.nextLine();

            // Terminar el programa
            if (accion.equalsIgnoreCase("FIN")) {
                break;
            }

            // Deshacer la ultima accion
            if (accion.equalsIgnoreCase("UNDO")) {
                if (!pila.pilaVacia()) {
                    pila.desapilar();
                }
            } else { // Apilar nueva accion
                pila.apilar(accion);
            }

            // Mostrar acciones actuales
            String[] actual = pila.getDatos();
            System.out.print("Actual: [");
            for (int i = 0; i < actual.length; i++) {
                System.out.print(actual[i]);
                if (i < actual.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}




public class PilaAcciones {

    private int frente;
    private int fin;
    private int tam;
    private int cantidad;
    private String[] datos;

    public PilaAcciones(int tam) {
        this.tam = tam;
        datos = new String[tam];
        frente = 0;
        fin = -1;
        cantidad = 0;
    }

    // Verifica si la pila esta vacia
    public boolean pilaVacia() {
        return cantidad == 0;
    }

    // Verifica si la pila esta llena
    public boolean pilaLlena() {
        return cantidad == tam;
    }

    // Apila una accion
    public void apilar(String accion) {
        if (!pilaLlena()) {
            fin++;
            datos[fin] = accion;
            cantidad++;
        }
    }

    // Desapila la ultima accion
    public String desapilar() {
        if (!pilaVacia()) {
            String x = datos[fin];
            fin--;
            cantidad--;
            return x;
        }
        return null;
    }

    // Devuelve arreglo 
    public String[] getDatos() {
        String[] actual = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            actual[i] = datos[i];
        }
        return actual;
    }

    // setter y getter 

    public int getFrente() {
        return frente;
    }

    public int getFin() {
        return fin;
    }

    public int getTam() {
        return tam;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }
   
}

