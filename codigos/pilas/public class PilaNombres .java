/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilaNombres pila = new PilaNombres(100); 
        String nombre;

        while (true) {
            System.out.print("Ingrese un nombre : ");
            nombre = sc.nextLine();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            pila.apilar(nombre);
        }

        System.out.println("\nNombres en orden inverso:");

        while (!pila.pilaVacia()) {
            System.out.println(pila.desapilar());
        }
    }
}


public class PilaNombres {

    private int frente;     
    private int fin;        
    private int tam;        
    private int cantidad;   
    private String[] datos; 
//pila
    public PilaNombres(int tam) {
        this.tam = tam;
        datos = new String[tam];
        frente = 0;
        fin = -1;
        cantidad = 0;
    }
//verificar si esta llena 
    public boolean pilaLlena() {
        return cantidad == tam;
    }
//checar si esta vaia 
    public boolean pilaVacia() {
        return cantidad == 0;
    }

    // Operación PUSH
    public void apilar(String nombre) {
        if (!pilaLlena()) {
            fin++;
            datos[fin] = nombre;
            cantidad++;
        }
    }

    // Operación POP
    public String desapilar() {
        if (!pilaVacia()) {
            String nombre = datos[fin];
            fin--;
            cantidad--;
            return nombre;
        }
        return null;
    }

    // setter y getter 
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

    // 
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

    public String[] getDatos() {
        return datos;
    }
}

