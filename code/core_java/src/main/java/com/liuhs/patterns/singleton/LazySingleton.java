package com.liuhs.patterns.singleton;

/**
 * 单例模式2
 */
public class LazySingleton {

    private LazySingleton() {

    }

    private static LazySingleton INSTANCE = null;

    public synchronized static LazySingleton getInstance() {

        if (null == INSTANCE) {
            INSTANCE = new LazySingleton();
        }

        return INSTANCE;
    }
}
