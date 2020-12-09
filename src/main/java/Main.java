import model.Person;
import serialize.SerializeJSON;
import serialize.SerializeTXT;
import serialize.SerializeXML;

import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person.Builder("Colia", "Havlriliuk").setGender(Person.Gender.male).setYear(2000).build();
        Person person2 = new Person.Builder("none", "none").setGender(Person.Gender.female).setYear(2002).build();
        Person person3 = new Person.Builder("none", "none").setGender(Person.Gender.child).setYear(2010).build();

        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();

        SerializeJSON serialize1 = new SerializeJSON();
        SerializeXML serialize2 = new SerializeXML();
        SerializeTXT serialize3 = new SerializeTXT();

        try {
            serialize1.serializer(person1, new File("1.json"));
            serialize2.serializer(person2, new File("1.XML"));
            serialize3.serializer(person3, new File("1.txt"));
        }
        catch (Exception error){
            error.printStackTrace();
        }

        try {
            person4 = serialize1.deserializer(new File("1.json"));
            person5 = serialize2.deserializer(new File("1.XML"));
            person6 = serialize3.deserializer(new File("1.txt"));
        }
        catch (Exception error){
            error.printStackTrace();
        }

        System.out.println(person4);
        System.out.println(person5);
        System.out.println(person6);
    }
}
