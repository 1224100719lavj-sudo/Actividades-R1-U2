/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
public class MainInvertido {

    public static void main(String[] args) {

        int[] lista = {1, 2, 3, 4};

        // Crear pila para invertir lista
        PilaReversa pila = new PilaReversa(lista.length);

        // Apilar todos los elementos de la lista
        for (int n : lista) {
            pila.apilar(n);
        }

        // Desapilar e imprimir para invertir
        System.out.print("Lista invertida: ");
        while (!pila.pilaVacia()) {
            System.out.print(pila.desapilar() + " ");
        }
        System.out.println();
    }
}


public class PilaReversa {

    private int frente;
    private int fin;
    private int tam;
    private int cantidad;
    private int[] datos;

    public PilaReversa(int tam) {
        this.tam = tam;
        datos = new int[tam];
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

    // Apila un elemento
    public void apilar(int valor) {
        if (!pilaLlena()) {
            fin++;
            datos[fin] = valor;
            cantidad++;
        }
    }

    // Desapila y devuelve un elemento
    public int desapilar() {
        if (!pilaVacia()) {
            int x = datos[fin];
            fin--;
            cantidad--;
            return x;
        }
        return -1;
    }

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

    public int[] getDatos() {
        return datos;
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

    public void setDatos(int[] datos) {
        this.datos = datos;
    }

    
}

