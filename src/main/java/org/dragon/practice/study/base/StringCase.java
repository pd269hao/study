package org.dragon.practice.study.base;

import java.io.Serializable;

/**
 * Created by liuwl on 2018/1/17.
 */
public class StringCase implements Serializable {

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        String s4 = "ming";
        String s5 = "Program" + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        System.out.println(s1 == s5);

    }
}
