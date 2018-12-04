package com.longforus;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author longforus
 * @describe
 * @date 11/15/2018  5:51 PM
 */
public class MapTest {
    public static void main(String... args) {
        ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<>();
        //原子操作
        //concurrentHashMap.compute("123", (s, aLong) -> aLong == null ? 1 : aLong + 1);
        //如果key不存在就map[key]=value,如果存在就map[key]=remappingFunction.apply(map[key], value),aLong2==value
        //concurrentHashMap.merge("123", 1L, (aLong, aLong2) -> aLong + aLong2);
        //parallelismThreshold=1 在尽可能多的线程中执行
        //parallelismThreshold=Long.MAX_VALUE 在一个线程中执行
        concurrentHashMap.put("kkk", 2L);
        concurrentHashMap.search(1, (s, aLong) -> aLong > 1000 ? s : null);
        concurrentHashMap.forEach(1, (s, aLong) -> s + "->" + aLong, System.out :: println);
        System.out.println(concurrentHashMap);

        //获取一个并发的set
        Set<String> set = ConcurrentHashMap.<String>newKeySet();

        Object lock = new Object();
        //获得一个同步的map
        Map<String, Long> longMap = Collections.synchronizedMap(new HashMap<String, Long>());
        synchronized (lock) {
            for (Map.Entry<String, Long> entry : longMap.entrySet()) {
                //使用foreach的时候仍旧需要加锁,因为使用到了iterator
            }
        }
    }
}
