package org.dragon.practice.study.base;

/**
 * Created by liuwl on 2018/1/18.
 */
public class ExceptionTest {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

class Human {


}