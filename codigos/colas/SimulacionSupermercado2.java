/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
public class MainSupper2 {

    public static void main(String[] args) {

        //capacidad maximam 
        Supermercado2 sim = new Supermercado2(500);

        sim.simular();
    }
}
//---------------------------------------------
public class Cola3 {

    private int[] datos;
    private int frente;
    private int fin;
    private int tam;
    private int cantidad;

    public Cola3(int tam) {
        this.tam = tam;
        datos = new int[tam];
        frente = 0;
        fin = -1;
        cantidad = 0;
    }

    // Inserta un valor en la cola (antes enqueue)
    public void insertar(int valor) {
        if (!estaLlena()) {
            fin = (fin + 1) % tam;
            datos[fin] = valor;
            cantidad++;
        }
    }

    // Extrae elemento 
    public int moverIndice() {
        if (!estaVacia()) {
            int valor = datos[frente];
            frente = (frente + 1) % tam;
            cantidad--;
            return valor;
        }
        return -1;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == tam;
    }

    // getter y setter 

    public void setDatos(int[] datos) {
        this.datos = datos;
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

    public int[] getDatos() {
        return datos;
    }

    public int getCantidad() {
        return cantidad;
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
}
//------------------------------------------------------------------
public class Cliente2 {

    private int tiempoLlegada;
    private int tiempoEspera;
//tiempo de llegada 
    public Cliente2(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoEspera = 0;
    }

    // ggeter y setter 
    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }
}

//------------------------------------------------------------
public class Supermercado2 {

    private final Cola3 filaUnica;
    private final Caja2[] cajas;
    private final Caja2 cajaExtra;

    private int tiempoAperturaCajaExtra = -1;

    private int totalClientesAtendidos;
    private int tamMaximoFila;
    private int tiempoMaxEspera;
//para que sea aleatorio las llegadas y atencion y cambien las stats 
    private final Random rnd = new Random();

    public Supermercado2(int capacidadFila) {
        filaUnica = new Cola3(capacidadFila);

        cajas = new Caja2[3];
        for (int i = 0; i < 3; i++) {
            cajas[i] = new Caja2();
        }

        cajaExtra = new Caja2();
        cajaExtra.setActiva(false);

        totalClientesAtendidos = 0;
        tamMaximoFila = 0;
        tiempoMaxEspera = 0;
    }

    public void simular() {

        int tiempoTotal = 7 * 60; // 7 horas = 420 minutos

        for (int minuto = 0; minuto < tiempoTotal; minuto++) {

            //llega un clinete por minuto 
            Cliente2 nuevo = new Cliente2(minuto);
            filaUnica.insertar(minuto);

            if (filaUnica.getCantidad() > tamMaximoFila) {
                tamMaximoFila = filaUnica.getCantidad();
            }

            // si hay mas de 20 esperando se abre otra caja 
            if (filaUnica.getCantidad() > 20 && !cajaExtra.isActiva()) {
                cajaExtra.setActiva(true);
                tiempoAperturaCajaExtra = minuto;
                System.out.println(">> Caja extra abierta en minuto: " + minuto);
            }

            // ateder las cajas 
            for (Caja2 caja : cajas) {
                procesarCaja(caja, minuto);
            }

            // si la estra esta vacia atender 
            if (cajaExtra.isActiva()) {
                procesarCaja(cajaExtra, minuto);
            }
        }
//mostrar resultados de atencion 
        imprimirResultados();
    }

    private void procesarCaja(Caja2 caja, int minuto) {

        caja.atender();

        if (caja.estaLibre() && !filaUnica.estaVacia()) {

            int llegadaCliente = filaUnica.moverIndice();

            int espera = minuto - llegadaCliente;
            if (espera > tiempoMaxEspera) {
                tiempoMaxEspera = espera;
            }

            totalClientesAtendidos++;

            int tiempoServicio = 2 + rnd.nextInt(5); // 2–6 min
            caja.iniciarAtencion(tiempoServicio);
        }
    }
//mostrar stats de atencion 
    private void imprimirResultados() {
        System.out.println("\n===== RESULTADOS SIMULACIoN =====");
        System.out.println("Clientes atendidos: " + totalClientesAtendidos);
        System.out.println("Tamano maximo de la fila: " + tamMaximoFila);
        System.out.println("Tiempo maximo de espera: " + tiempoMaxEspera + " min");

        if (tiempoAperturaCajaExtra >= 0)
            System.out.println("La caja extra abrio en minuto: " + tiempoAperturaCajaExtra);
        else
            System.out.println("La caja extra nunca abrio.");
    }
}

//-------------------------------------------------------