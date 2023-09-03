package models.salas;

public class SalaAccion extends Sala{

    public int flechas;

    public int enemigos;

    public SalaAccion(int numeroSala, int flechas, int enemigos) {
        super(numeroSala);
        this.enemigos = enemigos;
        this.flechas = flechas;
    }

    @Override
    public String toString() {
        return "SalaAccion{" +
                "flechas=" + flechas +
                ", enemigos=" + enemigos +
                ", numeroSala=" + numeroSala +
                '}';
    }
}
