package com.sean.base.unit;

import org.junit.Assert;
import org.junit.Test;

public class TestJvmCmdParam {
    /**
     * 测试jvm -D 参数，请在配置中添加d.config 配置
     */
    @Test
    public void testDParam() {
        System.out.println(System.getProperty("d.config"));
        Assert.assertEquals("hello", System.getProperty("d.config"));
    }
}
