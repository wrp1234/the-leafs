package com.wrp.study.se.collection.list;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wrp
 * @date 2023年11月01日 16:00
 * @description
 */
public class ListNoGeneric {

    /**
     * List<?> 通配符集合，可以接收任何类型的集合，不能添加元素，可以remove、clear，<br/>
     *  一般作为方法参数或返回一个不知道具体元素类型的集合<br/>
     *
     * List<T> 只能防止一种类型<br/>
     *
     * List<? extends T> 可以接收多种类型<br/>
     *  Get First<br/>
     *  消费集合元素的场景<br/>
     *  无法add<br/>
     *  T t = (T)list.get();<br/>
     * List<? super T> 可以接收多种类型<br/>
     *  Put First<br/>
     *  生产集合元素的场景<br/>
     *  list.add(T及其子类)<br/>
     *  无法get<br/>
     */
    public static void noGeneric() {
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(Integer.valueOf("123"));
        a1.add("hello");
        // [java.lang.Object@23223dd8, 123, hello]
        System.out.println(a1);

        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(Integer.valueOf("123"));
        a2.add("hello");
        // [java.lang.Object@23223dd8, 123, hello, java.lang.Object@4ec6a292, 123, hello]
        System.out.println(a2);

        List<Integer> a3 = a1;
        a3.add(Integer.valueOf("123"));
        // 只允许添加Integer
        /*a3.add(new Object());
        a3.add("hello");*/
        // [java.lang.Object@23223dd8, 123, hello, java.lang.Object@4ec6a292, 123, hello, 123]
        System.out.println(a3);

        List<?> a4 = a1;
        // 编译出错。不允许添加任何元素
        /*a4.add(new Object());
        a4.add(Integer.valueOf("123"));
        a4.add("hello");*/
        // 允许删除和清除元素
//        a4.remove(0);
        a4.clear();
        // []
        System.out.println(a4);

    }

    public static void classCast() {

        JSONObject jsonObject = JSONObject.parseObject("""
                {
                            "level" : ["3"]
                        }
                """);
        List<Integer> list = new ArrayList<>();

        if(jsonObject != null) {
//            list.addAll(jsonObject.getJSONArray("level"));
        }


        list.add(1);

        // 有问题
//        List<Object> objectList = list;
    }


}
