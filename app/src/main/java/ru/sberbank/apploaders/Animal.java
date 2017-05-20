package ru.sberbank.apploaders;

/**
 * Created by user8 on 18.05.2017.
 */

public class Animal {
    private String Specie;
    private int mass;
    private int height;
    private String NickName;

    public Animal(String specie, int mass, int height, String nickName) {
        Specie = specie;
        this.mass = mass;
        this.height = height;
        NickName = nickName;
    }

    public String getSpecie() {
        return Specie;
    }

    public int getMass() {
        return mass;
    }

    public int getHeight() {
        return height;
    }

    public String getNickName() {
        return NickName;
    }
}
