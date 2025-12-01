/**
 *
 * @author Valencia Jantes Luis Angel 
 * 1224100719.lavj@gmail.com
 * gtid141
 */
import java.util.Scanner;


public class Principal2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaEnlazada2 lista = new ListaEnlazada2();
//archivo que va a trabajar 
        String archivo = "palabras.txt"; 

        // Leer las palabras iniciales del archivo
        ArchivoPalabras2.leerarchivo(archivo, lista);

        int opcion = 0;

        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Mostrar palabras");
            System.out.println("2. Agregar palabra");
            System.out.println("3. Eliminar palabra");
            System.out.println("4. Guardar y salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {

                case 1:
                    lista.mostrar();
                    break;

                case 2:
                    System.out.print("Nueva palabra: ");
                    String nueva = sc.nextLine();
                    lista.insertarfinal(nueva);
                    break;

                case 3:
                    System.out.print("Palabra a eliminar: ");
                    String eliminar = sc.nextLine();
                    if (lista.eliminar(eliminar)) {
                        System.out.println("Palabra eliminada.");
                    } else {
                        System.out.println("No encontrada.");
                    }
                    break;

                case 4:
                    ArchivoPalabras2.escribirarchivo(archivo, lista);
                    System.out.println("Archivo guardado. Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no válida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class ArchivoPalabras2 {

    //lee las palabras y las inserta 
    public static void leerarchivo(String nombre, ListaEnlazada2 lista) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombre));
            String linea;

            while ((linea = br.readLine()) != null) {
                String palabras[] = linea.split("\\s+");

                for (String p : palabras) {
                    if (!p.isEmpty()) {
                        lista.insertarfinal(p);
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    //escribe las palabras en el nuevo archivo 
     
    public static void escribirarchivo(String nombre, ListaEnlazada2 lista) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));

            // Escribe el ttexto
            bw.write(lista.obtenerTexto());

            bw.close();

        } catch (Exception e) {
            System.out.println("Error al escribir archivo: " + e.getMessage());
        }
    }
}

public class ListaEnlazada2 {

    private Nodo1 inicio;   // Primer nodo de la lista

   //inicializa la lista 
    public ListaEnlazada2() {
        inicio = null;
    }

    //verifica si esta vacia 
    public boolean estavacia() {
        return inicio == null;
    }

   //ingresamos un nuevo nombre 
    public void insertarfinal(String palabra) {

        Nodo1 nuevo = new Nodo1(palabra);

        if (estavacia()) {
             //si esta vacia el que agregamoc se vuelve el cabeza 
            inicio = nuevo;
        } else {
            // recorre hasta el fina 
            Nodo1 aux = inicio;
            while (aux.getsiguiente() != null) {
                aux = aux.getsiguiente();
            }
            aux.setsiguiente(nuevo);
        }
    }

   //elimina el primer nombre
    public boolean eliminar(String palabra) {

        if (estavacia()) return false;

        // eliminar el primero 
        if (inicio.getpalabra().equals(palabra)) {
            inicio = inicio.getsiguiente();
            return true;
        }

        // buscar cuel eliminar 
        Nodo1 aux = inicio;

        while (aux.getsiguiente() != null &&
               !aux.getsiguiente().getpalabra().equals(palabra)) {
            aux = aux.getsiguiente();
        }

        if (aux.getsiguiente() == null) {
            return false; // No encontrado
        }

        // salta el que se eliminara 
        aux.setsiguiente(aux.getsiguiente().getsiguiente());
        return true;
    }

    //muestra todo su contenido 
    public void mostrar() {
        Nodo1 aux = inicio;
        while (aux != null) {
            System.out.print(aux.getpalabra() + " ");
            aux = aux.getsiguiente();
        }
        System.out.println();
    }

    //devuelve las palabras 
    public String obtenerTexto() {

        StringBuilder texto = new StringBuilder();
        Nodo1 aux = inicio;

        while (aux != null) {
            texto.append(aux.getpalabra());
            if (aux.getsiguiente() != null) {
                texto.append(" "); // separar palabras
            }
            aux = aux.getsiguiente();
        }

        return texto.toString();
    }
}

public class Nodo1 {
    private String palabra;
    private Nodo1 siguiente;

    public Nodo1(String palabra) {
        this.palabra = palabra;
        this.siguiente = null;
    }

    public String getpalabra() {
        return palabra;
    }

    public void setpalabra(String palabra) {
        this.palabra = palabra;
    }

    public Nodo1 getsiguiente() {
        return siguiente;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setSiguiente(Nodo1 siguiente) {
        this.siguiente = siguiente;
    }

    public String getPalabra() {
        return palabra;
    }

    public Nodo1 getSiguiente() {
        return siguiente;
    }

    public void setsiguiente(Nodo1 siguiente) {
        this.siguiente = siguiente;
    }
}
