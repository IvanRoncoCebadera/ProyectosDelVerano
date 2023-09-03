package models.salas;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sala {
    public int numeroSala;

    @Override
    public String toString() {
        return "SalaHabilidad{" +
                "numeroSala=" + numeroSala +
                '}';
    }
}
