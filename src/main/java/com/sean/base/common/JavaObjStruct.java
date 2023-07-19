package com.sean.base.common;

import org.openjdk.jol.info.ClassLayout;

/**
 * java的Obj内存的模型
 * @author sean
 */
public class JavaObjStruct {

    public static class StructObj {
        private int i;
        private Boolean b;
        private double d;
        private Float f;
        private char c;
    }

    public static void main(String[] args) {
        ClassLayout classLayout = ClassLayout.parseInstance(new StructObj());
        System.out.println(classLayout.toPrintable());
    }

}
