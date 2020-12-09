package serialize;
import model.Person;


import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SerializeXML {
    XmlMapper object;

    public SerializeXML() {
        object = new XmlMapper();
    }

    public void serializer(Person obj, File file) throws IOException {
        try {
            object.writeValue(file, obj);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Person deserializer(File file) {
        try {
            return object.readValue(file, Person.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}