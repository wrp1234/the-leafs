package com.wrp.study.se.collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wrp
 * @date 2023年11月01日 15:25
 * @description
 */
public class ArraysDemo {

    /**
     * Arrays.asList 返回的结果是Arrays.ArrayList内部类，无法使用add,remove等操作
     */
    public static void array2List() {
        String[] arr = new String[3];
        arr[0] = "one";
        arr[1] = "two";
        arr[2] = "three";


        List<String> list = Arrays.asList(arr);
        list.set(0,"oneList");
        System.out.println(arr[0]);

        // java.lang.UnsupportedOperationException
        /*list.add("four");
        list.remove(2);
        list.clear();*/

    }

    /**
     * List.toArray 方法，
     *  无参
     *      会丢失泛型。
     *  有参，
     *      当length不足时，调用Arrays.copyOf
     *      足够时直接填充到参数数组中
     */
    public static void list2Array() {
        List<String> list = new ArrayList<>(3);
        list.add("one");
        list.add("two");
        list.add("three");

        Object[] array = list.toArray();



        String[] arr1 = new String[0];
        String[] array1 = list.toArray(arr1);
        // []
        System.out.println(Arrays.asList(arr1));
        // [one, two, three]
        System.out.println(Arrays.asList(array1));
        String[] arr2 = new String[2];
        list.toArray(arr2);
        // [null, null]
        System.out.println(Arrays.asList(arr2));
        String[] arr3 = new String[6];
        list.toArray(arr3);
        //[one, two, three, null, null, null]
        System.out.println(Arrays.asList(arr3));


        // 总结：此方式最优
        String[] array2 = list.toArray(new String[list.size()]);
        System.out.println(Arrays.asList(array2));
    }
}
