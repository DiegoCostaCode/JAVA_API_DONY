package org.example.Entities;

public class Afetados implements InterfaceAfetados {
    private int id;
    private Material material;
    private Animal animal;

    @Override
    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}