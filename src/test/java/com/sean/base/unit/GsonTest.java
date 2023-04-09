package com.sean.base.unit;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class GsonTest {
    @Test
    public void test001Prim() {
        String test = "1";
        JsonElement jsonElement = new Gson().toJsonTree(test);
        JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
        Assert.assertNotNull(jsonElement);
    }

    @Test
    public void test002JsonPrimitive() {
        Object test = "1";

        JsonElement json = new Gson().toJsonTree(test, JsonPrimitive.class);
        Assert.assertNotNull(json);
    }

    @Test
    public void test003DoubleSet() {
        Set<Double> doubleSet = new HashSet<>();
        doubleSet.add(1.11);
        Assert.assertTrue(doubleSet.contains(1.11));
        doubleSet.add(1.17);
        Assert.assertTrue(doubleSet.contains(1.17));
    }

    @Test
    public void test004Int() {
        int i = Integer.parseInt("01");
        Assert.assertEquals(1, i);
        int j = Integer.valueOf("01");
        Assert.assertEquals(1, j);
    }
}
