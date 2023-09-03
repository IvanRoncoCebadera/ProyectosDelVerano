package factories.salasFactory;

import models.cola.ColaSala;
import models.salas.Sala;
import models.salas.SalaAccion;
import models.salas.SalaMagica;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.randomNumberGeneratorForIntegers;

public class SalasFactory {

    private static int contador = 1;

    public static ColaSala randomSalasGenerator(int poderMaligno, int flechas, int enemigos){
        List<Sala> salas = new ArrayList<>();

        for (int i=0; i<36; i++){
            int random = randomNumberGeneratorForIntegers(1, 99);

            if (random >= 1 && random <= 33){
                salas.add(
                        new SalaMagica(contador++, randomNumberGeneratorForIntegers(1, poderMaligno))
                );
            }else {
                if (random >= 34 && random <= 66){
                    salas.add(
                            new SalaAccion(contador++, randomNumberGeneratorForIntegers(1, flechas), randomNumberGeneratorForIntegers(1, enemigos))
                    );
                }else {
                    salas.add(
                            new Sala(contador++)
                    );
                }
            }
        }

        return new ColaSala(salas);
    }
}
