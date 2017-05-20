package ru.sberbank.apploaders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user8 on 18.05.2017.
 */

public class AnimalLists {
    private static final List<Animal> list = new ArrayList<>();
    AnimalLists(){
        list.add(new Animal("cat",5,20,"Kyle"));
        list.add(new Animal("dog",20,40,"Bob"));
        list.add(new Animal("horse",100,200,"Lesly"));
        list.add(new Animal("monkey",30,20,"Andry"));
        list.add(new Animal("crocodile",20,40,"Toto"));
        list.add(new Animal("cow",100,200,"Many"));
        list.add(new Animal("bear",200,20,"Myilo"));
        list.add(new Animal("hear",20,40,"Valli"));
        list.add(new Animal("snake",10,200,"Kate"));
    }

    public static List<Animal> getList() {
        return list;
    }
}
