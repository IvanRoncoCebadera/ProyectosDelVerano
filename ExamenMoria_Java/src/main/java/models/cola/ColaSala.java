package models.cola;

import lombok.AllArgsConstructor;
import lombok.Data;
import models.salas.Sala;

import java.util.List;

@Data
@AllArgsConstructor
public class ColaSala implements Cola<Sala> {

    public List<Sala> salas;

    public boolean quedanSalas(){
        return !salas.isEmpty();
    }

    public int salasRestantes(){
        return salas.size();
    }

    @Override
    public void insert(Sala entity) {
        salas.add(entity);
    }

    /**
     * función que nos pasa a la siguiente sala
     * @return nos devuelve o una sala o un nulo, si es un nulo, se acaba la simulación
     */
    @Override
    public Sala getOut() {
        try {
            return salas.remove(0);
        } catch (Exception e){
            return null;
        }
    }
}
