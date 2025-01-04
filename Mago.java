package VideojuegoRPG;

public class Mago extends Rol{

    private int mana;
    private int costoHechizo;

    public Mago(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
        this.mana = 0;
        this.costoHechizo = 20;
    }


    public int getMana(){
        return mana;
    }

    public void setMana(int mana) {
        if (mana <0){
            System.out.println("El maná no puede ser negativo");
        }else {
            this.mana = mana;
        }
    }


    @Override
    public void atacar(Rol objetivo) {
        if(!isStun()) {
            super.atacar(objetivo);
            mana += 5;
            System.out.println(getNombre() + " gana 5 de maná. Maná actual " + this.mana);
        }else{
            System.out.println(getNombre() + " está aturdido, no puede atacar.");
            setStun(false);
        }
    }

    /*
        public void atacar(Rol objetivo) {
        System.out.println(getNombre() + " ataca a " + objetivo.getNombre() + " con fuerza " + getFuerza() + "!");
        objetivo.recibirDanio(getFuerza());
    }
     */

    public void lanzarHechizo(Rol objetivo){

        if (mana >= costoHechizo){
            System.out.println(getNombre() + " lanza un hechizo a " + objetivo.getNombre() + " que le quita " + getFuerza() + "!");
            objetivo.recibirDanio(getFuerza()*2);
            mana -= costoHechizo;
            objetivo.setStun(true);
        }else{
            System.out.println(this.getNombre() + " intenta lanzar el hechizo...pero no tiene suficiente maná.");
            System.out.println(this.getNombre() + " recibe " + mana + " de daño como retroceso.");
            this.recibirDanio(mana);
            this.mana = 0;
        }
    }

    @Override
    public void recibirDanio(int cantidad) {

        int tipoGolpe = golpeCritico();

        if (tipoGolpe == 2){
            System.out.println("¡Golpe crítico!. El daño aumenta al doble" );
            cantidad *= 2;
        } else if (tipoGolpe==0) {
            System.out.println("¡Fallo crítico! " + getNombre() + " no recibe daño.");
            return;
        }

        cantidad = Math.max(cantidad, 0);

        super.setSalud(super.getSalud() - cantidad);

        super.setSalud(Math.max(super.getSalud(), 0));

        System.out.println(super.getNombre() + " recibe " + cantidad + " de daño. Salud restante:" + super.getSalud() );

        if (super.getSalud() == 0){
            System.out.println(super.getNombre() + " ha sido derrotado.");
        }
    }




}
