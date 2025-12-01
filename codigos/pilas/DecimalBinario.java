/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class MainDecimalABinario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese numero decimal: ");
        int num = sc.nextInt();

        // Creamos la pila para binarios
        PilaBinarios pila = new PilaBinarios(32); 

        // Dividir numero por 2 y apilar restos
        int n = num;
        if (n == 0) {
            pila.apilar(0);
        } else {
            while (n > 0) {
                pila.apilar(n % 2);
                n /= 2;
            }
        }

        // Desapilar para mostrar binario
        System.out.print("Binario: ");
        while (!pila.pilaVacia()) {
            System.out.print(pila.desapilar());
        }
        System.out.println();
    }
}

public class PilaBinarios {

    private int frente;
    private int fin;
    private int tam;
    private int cantidad;
    private int[] datos;

    public PilaBinarios(int tam) {
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
        return -1; // Valor por defecto si esta vacia
    }

    // getter y setter 

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

