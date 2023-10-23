/*Realiza de nuevo el programa del ejercicio1, pero en este caso sincroniza el acceso a
dicha variable.¿Qué diferencias se aprecia en el resultado frente al ejercicio1? Puedes
usar la clase AtomicInteger*/
public class Ejercicio3 implements Runnable{
    static int cont;
    public Ejercicio3(int cont) {
        this.cont = cont;
    }
    public static synchronized void incrementar(){
        cont=cont+1;
    }
    public synchronized int getCont(){
        return cont;
    }

    @Override
    public void run() {
        for(int i = 0; i < 500 ; i++) {
            Ejercicio3.incrementar();
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