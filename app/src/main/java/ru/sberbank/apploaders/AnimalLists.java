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
    }

    public static List<Animal> getList() {
        return list;
    }
}
