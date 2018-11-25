package com.liuhs;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class HelloWorld {

    private static final Logger logger = Logger.getLogger("HelloWorld");

    public static void main(String[] args) {
        System.out.println("args = " + args);

        // 集合工厂方法-set
        Set<String> set = Set.of("A", "B", "C");
        System.out.println("set = " + set);

        // 集合工厂方法-list
        List<String> ints = List.of("1", "2", "3");
        System.out.println("ints = " + ints);

        // 集合工厂方法-map
        Map<String, String> filter = Map.of("1", "刘洪申", "2", "吴春雨");
        System.out.println("filter = " + filter);

        // 集合工厂方法-map
        Map<String, String> entries = Map.ofEntries(new AbstractMap.SimpleEntry<>("A", "liu"),
                new AbstractMap.SimpleEntry<>("B", "wu"));
        System.out.println("entries = " + entries);

    }
}
