package VideojuegoRPG;

import java.util.Random;

public abstract class Rol implements Personaje{

    private String nombre;

    private int salud;

    private int fuerza;

    private boolean stun;


    public Rol(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = Math.max(salud, 0);
        this.fuerza = Math.max(fuerza, 0);
        this.stun = false;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }


    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getSalud() {
        return salud;
    }

    @Override
    public int getFuerza() {
        return fuerza;
    }


    public int golpeCritico() {
        Random random = new Random();
        return random.nextInt(3);
    }

    public boolean isStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public void atacar(Rol objetivo) {
        if (!stun) {
            System.out.println(getNombre() + " ataca a " + objetivo.getNombre() + " con fuerza " + getFuerza() + "!");
            objetivo.recibirDanio(getFuerza());
        }else {
            System.out.println(getNombre() + " está aturdido, no puede atacar.");
            this.stun = false;
        }
    }


/*  COMO EN MAGO Y GUERRERO LO MODIFICO ME LO CARGO
    @Override
    public void atacar(Rol Objetivo) {
        System.out.println("recvwsfgv ");
    }

    @Override
    public void recibirDanio(int cantidad) {

    }


 */
}
