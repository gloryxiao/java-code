package com.sean.base;

import com.sean.base.common.Stock;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    @Test
    public void testStream() {
        Math.max(1, 2);
        List<Stock> list = Arrays.asList(new Stock("HK0001", 1), new Stock("HK0002", 0.01f),
                new Stock("SH0003", 0.3f), new Stock("SZ0004", 1900.8f));
        List<String> names = list.stream().filter(e -> {System.out.println(e.getName()); return true;}).
                map(e -> {System.out.println(e.getName());
                return e.getName();}).limit(2).collect(Collectors.toList());
        System.out.println(names);
    }

    public static class T {
        private String model;
        private int version;

        public T(String model, int version) {
            this.model = model;
            this.version = version;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }

    @Test
    public void testGroup() {
        List<T> tList = Arrays.asList(new T("a", 1), new T("a", 2));
        Map<String, List<T>> listMap = tList.stream().collect(Collectors.groupingBy(T::getModel));
        Assert.assertNotNull(listMap);
    }
}
