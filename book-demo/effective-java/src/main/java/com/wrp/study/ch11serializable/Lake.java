package com.wrp.study.ch11serializable;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author wrp
 * @date 2023年11月10日 11:01
 * @description
 * 1. 不实现Serializable，就用ObjectOutputStream.writeObject 会报错java.io.NotSerializableException
 * 2. 不写 serialVersionUID, 如果Bean改变了，反序列化会报错 java.io.InvalidClassException
 */
public class Lake implements Serializable{
    @Serial
//    private static final long serialVersionUID = -6984108219553827867L;
    private static final long serialVersionUID = 1L;
    private String name;
    private int length;
    private String pac;

    public Lake(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Lake(String name, int length, String pac) {
        this.name = name;
        this.length = length;
        this.pac = pac;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getPac() {
        return pac;
    }

    @Override
    public String toString() {
        return "River{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", pac='" + pac + '\'' +
                '}';
    }
}
