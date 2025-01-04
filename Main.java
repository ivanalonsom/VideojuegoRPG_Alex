package VideojuegoRPG;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Rol p1 = new Rol("Pepe", 100, 10);

        Mago g1 = new Mago("Olaf", 100, 70);
        Mago g2 = new Mago("Pepe", 120000, 30);


        g1.atacar(g2);
        System.out.println("---");
        g1.atacar(g2);
        System.out.println("---");
        g1.atacar(g2);
        System.out.println("---");
        g1.atacar(g2);
        System.out.println("---");
        g1.lanzarHechizo(g2);
        System.out.println("---");
        g2.atacar(g1);
    }
}
