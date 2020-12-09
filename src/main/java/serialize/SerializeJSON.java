package serialize;
import model.Person;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class SerializeJSON {
    ObjectMapper mapper;

    public SerializeJSON() {
        mapper = new ObjectMapper();
    }

    public void serializer(Person obj, File file) throws IOException {
        try {
            mapper.writeValue(file, obj);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Person deserializer(File file) {
        try {
            return mapper.readValue(file, Person.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}



