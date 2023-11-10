package com.wrp.study.se.common;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author wrp
 * @date 2023年11月01日 18:27
 * @description
 */
public class EqualsObjectTest {

    @Test
    public void testEquals() {

        EqualsObject wrp1 = new EqualsObject(1, "wrp");
        EqualsObject wrp2 = new EqualsObject(1, "wrp");
        EqualsObject wrp3 = new EqualsObject(1, "wrp");

        Set<EqualsObject> set = new HashSet<>();
        set.add(wrp1);
        set.add(wrp2);
        set.add(wrp3);
        // 三个元素
        System.out.println(set);
    }
}