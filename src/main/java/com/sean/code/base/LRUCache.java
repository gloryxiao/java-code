package com.sean.code.base;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final float FACTOR = 0.75f;
    private final int maxCacheSize;

    public LRUCache(int cacheSize) {
        super((int)Math.ceil(cacheSize / LRUCache.FACTOR) + 1, LRUCache.FACTOR, true);
        this.maxCacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCacheSize;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(4);
        for (int i = 0; i < 8; i ++) {
            cache.put(String.valueOf(i), i);
            if (i == 5) {
                cache.get("2");
            }
            System.out.println(i + ":" + cache);
        }
    }
}
