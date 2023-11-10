package com.wrp.study.se.collection.list;

import com.wrp.study.se.collection.list.animal.Animal;
import com.wrp.study.se.collection.list.animal.Cat;
import com.wrp.study.se.collection.list.animal.Garfield;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wrp
 * @date 2023年11月01日 16:34
 * @description
 */
public class AnimalCatGarfield {

    public static void demo() {
        List<Animal> animal = new ArrayList<>();
        List<Cat> cat = new ArrayList<>();
        List<Garfield> garfield = new ArrayList<>();

        animal.add(new Animal());
        cat.add(new Cat());
        garfield.add(new Garfield());

        // 下行出错，只能接收Cat及其子类的集合
//        List<? extends Cat> extendsCatFromAnimal = animal;
        List<? super Cat> superCatFromAnimal = animal;

        List<? extends Cat> extendsCatFromCat = cat;
        List<? super Cat> superCatFromCat = cat;

        List<? extends Cat> extendsCatFromGarfield = garfield;
        // 下行编译出错，只能接收Cat及其父类的集合
//        List<? super Cat> superCatFromGarfield = garfield;

        // List<? extends Cat> 无法add
        /*extendsCatFromCat.add(new Animal());
        extendsCatFromCat.add(new Cat());
        extendsCatFromCat.add(new Garfield());*/

        // 下行编译出错，只能接收Cat及其子类的集合
//        superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());

        // 类型被擦除
        Object catExtends2 = superCatFromCat.get(superCatFromCat.size() - 1);
        System.out.println(catExtends2);
        Cat catExtends1 = extendsCatFromCat.get(0);
        Cat garfield1 = extendsCatFromGarfield.get(0);

    }
}
