package org.example;

import models.Informe;
import models.Personaje;
import models.cola.ColaSala;
import models.item.Anillo;
import models.item.Carcaj;
import models.item.Vara;
import models.salas.Sala;
import models.salas.SalaAccion;
import models.salas.SalaMagica;
import storage.json.InformeStorageJSON;
import storage.txt.InformeStorageTXT;
import storage.xml.InformeStorageXML;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static factories.personajesFactory.PersonajesFactory.personajesGenerator;
import static factories.salasFactory.SalasFactory.randomSalasGenerator;
import static utils.Utils.randomNumberGeneratorForIntegers;
import static validator.Validator.validateProgramArgs;

public class Main {

    private static final int posMago = 0;
    private static final int posElfo = 1;
    private static final int posHobbit = 2;

    public static void main(String[] args) throws InterruptedException, IOException {

        List<Integer> valores = validateProgramArgs(args);

        simulacion(valores);

    }

    private static void simulacion(List<Integer> valores) throws InterruptedException, IOException {
        int poder = valores.get(0);

        int carcaj = valores.get(1);

        int poderM = valores.get(2);

        int flechas = valores.get(3);

        int enemigos = valores.get(4);

        LocalTime tiempoInicial = LocalTime.now();

        System.out.println("tiempo inicial de la simulación: "+tiempoInicial);

        LocalTime tiempoFinal;

        Personaje[] personajes = personajesGenerator(poder, carcaj);

        ColaSala repositorioSalas = randomSalasGenerator(poderM, flechas, enemigos);

        do{

            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();

            Sala salaActual = repositorioSalas.getOut();

            System.out.println("La sala a la que nos tratamos de enfrentar es:");
            System.out.println(salaActual);
            System.out.println();

            realizarAccionRespectoASala(salaActual, personajes);

            System.out.println("Quedán un total de "+repositorioSalas.salasRestantes()+" salas por tratar de recorrer.");
            System.out.println();

            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();

            Thread.sleep(2000L);

        }while (repositorioSalas.quedanSalas() && personajesSiguenVivos(personajes));

        tiempoFinal = LocalTime.now();

        Informe informe;

        int salasSinSuperar = repositorioSalas.salas.size();
        int salasSuperadas = 36-salasSinSuperar;

        if(salasSinSuperar != 0){
            informe = new Informe(
                    "Por desgracia nuestros heroes han fracasado en su travesía muriendo sin conseguir su cometido.",
                    String.valueOf(salasSuperadas),
                    String.valueOf(salasSinSuperar),
                    String.valueOf(tiempoInicial),
                    String.valueOf(tiempoFinal)
            );
        } else {
            informe = new Informe(
                    "Nuestros heroes han conseguid superar todas sus pruebas y terminar con su mision apenas sin rasguños.",
                    String.valueOf(salasSuperadas),
                    String.valueOf(salasSinSuperar),
                    String.valueOf(tiempoInicial),
                    String.valueOf(tiempoFinal)
            );
        }

        InformeStorageTXT txt = new InformeStorageTXT();
        txt.exportar(informe);

        txt.importar().forEach(System.out::println);

        System.out.println();

        InformeStorageJSON json = new InformeStorageJSON();
        json.exportar(informe);

        System.out.println(json.importar());

        System.out.println();

        InformeStorageXML xml = new InformeStorageXML();
        xml.exportar(informe);

        System.out.println(xml.importar());

        System.out.println();
    }

    private static void realizarAccionRespectoASala(Sala salaActual, Personaje[] personajes) {
        if (salaActual instanceof SalaMagica){
            realizarAccionSalaMagica((SalaMagica) salaActual, personajes);
        }else{
            if (salaActual instanceof SalaAccion){
                realizarAccionSalaAccion((SalaAccion) salaActual, personajes);
            }else{
                realizarAccionSalaHabilidad(salaActual, personajes);
            }
        }
    }

    private static void realizarAccionSalaMagica(SalaMagica salaActual, Personaje[] personajes) {
        Personaje mago = personajes[posMago];
        System.out.println("Como nos encontramos en una sala magíca, la pieza importante del equipo es el: "+mago);
        System.out.println();

        Vara vara = (Vara) mago.items.get(0);
        vara.recargarVara(randomNumberGeneratorForIntegers(1, 10));
        System.out.println();

        int poderMalignoSala = salaActual.poderMaligno;
        int poderVara = vara.poderVara();

        if (poderVara > poderMalignoSala){
            System.out.println("Como el poder de nuestra vara es mayor que el poder maligno, hemos ganado el encuentro.");
            System.out.println();
            return;
        }else{
            int random = randomNumberGeneratorForIntegers(1, 100);
            if (poderVara == poderMalignoSala){
                System.out.println("El poder de nuestra vara es el mismo que el poder maligno.");
                if(random <= 60){
                    System.out.println("Pero aun así y gracias a dios, hemos ganado el encuentro.");
                    System.out.println();
                    return;
                }
            }else{
                System.out.println("El poder de nuestra vara es menor que el poder maligno.");
                if(random <= 20){
                    System.out.println("Pero aun así y gracias a dios, hemos ganado el encuentro.");
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println("Por desgracia hemos terminado perdiendo el encuentro, se acabo la partida.");
        System.out.println();
        for (int i = 0; i< personajes.length; i++){
            personajes[i].estaVivo = false;
        }
    }

    private static void realizarAccionSalaAccion(SalaAccion salaActual, Personaje[] personajes) {
        Personaje elfo = personajes[posElfo];
        System.out.println("Como nos encontramos en una sala de acción, la pieza importante del equipo es el: "+elfo);
        System.out.println();

        Carcaj carcaj = (Carcaj) elfo.items.get(0);

        int enemigoTotales = salaActual.enemigos;
        int enemigosRestantes = enemigoTotales;

        for (int i = 0; i < enemigoTotales; i++){
           if(carcaj.lanzarFlecha()){
               enemigosRestantes--;
           }else{
               break;
           }
        }

        if (enemigosRestantes == 0){
            int flechasSala = salaActual.flechas;
            System.out.println("Hemos acabado con todos los enemigos, ganando el encuentro, por lo que procedemos a recoger las flechas de la sala y avanzar a la siguiente sala.");
            carcaj.recargarCarcaj(flechasSala);
            System.out.println();
        }else{
            int random = randomNumberGeneratorForIntegers(1, 100);
            System.out.println("Hemos perdido el encuentro.");
            if (random <= 80){
                System.out.println("Sin embargo, hemos conseguido escapar a la siguiente sala.");
                System.out.println();
            }else{
                System.out.println("Desafortunadamente hemos perdido el encuentro, por lo que termino la partida.");
                System.out.println();
                for (int i = 0; i< personajes.length; i++){
                    personajes[i].estaVivo = false;
                }
            }
        }
    }

    private static void realizarAccionSalaHabilidad(Sala salaActual, Personaje[] personajes) {
        Personaje hobbit = personajes[posHobbit];
        System.out.println("Como nos encontramos en una sala de habilidad, la pieza importante del equipo es el: "+hobbit);
        System.out.println();

        int random = randomNumberGeneratorForIntegers(1, 100);
        Anillo anillo = (Anillo) hobbit.items.get(0);

        anillo.ponerAnillo();
        System.out.println();

        if(anillo.llevaElAnillo){
            if(random <= 90){
                System.out.println("Hemos conseguido ganar el encuentro en la sala de habilidad");
                System.out.println();
                return;
            }
        }else{
            if(random <= 20){
                System.out.println("Aunque no nos hayamos puesto el anillo, hemos conseguido ganar el encuentro en la sala de habilidad");
                System.out.println();
                return;
            }
        }

        System.out.println("Hemos perdido el encuentro en la sala de habilidad.");

        random = randomNumberGeneratorForIntegers(1, 100);
        if(random <= 80){
            System.out.println("Pero afortunadamente hemos conseguido escapar a la siguienter sala.");
            System.out.println();
        }else{
            System.out.println("Desafortunadamente hemos perdido el encuentro, por lo que termino la partida.");
            System.out.println();
            for (int i = 0; i< personajes.length; i++){
                personajes[i].estaVivo = false;
            }
        }

    }

    private static boolean personajesSiguenVivos(Personaje[] personajes) {
        //O mueren todos o no muere ni uno
        return personajes[0].estaVivo;
    }

    private static String joinToString(Object[] array, String separator) {
        String message = "";
        int size = array.length-1;
        for (int i = 0; i < size; i++){
            message += array[i]+separator;
        }
        message += array[size];
        return message;
    }
}