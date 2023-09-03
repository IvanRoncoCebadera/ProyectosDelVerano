package validator;

import java.util.Arrays;
import java.util.List;

public class Validator {
    /**
     * función que valida los argumentos del programa introducidos
     * @param args son los argumentos del programa
     * @return una lista con los valores importantes, en el orden: poder, carcaj, poderM, flechas, enemigos
     */
    public static List<Integer> validateProgramArgs(String[] args) {
        List<String> valores = List.of(new String[]{args[1], args[3], args[5], args[7], args[9]});

        String regexNum = "[0-9][0-9]*";

        for (int i = 0; i < valores.size(); i++){
            if(!valores.get(i).matches(regexNum)){
                System.out.println("Has introducido los argumentos del programa mal, toma este ejemplo y vuelve a probar:");
                System.out.println("java -cp .\\ExamenMoria_Java-1.0-SNAPSHOT.jar org.example.Main -poder 30 -carcaj 20 -poderM 10 -flechas 10 -enemigos 10");
                System.exit(0);
            }
        }

        return valores.stream().map(it -> Integer.parseInt(it)).toList();
    }
}
