package com.wrp.study.ch11serializable;

import java.io.*;

/**
 * @author wrp
 * @date 2023年11月10日 13:48
 * @description
 */
public class Foo extends AbstractFoo implements Serializable {

    @Serial
    private static final long serialVersionUID = -1675663619883464631L;

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        System.out.println("Foo readObject...");
        s.defaultReadObject();
        int x = s.readInt();
        int y = s.readInt();
        initialize(x, y);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        System.out.println("Foo writeObject...");
        s.defaultWriteObject();

        s.writeInt(getX());
        s.writeInt(getY());
    }

    public Foo(int x, int y) {
        super(x, y);
    }
}
