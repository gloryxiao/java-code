package com.sean.base;

import com.sean.base.common.Stock;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    @Test
    public void testStream() {
        List<Stock> list = Arrays.asList(new Stock("HK0001", 1), new Stock("HK0002", 0.01f),
                new Stock("SH0003", 0.3f), new Stock("SZ0004", 1900.8f));
        List<String> names = list.stream().filter(e -> {System.out.println(e.getName()); return true;}).
                map(e -> {System.out.println(e.getName());
                return e.getName();}).limit(2).collect(Collectors.toList());
        System.out.println(names);
    }
}
