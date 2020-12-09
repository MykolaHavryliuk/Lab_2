package serialize;

import model.Person;
import java.time.LocalDate;
import java.io.*;

public class SerializeTXT {

    public void serializer(Person obj, File file) throws IOException {
        try(FileWriter fw = new FileWriter(file)){
            String str = "Gender: " + ((model.Person) obj).getGender() + " Name: " + ((model.Person) obj).getName() + " Surname: " + ((model.Person) obj).getSurname() + " Birthdate: " + ((model.Person) obj).getYear();
            fw.write(str);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Person deserializer(File file) throws IOException {
        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = fr.readLine()) != null && str.length() != 0) {
                String[] values = str.split(" ");
                return new Person.Builder(values[3], values[5]).setGender(Person.Gender.valueOf(values[1])).setYear(Integer.parseInt(values[7])).build();
            }
        }
//        catch (IOException e) {
        throw new RuntimeException("File is empty");
//        }
    }
}
