package storage.xml;

import models.Informe;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InformeStorageXML {

    private String directoryPath = System.getProperty("user.dir")+ File.separator+"data";

    private String filePath = directoryPath+File.separator+"informeXML";

    private File file = new File(filePath);

    private Persister persister = new Persister();

    public void exportar(Informe entity) throws IOException {
        if(!Files.exists(Path.of(directoryPath))){
            Files.createDirectory(Path.of(directoryPath));
        }
        try {
            persister.write(entity, file);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public Informe importar(){
        Informe informe = null;
        if(!file.exists()) return informe;
        try {
            informe = persister.read(Informe.class, file);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return informe;
    }
}
