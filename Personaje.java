package VideojuegoRPG;

public interface Personaje {
    void atacar(Rol Objetivo);

    void recibirDanio(int cantidad);

    int golpeCritico();

    String getNombre();

    int getSalud();

    int getFuerza();



}
