package com.wrp.study.ch11serializable;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * @author wrp
 * @date 2023年11月10日 11:07
 * @description
 */
public class DemoTest {

    /**
     *
     * @throws Exception
     */
    @Test
    public void serialize() throws Exception {
//        River river = new River("青衣江", 1234, "四川省");
        River river = new River("青衣江", 1234);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("river.bean"));
        oos.writeObject(river);
    }

    @Test
    public void deserialize() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("river.bean"));
        Object object = ois.readObject();
        River river = (River) object;
        river.doSomething();
        System.out.println(river);
    }

    /**
     * River和Lake的serialVersionUID相同，也不能转换，因为在序列化时记录了类型
     * 即使readObject返回的Object,但是还是有类型信息。
     * @throws Exception
     */
    @Test
    public void deserializeByOther() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("river.bean"));
        Object object = ois.readObject();
        Lake lake = (Lake) object;
        System.out.println(lake);
    }

    @Test
    public void foo() throws Exception {
        Foo foo  = new Foo(1,2);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("foo.txt"));
        oos.writeObject(oos);
    }
}