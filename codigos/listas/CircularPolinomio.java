/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class MainCircularPolinomio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCircularPolinomio polinomio = new ListaCircularPolinomio();

        System.out.println("Ingresa coeficiente y exponente.");
        System.out.println("Introduce 0 0 para terminar.\n");

        while (true) {

            double coef = leerDouble(sc, "Coeficiente: ");
            int exp = leerInt(sc, "Exponente: ");

            if (coef == 0 && exp == 0) {
                break;
            }

            polinomio.insertarTermino(coef, exp);
        }

        System.out.println("\n=== RECORRIDO CIRCULAR ===");
        polinomio.recorrerLista();

        System.out.println("\nFin del programa.");
    }

  
    private static int leerInt(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
            System.out.println(" Error: debes escribir un número entero.");
            sc.next(); // limpiar entrada incorrecta
        }
    }

    // Lee doubles 
    private static double leerDouble(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            }
            System.out.println(" Error: debes escribir un numero real.");
            sc.next(); // limpiar entrada incorrecta
        }
    }
}

public class ListaCircularPolinomio {

    private NodoCircularPolinomio ultimo; // Referencia al último nodo

    public ListaCircularPolinomio() {
        ultimo = null;
    }

    // Insertar término al final 
    public void insertarTermino(double coef, int exp) {
        NodoCircularPolinomio nuevo = new NodoCircularPolinomio(coef, exp);

        if (ultimo == null) {
            // Lista vacía → el nodo se apunta a sí mismo
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            // Insertar después del último
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo; // El nuevo pasa a ser el último
        }
    }

    // Recorrido circular, iniciando desde el primero
    public void recorrerLista() {
        if (ultimo == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoCircularPolinomio actual = ultimo.siguiente; // Primer nodo
        NodoCircularPolinomio inicio = actual;

        do {
            System.out.println("Coef: " + actual.getCoeficiente() +
                               ", Exp: " + actual.getExponente());
            actual = actual.siguiente;
        } while (actual != inicio);
    }

    // Getter del último nodo
    public NodoCircularPolinomio getUltimo() {
        return ultimo;
    }
}
public class NodoCircularPolinomio {

    private double coeficiente;       
    private int exponente;            
    NodoCircularPolinomio siguiente;  
    
    public NodoCircularPolinomio(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }

    public NodoCircularPolinomio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircularPolinomio siguiente) {
        this.siguiente = siguiente;
    }

   
    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public int getExponente() {
        return exponente;
    }
}

