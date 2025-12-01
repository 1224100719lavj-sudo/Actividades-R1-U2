/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
public class CompararColas {

    public static boolean sonIguales(Cola c1, Cola c2) {

        // coparamos tamano para ver si son o no iguales
        if (c1.size() != c2.size()) {
            return false;
        }

        // hacems  auxiliares con mismo tamaño
        Cola aux1 = new Cola(c1.getTam());
        Cola aux2 = new Cola(c2.getTam());

        boolean iguales = true;

        // extraemos y comparamos elementos 
        while (!c1.isEmpty()) {
            int v1 = c1.moverIndice();
            int v2 = c2.moverIndice();

            aux1.insertar(v1);
            aux2.insertar(v2);

            if (v1 != v2) {
                iguales = false;
            }
        }

        // restauramos las colas a su forma inicial 
        while (!aux1.isEmpty()) {
            c1.insertar(aux1.moverIndice());
            c2.insertar(aux2.moverIndice());
        }

        return iguales;
    }

    public static void main(String[] args) {

        Cola cola1 = new Cola(10);
        Cola cola2 = new Cola(10);

        cola1.insertar(1);
        cola1.insertar(2);
        cola1.insertar(3);

        cola2.insertar(1);
        cola2.insertar(2);
        cola2.insertar(3);

        cola1.mostrar();
        cola2.mostrar();

        boolean resultado = sonIguales(cola1, cola2);
        System.out.println("¿Son iguales? → " + resultado);
    }
}


