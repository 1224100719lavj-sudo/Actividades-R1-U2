/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
public class EvaluarPostFija {

    
    public static int evaluar(String expr) {

        PilaEnterosPostfija pila = new PilaEnterosPostfija(100);

        // Separar tokens por espacio
        for (String token : expr.split(" ")) {

            // Si es numero, apilar
            if (token.matches("\\d+")) {
                pila.apilar(Integer.parseInt(token));
            } else { // Es operador
                int b = pila.desapilar();
                int a = pila.desapilar();

                switch (token) {
                    case "+": pila.apilar(a + b); break;
                    case "-": pila.apilar(a - b); break;
                    case "*": pila.apilar(a * b); break;
                    case "/": pila.apilar(a / b); break;
                }
            }
        }

        return pila.desapilar(); // Resultado final
    }

    public static void main(String[] args) {
        String expr = "5 3 + 8 2 - *";
        int resultado = evaluar(expr);
        System.out.println("Resultado: " + resultado);
    }
}





public class PilaEnterosPostfija {

    private int frente;
    private int fin;
    private int tam;
    private int cantidad;
    private int[] datos;

    public PilaEnterosPostfija(int tam) {
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

    // Apila un valor
    public void apilar(int valor) {
        if (!pilaLlena()) {
            fin++;
            datos[fin] = valor;
            cantidad++;
        }
    }

    // Desapila y devuelve un valor
    public int desapilar() {
        if (!pilaVacia()) {
            int x = datos[fin];
            fin--;
            cantidad--;
            return x;
        }
        return -1;
    }

    // GETTERS Y SETTERS 

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

