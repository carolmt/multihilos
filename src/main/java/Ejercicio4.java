/*Escribe una aplicación que consista en dos hilos: uno que produce elementos y los
deposita en un buffer compartido y otro que lee elementos de ese buffer o array
(consume). En todo momento ha de impedirse que el productor escriba en el buffer
sin que el consumidor haya procesado ese elemento y que el consumidor lea sin que
el productor haya puesto nada en el buffer.*/
public class Ejercicio4 {
    public static void main(String[] args) {
        Buffer contenedor = new Buffer();
        Productor produce = new Productor(contenedor);
        Consumidor consume = new Consumidor(contenedor);

        produce.start();
        consume.start();
    }
}

class Buffer {
    private int dato;
    private boolean disponible = false;

    public synchronized void put(int dato) {
        while (disponible) {
            try {
                wait(); // Espera si el dato ya está disponible
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.dato = dato;
        disponible = true;
        notify();
    }
    public synchronized int get() {
        while (!disponible) {
            try {
                wait(); // Espera si el dato no está disponible
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        disponible = false;
        notify();
        return dato;
    }
}

class Productor extends Thread {
    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.put(i);
            System.out.println("Valor del productor: " + i);
        }
    }
}

class Consumidor extends Thread {
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            int valor = buffer.get();
            System.out.println("Valor del consumidor: " + valor);
        }
    }
}