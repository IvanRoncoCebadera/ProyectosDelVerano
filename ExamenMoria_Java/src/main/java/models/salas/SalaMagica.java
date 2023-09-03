package models.salas;

public class SalaMagica extends Sala{

    public int poderMaligno;

    public SalaMagica(int numeroSala, int poderMaligno) {
        super(numeroSala);
        this.poderMaligno = poderMaligno;
    }

    @Override
    public String toString() {
        return "SalaMagica{" +
                "poderMaligno=" + poderMaligno +
                ", numeroSala=" + numeroSala +
                '}';
    }
}
