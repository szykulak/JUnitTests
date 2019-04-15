package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Localisation {

    private String name;
    private String city;
    private List<Department> departmentList;

    public Localisation(String name, String city) {
        this.name = name;
        this.city = city;
        this.departmentList = new ArrayList<Department>();
    }

    public void addDepartment(Department department)throws IllegalArgumentException {

       for (Department dept1:departmentList){
           if (dept1.getDepartmentType()==department.getDepartmentType()){
               throw new IllegalArgumentException("Department already exists");
           }
       }
       this.departmentList.add(department);

    }


    public void removeDepartment(Department department) {
        departmentList.remove(department);
    }

    public void switchDepartment(Department department, Localisation localisation) {

        if (this.departmentList.contains(department)) {


            localisation.addDepartment(department);
            removeDepartment(department);

        }


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localisation that = (Localisation) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(departmentList, that.departmentList);
    }

    @Override
    public String toString() {
        return "Localisation{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", departmentList=" + departmentList +
                '}';
    }
}
