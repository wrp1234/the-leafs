package com.wrp.study.se.common;

import java.util.Objects;

/**
 * @author wrp
 * @date 2023年11月01日 18:24
 * @description
 *
 * hashCode和equals用来标识对象
 * 1. hashCode不同，equals肯定不同
 * 2. hashCode相同，考虑到hash冲突，需要比较equals
 *
 * 3.equals相同，hashCode必须相同
 * 4.equals不同，hashCode不强制不同（优秀的hash算法，尽可能降低冲突）
 *
 * 总结：
 * 1.map和set 先判断hashCode && equals
 * 2.如果要重写equals，那么hashCode也得重写
 * 3.作为key的对象，也得重写hashCode和equals
 */
public class EqualsObject {
    private int id;
    private String name;

    public EqualsObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsObject that)) return false;

        if (id != that.id) return false;
        return Objects.equals(name, that.name);
    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }
}
