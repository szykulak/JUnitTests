import app.Person;
import app.Position;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PersonTest { // czy podczas tworzenia pracownika z błędnymi danymi zwracany jest wyjątek
@Test (expected=IllegalArgumentException.class)

public void test1() {
    Person person1 = new Person("", "Szykula", new Date(1997, 10, 16), "97101607308", Position.JAVA_DEVELOPER);

}

@Test
    public void test2(){
        Person person = new Person("Karolina", "Szykula",new Date(1997,10,16),"97101607308", Position.CPP_DEVELOPER);
    assertEquals(person.getName(),"Karolina");
    assertEquals(person.getSurname(),"Szykula");
    assertEquals(person.getBirthDate(),new Date(1997,10,16));
    assertEquals(person.getPesel(),"97101607308");
    assertEquals(person.getPosition(),Position.CPP_DEVELOPER);


}


}
