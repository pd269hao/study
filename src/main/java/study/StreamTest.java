package study;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Created by liuwl on 2018/1/20.
 */
public class StreamTest implements  Serializable {

    public static void main(String[] args)
    {
        new  StreamTest().test();
    }

    public void test()
    {
        try {
            User user=new User();
            user.setAge(1);
            user.setName("asdf");
            Stuff stuff=new Stuff();
            stuff.setName("rock");
            stuff.setValue(2.0);
            stuff.setWeight(10);
            OutputStream out= new FileOutputStream("a.txt");
            ObjectOutputStream os=new ObjectOutputStream(out);
            os.writeObject(user);
            os.close();


        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    class User implements Serializable
    {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
