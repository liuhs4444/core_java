package com.liuhs.singleton;

/**
 * 单例模式1
 */
public class Singleton {

    // 单例模式的核心在于通过一个接口返回唯一的对象实例

    static {
        System.out.println("static code block is init ... ");
    }

    {
        System.out.println("code block is init ... ");
    }

    // (1)首先私有构造器，保证外界不能随意创建该类的实例对象
    private Singleton() {
        System.out.println("singleton is create ... ");
    }

    // (2)提供该类的唯一实例，并私有
    private static final Singleton INSTANCE = new Singleton();

    // (3)提供公开静态的方法，能返回该类的唯一实例
    public static Singleton getInstance() {
        return INSTANCE;
    }

    public static void testLoadOrder() {
        System.out.println("test load order ... ");
    }

}
