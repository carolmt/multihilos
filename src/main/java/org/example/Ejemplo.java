package org.example;
public class Ejemplo implements Runnable {
    public void run() {
        for (int i = 0; i < 5 ; i++)
            System.out.println(i + " " +
                    Thread.currentThread().getName());
        System.out.println("Termina thread " +
                Thread.currentThread().getName());
    }
    public static void main (String [] args) {
        new Thread (new Ejemplo(), "Pepe").start();
        new Thread (new Ejemplo(), "Juan").start();
        System.out.println("Termina thread main");
    }
}
 /*
 public class ThreadEjemplo extends Thread {
     public ThreadEjemplo(String str) {
         super(str);
     }
     public void run() {
         for (int i = 0; i < 10 ; i++)
             System.out.println(i + " " + getName());
         System.out.println("Termina thread " + getName());
     }
     public static void main (String [] args) {
         new ThreadEjemplo("Pepe").start();
         new ThreadEjemplo("Juan").start();
         System.out.println("Termina thread main");
     }
 }*/