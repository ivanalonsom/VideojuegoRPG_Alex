package VideojuegoRPG;

public class Guerrero extends Rol{

    private int armadura;

    public Guerrero(String nombre, int salud, int fuerza, int armadura) {
        super(nombre, salud, fuerza);
       this.armadura = armadura;
    }


    public int getArmadura(){
        return armadura;
    }

    public void setArmadura(int armadura) {
        if (armadura<0){
            System.out.println("La armadura no puede ser negativa");
        }else {
            this.armadura = armadura;
        }
    }


    @Override
    public void recibirDanio(int cantidad) {

        int tipoGolpe = golpeCritico();

        int danioFinal = cantidad - armadura;

        if (tipoGolpe == 2){
            System.out.println("¡Golpe crítico!. El daño aumenta al doble" );
            danioFinal *= 2;
        } else if (tipoGolpe==0) {
            System.out.println("¡Fallo crítico! " + getNombre() + " no recibe daño.");
            return;
        }

        danioFinal = Math.max(danioFinal, 0);

        System.out.println(getNombre() + " reduce el daño recibido con su armadura (" + armadura + ").");

        super.setSalud(super.getSalud() - danioFinal);

        super.setSalud(Math.max(super.getSalud(), 0));

        System.out.println(super.getNombre() + " recibe " + danioFinal + " de daño. Salud restante:" + super.getSalud() );

        if (super.getSalud() == 0){
            System.out.println(super.getNombre() + " ha sido derrotado.");
        }
    }
}
