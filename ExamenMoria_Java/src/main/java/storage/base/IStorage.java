package storage.base;

import java.io.IOException;
import java.util.List;

public interface IStorage <T>{
    void exportar(T entity) throws IOException;
    List<T> importar();
}
