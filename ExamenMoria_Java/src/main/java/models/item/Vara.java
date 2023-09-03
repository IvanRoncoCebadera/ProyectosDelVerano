package models.item;

import interfaces.Mago;

import java.util.UUID;

public class Vara extends Item implements Mago {
    private int poderVara; //Empieza en 0

    private int poderTotalDisponible; //Entre 1 y un valor parametrizable, por ejemplo 30

    public Vara(UUID id, int poderTotalVara) {
        super(id);
        this.poderVara = 0;
        this.poderTotalDisponible = poderTotalVara;
    }

    @Override
    public String toString() {
        return "Vara{" +
                "poderVara=" + poderVara +
                ", poderTotalDisponible=" + poderTotalDisponible +
                ", id=" + id +
                '}';
    }

    @Override
    public void recargarVara(int energia) {
        if (poderTotalDisponible == 0){
            System.out.println("Se intenta recargar los puntos de poder de la vara, pero como no queda energía para eso, no ocurre nada.");
            return;
        }
        if(energia <= poderTotalDisponible){
            poderVara = energia;
            poderTotalDisponible -= energia;
        }else{
            poderVara = poderTotalDisponible;
            poderTotalDisponible = 0;
        }
        System.out.println("Se recarga la vara con un total de "+energia+" puntos de energía.\nA la vara le queda un total de "+poderTotalDisponible+" puntos de poder disponibles.");
    }

    /**
     * Devuelve el poder actual de la vara devolviendolo a 0
     * @return el poder actual de la vara
     */
    @Override
    public Integer poderVara() {
        int poder = poderVara;
        poderVara = 0;
        return poder;
    }
}
