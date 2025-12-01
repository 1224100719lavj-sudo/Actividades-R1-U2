/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
public class MainSuper {

    public static void main(String[] args) {

        Supermercado sm = new Supermercado();

        sm.llegadaCliente();
        sm.llegadaCliente();
        sm.llegadaCliente();

        sm.procesarCaja(0);
        sm.procesarCaja(1);
        sm.procesarCaja(2);

        sm.llegadaCliente();
        sm.llegadaCliente();
    }
}

//---------------------------------------------
public class Cola2 {

    private int[] datos;
    private int frente;
    private int fin;
    private int tam;
    private int cantidad;

    public Cola2(int tam) {
        this.tam = tam;
        this.datos = new int[tam];
        this.frente = 0;
        this.fin = -1;
        this.cantidad = 0;
    }

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

    

    public void insertar(int valor) {
        if (estaLlena()) {
            System.out.println("Cola llena, no se puede insertar.");
            return;
        }
        fin = (fin + 1) % tam;
        datos[fin] = valor;
        cantidad++;
    }

    public int moverIndice() {
        if (estaVacia()) {
            System.out.println("Cola vacía, no se puede quitar.");
            return -1;
        }
        int valor = datos[frente];
        frente = (frente + 1) % tam;
        cantidad--;
        return valor;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == tam;
    }
}

//--------------------------------------------
public class Carrito {

    private int id;

    public Carrito(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

//------------------------------------
public class Cliente {

    private int id;

    public Cliente(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
///////////////////////////////////
public class Supermercado {

    private final Cola2 carritos;        
    private final Cola2 esperaCarritos;  
    private final Caja[] cajas;         
    private int contadorClientes = 1;
//metoo poara los carritos al cliente 
    public Supermercado() {
        carritos = new Cola2(25);
        for (int i = 1; i <= 25; i++) {
            carritos.insertar(i);
        }

        esperaCarritos = new Cola2(200);

        cajas = new Caja[3];
        for (int i = 0; i < 3; i++) {
            cajas[i] = new Caja(i + 1, 200);
        }
    }
//metodo para marcar la llegada del cliente 
    public void llegadaCliente() {
        int idCliente = contadorClientes++;

        if (carritos.estaVacia()) {
            System.out.println("Cliente " + idCliente + " espera un carrito.");
            esperaCarritos.insertar(idCliente);
        } else {
            int idCarrito = carritos.moverIndice();
            System.out.println("Cliente " + idCliente + " toma el carrito " + idCarrito);
            enviarACaja(idCliente);
        }
    }
//metodo para enviar cliente a caja 
    private void enviarACaja(int idCliente) {
        int index = cajaConMenosClientes();
        cajas[index].agregarCliente(idCliente);
        System.out.println("Cliente " + idCliente + " se forma en la caja " + (index + 1));
    }
//indicar cual tiene menos clientes 
    private int cajaConMenosClientes() {
        int menor = 0;

        for (int i = 1; i < 3; i++) {
            if (cajas[i].getColaClientes().getCantidad() <
                cajas[menor].getColaClientes().getCantidad()) {
                menor = i;
            }
        }
        return menor;
    }

    public void procesarCaja(int index) {
        int idCliente = cajas[index].atenderCliente();
        if (idCliente != -1) {
            System.out.println("Cliente " + idCliente + " pago en caja " + (index + 1));

            carritos.insertar(idCliente); // libera carrito (por id del cliente)

            if (!esperaCarritos.estaVacia()) {
                int clienteEsperando = esperaCarritos.moverIndice();
                System.out.println("Cliente " + clienteEsperando + " por fin recibe un carrito.");
                enviarACaja(clienteEsperando);
            }
        }
    }
}

//-----------------------------------------------------------
