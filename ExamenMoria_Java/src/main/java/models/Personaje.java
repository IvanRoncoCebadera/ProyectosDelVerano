package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import models.item.Item;

import java.util.List;

@Data
@AllArgsConstructor
public class Personaje {
    public String nombre;
    public boolean estaVivo;
    public List<Item> items;
}