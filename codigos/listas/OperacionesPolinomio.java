/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class MainPolinomio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaPolinomio polinomio = new ListaPolinomio();

       //capturamos datos 
        System.out.println("Ingresa términos en formato: coeficiente exponente");
        System.out.println("Escribe 0 0 para terminar.\n");

        while (true) {
            System.out.print("Coeficiente: ");
            double coef = sc.nextDouble();

            System.out.print("Exponente: ");
            int exp = sc.nextInt();

            if (coef == 0 && exp == 0) {
                break; 
            }

            polinomio.agregarTermino(coef, exp);
        }
//evaluamos polinomio 
        System.out.println("\n=== EVALUACION ===");
        System.out.println("   x    |   P(x)");
        System.out.println("---------------------");
//mostramos resultado 
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double resultado = OperacionesPolinomio.evaluarPolinomio(polinomio, x);
            System.out.printf("  %.1f   |  %.4f\n", x, resultado);
        }

        System.out.println("\nFin del programa.");
    }
}
public class NodoPolinomio {
    double coeficiente;        
    int exponente;             
    NodoPolinomio siguiente;   

    // Constructor
    public NodoPolinomio(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }
//getter y setter 
    public double getCoeficiente() {
        return coeficiente;
    }

    public int getExponente() {
        return exponente;
    }

    public NodoPolinomio getSiguiente() {
        return siguiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public void setSiguiente(NodoPolinomio siguiente) {
        this.siguiente = siguiente;
    }
    
}

public class ListaPolinomio {
//cabeza
    private NodoPolinomio cabeza;  

    // Constructor
    public ListaPolinomio() {
        cabeza = null;
    }

    // Agregar término alfinal de nuestra lista 
    public void agregarTermino(double coef, int exp) {
        NodoPolinomio nuevo = new NodoPolinomio(coef, exp);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoPolinomio temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    // Obtener la cabeza para poder recorrer 
    public NodoPolinomio getCabeza() {
        return cabeza;
    }
}
public class OperacionesPolinomio {

    // Evaluamos el polinomio para un valor 
    public static double evaluarPolinomio(ListaPolinomio lista, double x) {
        NodoPolinomio actual = lista.getCabeza();
        double resultado = 0.0;

        while (actual != null) {
            resultado += actual.coeficiente * Math.pow(x, actual.exponente);
            actual = actual.siguiente;
        }

        return resultado;
    }
}