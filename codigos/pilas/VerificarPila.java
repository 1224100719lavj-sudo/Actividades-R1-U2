/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        PilaEnteros pila = new PilaEnteros(10);

        // 1. Verificacion real
        if (pila.pilaVacia()) {
            System.out.println("La pila esta vacia.");
        } else {
            System.out.println("La pila NO esta vacia.");
        }

        // Insertar un elemento
        pila.apilar(1);

        //  Verificacion
        if (pila.pilaVacia()) {
            System.out.println("La pila esta vacia.");
        } else {
            System.out.println("La pila NO esta vacia.");
        }
    }
}





public class PilaEnteros {

    private int frente;
    private int fin;
    private int tam;
    private int cantidad;
    private int[] datos;

    public PilaEnteros(int tam) {
        this.tam = tam;
        this.datos = new int[tam];
        this.frente = 0;
        this.fin = -1;
        this.cantidad = 0;
    }

    //operaciones 
//verificar pila 
    public boolean pilaVacia() {
        return cantidad == 0;
    }
//si esta llena 
    public boolean pilaLlena() {
        return cantidad == tam;
    }
//apilar 
    public void apilar(int valor) {
        if (!pilaLlena()) {
            fin++;
            datos[fin] = valor;
            cantidad++;
        }
    }
//desapilasr
    public int desapilar() {
        if (!pilaVacia()) {
            int valor = datos[fin];
            fin--;
            cantidad--;
            return valor;
        }
        return -1; 
    }

   //getter y setter 

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
}


