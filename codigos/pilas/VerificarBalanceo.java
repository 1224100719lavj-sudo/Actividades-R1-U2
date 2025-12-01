/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;

public class MainBalanceo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Crear instancias de las pilas
        PilaParentesis pila = new PilaParentesis(); 
        Balanceo balanceo = new Balanceo();

        // Menu de opciones
        System.out.println("1. Verificar parentesis");
        System.out.println("2. Verificar balanceo completo");
        System.out.print("Elige una opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine(); 

        // Solicitar datos 
        System.out.print("Ingresa la expresion: ");
        String cadena = sc.nextLine();

        // Opciones
        if (opcion == 1) {
            boolean r = pila.verificar(cadena);
            if (r) {
                System.out.println("Parentesis balanceados");
            } else {
                System.out.println("Parentesis no balanceados");
            }
        }

       
        if (opcion == 2) {
            boolean r = balanceo.validar(cadena);
            if (r) {
                System.out.println("Expresion balanceada");
            } else {
                System.out.println("Expresion no balanceada");
            }
        }
    }
}



public class NodoPar {
    private char simbolo;       
    private NodoPar siguiente;  

    public NodoPar(char simbolo) {
        this.simbolo = simbolo;
        this.siguiente = null;
    }

    // Getter y Setter 
    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public NodoPar getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPar siguiente) {
        this.siguiente = siguiente;
    }
    

public class PilaParentesis {

    private NodoPar cima; 

    public PilaParentesis() {
        cima = null;
    }

    // Apila un simbolo en la cima de la pila
    public void apilar(char simbolo) {
        NodoPar nuevo = new NodoPar(simbolo);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    // Desapila y devuelve el simbolo de la cima
    public char desapilar() {
        if (cima == null) {
            return '\0';
        }
        char x = cima.getSimbolo();
        cima = cima.getSiguiente();
        return x;
    }

    // Verifica si la pila esta vacia
    public boolean vacia() {
        return cima == null;
    }

    // Metodo que verifica si los parentesis estan balanceados
    public boolean verificar(String cadena) {
        for (char c : cadena.toCharArray()) {
            if (c == '(') {
                apilar(c);          
            } else if (c == ')') {
                if (vacia()) {      
                    return false;
                }
                desapilar();      
            }
        }
        return vacia();             
    }
}


public class Balanceo {

    private NodoPar cima;

    public Balanceo() {
        cima = null;
        
    }

    public void setCima(NodoPar cima) {
        this.cima = cima;
    }

    public NodoPar getCima() {
        return cima;
    }

    // Apila un simbolo
    public void push(char simbolo) {
        NodoPar nuevo = new NodoPar(simbolo);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    // Desapila un simbolo
    public char pop() {
        if (cima == null) {
            return '\0';
        }
        char x = cima.getSimbolo();
        cima = cima.getSiguiente();
        return x;
    }

    // Verifica si la pila esta vacia
    public boolean empty() {
        return cima == null;
    }

    // Verifica si dos simbolos son pareja correcta
    private boolean esPareja(char abre, char cierra) {
        return (abre == '(' && cierra == ')')
            || (abre == '[' && cierra == ']')
            || (abre == '{' && cierra == '}');
    }

    // Metodo principal para validar balanceo completo
    public boolean validar(String cadena) {
        for (char c : cadena.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                push(c);               
            } else if (c == ')' || c == ']' || c == '}') {
                if (empty()) {         
                    return false;
                }
                char superior = pop();   
                if (!esPareja(superior, c)) {  
                    return false;
                }
            }
        }
        return empty();  // Si pila vacia, todo balanceado
    }
}
