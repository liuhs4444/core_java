package com.liuhs.map;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap<K,V> {

    public static void main(String[] args) {

        System.out.println("args = " + args);

        HashMap<Object, Object> map = new HashMap<>();

        // 测试扩容
        for (int i = 1; i <= 17; i++) {
            map.put(i, i);
            System.out.println("i = " + i);
        }

        // 测试hashcode冲突
        map.put("Aa", "Aa");

        map.put("BB", "BB");

        // 两个引用同时指向一个地址，修改内容是修改的同一个地址的内容
        String[] a = new String[]{"1", "2", "3"};

        String[] b;

        b = a;

        b[0] = "3";

        System.out.println(a[0]);


    }


    static class Node<K, V> implements Map.Entry<K, V> {

        final int hash;
        final K key;
        V value;
        Node<K, V> next; // 作为链表结构的节点

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    /**
     * 默认的负载因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 默认的初始容量
     */
    static final float DEFAULT_INITIAL_CAPACITY = 1 << 4;

    Node<K, V>[] table; // hash表

    int size; // 元素的个数

    int modCount; // 结构改变的次数

    int threshold; // k-v对的阀值

    // final赋值后就不能在改变，直接赋值或在构造方法，代码块中赋值
    final float loadFactor; // 负载因子

    // 计算hash值，高16位异或低16位，目的当数组的长度较小时，
    // 减少hash碰撞
    static final int hash(Object key) {
        int h;
        return (null == key) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    final V putVal(int hash, K key, V value) {

        // n为数组的长度，i为根据hash值获得的index
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;

        // 第一次存值，数组为null，长度为0，所以要扩容
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }

        // 取模运算获取对应数组的存储下标，优化：%运算转&运算
        if ((p = tab[i = (n - 1) & hash]) == null) {
            tab[i] = new Node(hash, key, value, null);
        } else {
            Node<K, V> e;
            K k;
            // 如果hash值相等且key的值相等，则说明相同的key已经存在，接下来
            // 覆盖原来的值
            if (p.hash == hash && ((k = p.key) == key || key != null && key.equals(k))) {
                e = p;
            } else {
                // hash确实冲突了
                for (int binCount = 0; ; ++binCount) {
                    //  = Null 为第一次冲突
                    if ((e = p.next) == null) {
                        p.next = new Node(hash, key, value, null);
                        break;
                    }
                    // 相同的key进来，覆盖链表里的值
                    if (e.hash == hash && ((k = e.key) == key || key != null && key.equals(k))) {
                        break;
                    }
                    // 如果非第一次冲突
                    p = e; // 则继续寻找下一个节点，继续循环，直到找到节点next节点为Null，将其放入
                    // 有点递归深入的意思
                }
            }

            // 数组覆盖和链表，红黑树覆盖都走这个
            if (e != null) { // existing mapping for key 存在这个key的映射才覆盖
                V oldValue = e.value;
                e.value = value;
                return oldValue; // 覆盖操作会返回旧的值
                // 不会改变结构，不会改变size，所以覆盖后直接return
            }
        }

        ++modCount; // 结构改变次数
        if (++size > threshold) {
            resize();
        }
        return null;
    }

    final Node<K, V>[] resize() {
        return null;
    }

}
