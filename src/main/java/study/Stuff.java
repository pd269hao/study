package study;

import sun.nio.ch.ThreadPool;

import java.io.Serializable;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by liuwl on 2018/1/20.
 */
public class Stuff implements Serializable {

    private int weight;
    private double value;
    private String name;

    public static String location="Peony";

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void testPrivate()
    {}

    public static String getString(int multiple)
    {
        return location+":"+multiple+"番";
    }
    @Override
    public boolean equals(Object s)
    {
        return true;
    }
}
