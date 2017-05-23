package ru.sberbank.apploaders;

/**
 * Created by user8 on 18.05.2017.
 */

public class Animal {
    private String specie;
    private int weight;
    private int height;
    private String name;

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
