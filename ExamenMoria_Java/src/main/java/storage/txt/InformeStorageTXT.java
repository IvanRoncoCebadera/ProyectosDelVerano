package storage.txt;

import models.Informe;
import storage.base.IStorage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InformeStorageTXT implements IStorage<Informe> {

    private String directoryPath = System.getProperty("user.dir")+ File.separator+"data";

    private String filePath = directoryPath+File.separator+"informeTXT";

    private File file = new File(filePath);

    @Override
    public void exportar(Informe entity) throws IOException {
        if(!Files.exists(Path.of(directoryPath))){
            Files.createDirectory(Path.of(directoryPath));
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            try {
                bw.newLine();
                bw.write("-La simulación acabó así, "+entity.resultadoDeLaSimulacion);
                bw.newLine();
                bw.write("-Salas superadas, "+entity.salasSuperadas);
                bw.newLine();
                bw.write("-Salas no superadas, "+entity.salasNoSuperadas);
                bw.newLine();
                bw.write("-Tiempo inicial, "+entity.tiempoInicial);
                bw.newLine();
                bw.write("-Tiempo final, "+entity.tiempoFinal);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Informe> importar() {
        List<Informe> informes = new ArrayList<>();
        if(!file.exists()) return informes;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            br.readLine();
            while(br.ready()){
                informes.add(
                        new Informe(
                                br.readLine().split(",")[1].trim(),
                                br.readLine().split(",")[1].trim(),
                                br.readLine().split(",")[1].trim(),
                                br.readLine().split(",")[1].trim(),
                                br.readLine().split(",")[1].trim()
                        )
                );
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return informes;
    }
}
