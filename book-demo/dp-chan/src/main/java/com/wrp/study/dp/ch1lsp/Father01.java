package com.wrp.study.dp.ch1lsp;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author wrp
 * @date 2023年11月10日 16:21
 * @description
 */
public class Father01 {

    public Collection convert(HashMap hashMap) {
        System.out.println("Father01 convert...");
        return hashMap.values();
    }
}
