package models.item;

import interfaces.Elfo;

import java.util.UUID;

public class Carcaj extends Item implements Elfo {
    public int flechas;

    public Carcaj(UUID id, int flechas) {
        super(id);
        this.flechas = flechas;
    }

    @Override
    public String toString() {
        return "Carcaj{" +
                "flechas=" + flechas +
                ", id=" + id +
                '}';
    }

    /**
     * función que permite lanzar flechas
     * @return true si tiene para lanzar flechas y false si no puede tirar flechas, aprovechar para utilizar un break
     */
    @Override
    public boolean lanzarFlecha() {
        if(flechas == 0){
            System.out.println("No quedan más flechas para disparar a los enemigos.");
            System.out.println();
            return false;
        }
        flechas--;
        System.out.println("Has disparado una flecha matando a un enemigo, te quedán "+flechas+" flechas en el carcaj.");
        System.out.println();
        return true;
    }

    @Override
    public void recargarCarcaj(int flechas) {
        this.flechas += flechas;
        System.out.println("Se han encontrado "+flechas+" flechas en la sala y se las han quedado, ahora disponemos de "+this.flechas+" felchas en el carcaj.");
        System.out.println();
    }
}
