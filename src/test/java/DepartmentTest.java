import app.Department;
import app.DepartmentType;
import app.Person;
import app.Position;
import org.junit.Test;

import java.util.Date;
import static junit.framework.TestCase.assertTrue;

public class DepartmentTest {

@Test
    public void test1(){
    Department dept=new Department("D1", DepartmentType.HR);
    Person person = new Person("Karolina", "Szykula",new Date(1997,10,16),"97101607308", Position.HR_ANALYST);
dept.addPersonToDepartment(person);
assertTrue(dept.getPersonList().contains(person));

}
    @Test (expected=IllegalArgumentException.class)
    public void test2(){
        Department dept=new Department("D1", DepartmentType.DEVELOPMENT);
        Person person = new Person("Karolina", "Szykula",new Date(1997,10,16),"97101607308", Position.HR_ANALYST);
        dept.addPersonToDepartment(person);

    }
    @Test
    public void test3(){
        Department dept=new Department("D1", DepartmentType.HR);
        Department dept2=new Department("D2", DepartmentType.HR);
        Person person = new Person("Karolina", "Szykula",new Date(1997,10,16),"97101607308", Position.HR_ANALYST);
        dept.addPersonToDepartment(person);
        dept.switchPerson(dept2,person);
        assertTrue(dept2.getPersonList().contains(person));


    }


}
