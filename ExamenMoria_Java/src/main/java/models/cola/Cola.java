package models.cola;

public interface Cola <T>{
    void insert(T entity);
    T getOut();
}
