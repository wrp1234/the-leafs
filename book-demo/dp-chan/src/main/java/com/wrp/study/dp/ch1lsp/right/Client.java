package com.wrp.study.dp.ch1lsp.right;

import java.util.HashMap;

/**
 * @author wrp
 * @date 2023年11月10日 16:28
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Father son = new Son();
        son.convert(new HashMap());
    }
}
