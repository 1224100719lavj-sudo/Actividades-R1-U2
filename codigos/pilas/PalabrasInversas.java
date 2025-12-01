/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();

        // Crear pila del tamaño de la palabra
        PilaCaracteres pila = new PilaCaracteres(palabra.length());

        //  Apilar cada letra
        for (int i = 0; i < palabra.length(); i++) {
            pila.apilar(palabra.charAt(i));
        }

        //  Desapilar e imprimir
        System.out.print("Invertida: ");
        while (!pila.pilaVacia()) {
            System.out.print(pila.desapilar());
        }

        System.out.println();
    }
}





public class PilaCaracteres {

    private int frente;
    private int fin;
    private int tam;
    private int cantidad;
    private final char[] datos;

    public PilaCaracteres(int tam) {
        this.tam = tam;
        this.datos = new char[tam];
        this.frente = 0;
        this.fin = -1;
        this.cantidad = 0;
    }

   //operaciones 

    //si esta vacioa 
    public boolean pilaVacia() {
        return cantidad == 0;
    }
//cuando esta llena 
    public boolean pilaLlena() {
        return cantidad == tam;
    }
//para apilar 
    public void apilar(char c) {
        if (!pilaLlena()) {
            fin++;
            datos[fin] = c;
            cantidad++;
        }
    }
//desapilar 
    public char desapilar() {
        if (!pilaVacia()) {
            char c = datos[fin];
            fin--;
            cantidad--;
            return c;
        }
        return '\0'; 
    }

  //setter y getter 

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

    public char[] getDatos() {
        return datos;
    }
}

