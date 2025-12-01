/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class MainPalindromo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese palabra: ");
        String palabra = sc.nextLine();

        // Crear pila para la palabra
        PilaPalindromo pila = new PilaPalindromo(palabra.length());

        // Apilar todos los caracteres
        for (char c : palabra.toCharArray()) {
            pila.apilar(c);
        }

        // Desapilar para obtener la palabra invertida
        String invertida = "";
        while (!pila.pilaVacia()) {
            invertida += pila.desapilar();
        }

        // Comparar original con invertida
        if (palabra.equalsIgnoreCase(invertida)) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }
    }
}


public class PilaPalindromo {

    private int frente;
    private int fin;
    private int tam;
    private int cantidad;
    private char[] datos;

    public PilaPalindromo(int tam) {
        this.tam = tam;
        datos = new char[tam];
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

    // Apila un caracter
    public void apilar(char c) {
        if (!pilaLlena()) {
            fin++;
            datos[fin] = c;
            cantidad++;
        }
    }

    // Desapila y devuelve un caracter
    public char desapilar() {
        if (!pilaVacia()) {
            char x = datos[fin];
            fin--;
            cantidad--;
            return x;
        }
        return '\0';
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

    public void setDatos(char[] datos) {
        this.datos = datos;
    }

    
}

