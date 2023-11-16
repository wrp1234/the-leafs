package com.wrp.study.dp.ch1lsp.right;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wrp
 * @date 2023年11月10日 16:21
 * @description
 */
public class Father {
    public Collection convert(Map map) {
        System.out.println("Father convert...");
        return map.values();
    }
}
