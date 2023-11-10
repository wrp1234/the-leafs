package com.wrp.study.ch11serializable;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author wrp
 * @date 2023年11月10日 11:01
 * @description
 * 1. 不实现Serializable，就用ObjectOutputStream.writeObject 会报错java.io.NotSerializableException
 * 2. 不写 serialVersionUID, 如果Bean改变了，反序列化会报错 java.io.InvalidClassException
 * 3. 反序列化不依赖构造器函数
 * 4. 只能恢复字段类型相同的属性。
 */
public class River implements Serializable{
    @Serial
//    private static final long serialVersionUID = -6984108219553827867L;
    private static final long serialVersionUID = 1L;
    private String name;
    private int len;
    private String pac;

    public River(){
        System.out.println("111111111111");
    }

    public River(String name, int length) {
        System.out.println("111111111111");
        this.name = name;
        this.len = length;
    }

//    public River(String name, int length, String pac) {
//        System.out.println("111111111111");
//        this.name = name;
//        this.length = length;
//        this.pac = pac;
//    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return len;
    }

//    public String getPac() {
//        return pac;
//    }

    @Override
    public String toString() {
        return "River{" +
                "name='" + name + '\'' +
                ", length=" + len +
                '}';
    }

    public void doSomething() {
        System.out.println(name);
        System.out.println(len);
        System.out.println(pac);
    }
}
