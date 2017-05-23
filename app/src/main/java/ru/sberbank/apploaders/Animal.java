package ru.sberbank.apploaders;

/**
 * Created by user8 on 18.05.2017.
 */

public class Animal {
    private String specie;
    private int weight;
    private int height;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;

        Animal animal = (Animal) o;

        if (weight != animal.weight) return false;
        if (height != animal.height) return false;
        if (specie != null ? !specie.equals(animal.specie) : animal.specie != null) return false;
        return name != null ? name.equals(animal.name) : animal.name == null;
    }

    @Override
    public int hashCode() {
        int result = specie != null ? specie.hashCode() : 0;
        result = 31 * result + weight;
        result = 31 * result + height;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Animal(String specie, int mass, int height, String name) {
        this.specie = specie;
        this.weight = mass;
        this.height = height;
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public int getMass() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }
}
