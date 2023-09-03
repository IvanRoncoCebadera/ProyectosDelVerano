package factories.personajesFactory;

import models.Personaje;
import models.item.Anillo;
import models.item.Carcaj;
import models.item.Vara;

import java.util.List;
import java.util.UUID;

import static utils.Utils.randomNumberGeneratorForIntegers;

public class PersonajesFactory {

    public static Personaje[] personajesGenerator(int poderMaximo, int flechasIniciales){
        Personaje[] personajes = new Personaje[3];

        personajes[0] = new Personaje(
                "Gandalf", true,
                List.of(
                        new Vara(UUID.randomUUID(), randomNumberGeneratorForIntegers(1, poderMaximo))
                )
        );

        personajes[1] = new Personaje(
                "Légolas", true,
                List.of(
                        new Carcaj(UUID.randomUUID(), randomNumberGeneratorForIntegers(1, flechasIniciales))
                )
        );

        personajes[2] = new Personaje(
                "Frodo", true,
                List.of(
                        new Anillo(UUID.randomUUID())
                )
        );

        return personajes;
    }
}
