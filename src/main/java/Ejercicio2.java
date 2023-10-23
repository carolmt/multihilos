import java.util.Random;

/*Implementa una simulación de una carrera entre animales. Lógicamente cada hilo tendrá una prioridad
diferente, porque unos animales son más rápidos que otros. cada participante la llevará a cabo mediante un bucle
de 1000 pasadas. La carrera será cuesta arriba por una pista resbaladiza, de modo que a veces podrán resbalar y
retroceder algunas posiciones (se suspenderá durante un segundo de modo aleatorio, cada animal puede tener una probabilidad diferente de resbalar).*/
public class Ejercicio2  implements Runnable{
    Random numRandom = new Random();
    private void esperarTiempoAzar() {
        Random generador = new Random();
        int msAzar = generador.nextInt(1);
        try {
            Thread.sleep(msAzar);
        } catch (InterruptedException ex) {
            System.out.println("Fallo la espera");
        }
    }
    @Override
    public void run() {
        int probabilidad;
        for(int i = 0; i < 1000 ; i++) {
            probabilidad = numRandom.nextInt(101);
            if (probabilidad % 10 == 0) {
                System.out.println(Thread.currentThread().getName() + " ha recorrido " + i + "m pero se ha resbalado.");
                i--;
            }
        }
        System.out.println("Termina la carrera " + Thread.currentThread().getName());
        esperarTiempoAzar();
    }
    public static void main(String[] args) {
        Random numRandom = new Random();
        int probabilidad;
        boolean seResbala;
        probabilidad = numRandom.nextInt(101);

        Thread hiloCaballo = new Thread(new Ejercicio2(), "Caballo"); //enlazamos la clase thread con la clase propia.
        Thread hiloLiebre = new Thread(new Ejercicio2(), "Liebre");
        Thread hiloPerro = new Thread(new Ejercicio2(), "Perro");
        Thread hiloTortuga = new Thread(new Ejercicio2(), "Tortuga");

        hiloCaballo.setPriority(Thread.MAX_PRIORITY);
        hiloLiebre.setPriority(Thread.NORM_PRIORITY);
        hiloPerro.setPriority(Thread.NORM_PRIORITY);
        hiloTortuga.setPriority(Thread.MIN_PRIORITY);

        hiloCaballo.start();
        hiloLiebre.start();
        hiloPerro.start();
        hiloTortuga.start();
    }
}
