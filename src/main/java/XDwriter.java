
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
//https://stackify.com/java-xml-jackson/
public class XDwriter {

    public static void main(String[] args) {

        XmlMapper xmlMapper = new XmlMapper();

        try {
            String s = xmlMapper.writeValueAsString(new Person());


            System.out.println(s);


            Person person = xmlMapper.readValue(s, Person.class);
            System.out.println(person.getAge()+"  "+person.getName());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
