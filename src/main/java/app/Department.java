package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {

    private String name;
    private DepartmentType departmentType;
    private List<Person> personList;

    public Department(String name, app.DepartmentType departmentType) {
        this.name = name;
        this.departmentType = departmentType;
        this.personList = new ArrayList<Person>();
    }


    public void addPersonToDepartment(Person person) throws IllegalArgumentException{

        if (person.getPosition() == Position.CPP_DEVELOPER || person.getPosition() == Position.JAVA_DEVELOPER && this.departmentType == DepartmentType.DEVELOPMENT) {
            personList.add(person);
        }
       else if (person.getPosition() == Position.TRAINING_MANAGER || person.getPosition() == Position.HR_ANALYST && this.departmentType == DepartmentType.HR) {
            personList.add(person);
        }
       else if (person.getPosition() == Position.MARKETING_RESEARCH_SPECIALIST || person.getPosition() == Position.MARKETING_CONSULTANT && this.departmentType == DepartmentType.MARKETING) {
            personList.add(person);
        } else {
            throw new IllegalArgumentException("Cannot move this person to this department.");

        }


    }

    public void switchPerson(Department department, Person person) {

        if (this.personList.contains(person)) {
            department.addPersonToDepartment(person);
            this.personList.remove(person);
        } else {
            throw new NullPointerException("Person is nonexistent.");
        }
    }


    public void removePerson(Person person) {
        this.personList.remove(person);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public app.DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(app.DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                departmentType == that.departmentType &&
                Objects.equals(personList, that.personList);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", departmentType=" + departmentType +
                ", personList=" + personList +
                '}';
    }

}
