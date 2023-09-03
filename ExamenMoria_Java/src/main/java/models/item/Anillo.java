package models.item;

import interfaces.Hobbit;

import java.util.UUID;

public class Anillo extends Item implements Hobbit {

    public boolean llevaElAnillo = false;

    public Anillo(UUID id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Anillo{" +
                "llevaElAnillo=" + llevaElAnillo +
                ", id=" + id +
                '}';
    }

    public boolean elLlevaElAnillo() {
        return llevaElAnillo;
    }

    @Override
    public void ponerAnillo() {
        System.out.println("Tratamos de ponernos el anillo.");

        double randomValue = Math.random();

        if(randomValue <= 0.5){
            System.out.println("Hemos conseguido ponerlos el anillo.");
            llevaElAnillo = true;
        }else{
            quitarseAnillo();
        }
    }

    @Override
    public void quitarseAnillo() {
        System.out.println("No hemos conseguido ponerlos el anillo.");
        llevaElAnillo = false;
    }
}
