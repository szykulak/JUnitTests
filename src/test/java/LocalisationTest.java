import app.*;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LocalisationTest {
@Test
    public void test1(){
    Department dept =new Department("D1", DepartmentType.HR);
    Localisation loc1=new Localisation("Czyzyny", "Krakow");
    Localisation loc2=new Localisation("Mokotow", "Warszawa");
   loc1.addDepartment(dept);

    int loc1Size=loc1.getDepartmentList().size();
    int loc2Size=loc2.getDepartmentList().size();
    loc1.switchDepartment(dept,loc2);
    assertNotEquals(loc1Size,loc1.getDepartmentList().size());
    assertNotEquals(loc2Size,loc2.getDepartmentList().size());
}
    @Test (expected = IllegalArgumentException.class)
    public void test2() {
        Department dept = new Department("D1", DepartmentType.HR);
        Department dept2=new Department("D2",DepartmentType.HR);
        Localisation loc1 = new Localisation("Czyzyny", "Krakow");
        Localisation loc2 = new Localisation("Mokotow", "Warszawa");
        loc1.addDepartment(dept);
        loc2.addDepartment(dept2);
        loc1.switchDepartment(dept,loc2);



    }
    @Test
    public void test3(){
        Person person = new Person("Andrzej", "Kowalski",new Date(1952,06,21),"52062144778", Position.HR_ANALYST);
        Person person2 = new Person("Paweł", "Nowak",new Date(1947,12,27),"47122767965", Position.MARKETING_CONSULTANT);
        Person person3 = new Person("KArolina", "Szykuła",new Date(1995,12,30),"95123038142", Position.HR_ANALYST);

        Department dept1=new Department("D1",DepartmentType.HR);
        Department dept2=new Department("D2",DepartmentType.HR);

        Localisation l1=new Localisation("Nowa Huta","Krakow");
        Localisation l2=new Localisation("Rakow","Czestochowa");

        dept1.addPersonToDepartment(person);
        dept2.addPersonToDepartment(person3);

        l1.addDepartment(dept1);
        l2.addDepartment(dept2);

        Company company = new Company(person,person2,person3);
        company.addLocalisation(l1);
        company.addLocalisation(l2);

        int employeeAmount= company.countEmployees();
        dept1.switchPerson(dept2,person);
        assertEquals(employeeAmount,company.countEmployees());


    }




}




