package com.liuhs.patterns.singleton;

/**
 * 单例模式3
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    /**
     * 要点：外部类加载的时候，内部类不会加载
     */
    private static class SingletonHolder {
        static {
            // 可添加代码测试
        }

        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
