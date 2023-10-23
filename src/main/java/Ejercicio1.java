/*Implementa un programa que lance cuatro threads, cada uno incrementará 500 veces
una variable contador de tipo entero, compartida por todos los hilos y luego saldrá.
¿Obtiene el resultado correcto?*/
public class Ejercicio1 implements Runnable{
    int cont;
    public Ejercicio1(int cont) {
        this.cont = cont;
    }

    public int getCont() {
        return cont;
    }

    @Override
    public void run() {
        for(int i = 0; i < 500 ; i++) {
            cont++;
            System.out.println(cont + " " + Thread.currentThread().getName());
        }
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }
    public static void main (String[] args) {
        for(int i = 0; i <= 3 ; i++) // for inicia del 0, entonces tenemos del hilo 0 al 3.
            new Thread(new Ejercicio1(0),"Hilo"+i).start();
        System.out.println("Termina thread main");
    }
}
