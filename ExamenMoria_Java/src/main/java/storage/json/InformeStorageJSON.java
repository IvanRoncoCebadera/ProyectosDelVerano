package storage.json;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import models.Informe;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class InformeStorageJSON {

    private String directoryPath = System.getProperty("user.dir")+ File.separator+"data";

    private String filePath = directoryPath+File.separator+"informeJSON";

    private File file = new File(filePath);

    Moshi moshi = new Moshi.Builder().build();

    JsonAdapter<Informe> jsonAdapter = moshi.adapter(Informe.class);

    public void exportar(Informe entity) throws IOException {
        if(!Files.exists(Path.of(directoryPath))){
            Files.createDirectory(Path.of(directoryPath));
        }
        try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
            br.write(jsonAdapter.indent("   ").toJson(entity));
        }catch (Exception e){
            throw e;
        }
    }

    public Informe importar() throws IOException {
        Informe informe = null;
        if(!file.exists()) return informe;
        try{
            informe = jsonAdapter.fromJson(Files.readString(Path.of(file.getPath())));
        }catch (Exception e){
            throw e;
        }
        return informe;
    }
}
