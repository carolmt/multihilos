/*Escribe una aplicación que consista en dos hilos: uno que produce elementos y los
deposita en un buffer compartido y otro que lee elementos de ese buffer o array
(consume). En todo momento ha de impedirse que el productor escriba en el buffer
sin que el consumidor haya procesado ese elemento y que el consumidor lea sin que
el productor haya puesto nada en el buffer.*/
public class Consumidor extends Thread{
    private int IDE;

    public Consumidor( int IDE) {
        this.IDE = IDE;
    }

    public int getIDE() {
        return IDE;
    }

    public void run() {
        int value = 0, ide;
        for(int i= 0; i < 10; i++) {
            ide = Consumidor.getIDE();
            System.out.println("IDE Consumidor : "+ ide);
            System.out.println("Consumidor. get: " + value);
        }
    }
}
public class Productor extends Thread{
    private int IDE;

    public Productor( int IDE) {
        this.IDE = IDE;
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Productor. put: "+i);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
public class Ejercicio4 extends Thread{

    public static void main(String[] args) {

        Productor produce = new Productor(1);
        Consumidor consume = new Consumidor(1);

        produce.start(); //ponemos al hilo en ready
        consume.start();
    }
}