package org.dragon.practice.study.base;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by liuwl on 2018/1/20.
 */
public class ReflectTest {
    public static void main(String[] args)
    {
        try {

            System.out.println(Integer.toBinaryString( 1<<29));
            System.out.println(Integer.toBinaryString( -1<<29));
            Atest a=new Atest();
            a.print();
            System.out.print(a.value);
            Object object=Stuff.class.newInstance();
            if (object.getClass()==Class.forName("org.dragon.practice.study.base.Stuff")) {
                System.out.println("类型正确");

                Class c=object.getClass();
                printInfo("所有对外的公共方法",c.getMethods());

                printInfo("自身所有方法",c.getDeclaredMethods());

                printInfo("父类",c.getSuperclass());

                printInfo("所有对方的公共成员",c.getFields());

                printInfo("自身所有成员",c.getDeclaredFields());
            }

            ArrayList list=new ArrayList<String>();
            list.add("string");
            list.add(1);

            ArrayList<String> list1=new ArrayList<String>();

            for (String s :list1)
            {
                System.out.print(s);
            }

        }
        catch (Exception ex)
        {

        }
    }

    public static void printInfo(String info, Object obj) {
        if (obj.getClass().isArray()) {
            System.out.println(info + ": ");
            int length = Array.getLength(obj);
            System.out.println("Array Size: " + length);
            for (int i = 0; i < length; i++) {
                System.out.print("Array[" + i + "]: " + Array.get(obj, i) + ", ");
            }
            if (length != 0)
                System.out.println();
        }
        System.out.println(info + ": " + obj.toString());
    }
}
