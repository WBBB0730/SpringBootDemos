package com.wbbb.demo01.util;

import java.math.BigInteger;
import java.util.Random;

/**
 * 标识符生成工具
 */
public class SymbolGenerateUtil {
    /**
     * 生成账户Id
     */
    public static BigInteger generateUserId() {
        return new BigInteger("1" + System.currentTimeMillis() + new Random().nextInt(10));
    }
}
