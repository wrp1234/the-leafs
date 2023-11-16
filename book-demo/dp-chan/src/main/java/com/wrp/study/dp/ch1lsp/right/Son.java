package com.wrp.study.dp.ch1lsp.right;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author wrp
 * @date 2023年11月10日 16:27
 * @description
 */
public class Son extends Father {

    public Collection convert(HashMap map) {
        System.out.println("Son convert...");
        return map.values();
    }
}
