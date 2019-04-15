package app;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Person {

    private String name;
    private String surname;
    private Date birthDate;
    private String pesel;
    private Position position;




    public Person(String name, String surname, Date birthDate, String pesel, Position position)  {
       if (PeselList.getInstance().getPeselList().contains(pesel)) {
            throw new IllegalArgumentException("Employee already exists in the system.");
        } else {
            PESELValidator pesel1 = new PESELValidator(pesel);
            if (!pesel1.isValid()) {
                throw new IllegalArgumentException("Invalid PESEL number.");
            } else {
                this.pesel = pesel;
            }
            if (pesel1.getBirthYear() > 2001) {
                throw new IllegalArgumentException("Underage candidate.");
            } else {
                this.birthDate = birthDate;
          }

            if (name.length() == 0 || surname.length() == 0) {
                throw new IllegalArgumentException("Neither name nor surname can be empty.");
            } else {
                this.name = name;
                this.surname = surname;

            }
            this.position = position;
        }
    }
    public Person() {
            this.name = " ";
            this.surname = " ";
            this.birthDate = new Date(); //?
            this.pesel = " ";
            this.position = Position.JAVA_DEVELOPER;
        }



        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getSurname () {
            return surname;
        }

        public void setSurname (String surname){
            this.surname = surname;
        }

        public Date getBirthDate () {
            return birthDate;
        }

        public void setBirthDate (Date birthDate){
            this.birthDate = birthDate;
        }

        public String getPesel () {
            return pesel;
        }

        public void setPesel (String pesel){
            this.pesel = pesel;
        }

        public Position getPosition () {
            return position;
        }

        public void setPosition (Position position){
            this.position = position;
        }

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(surname, person.surname) &&
                    Objects.equals(birthDate, person.birthDate) &&
                    Objects.equals(pesel, person.pesel) &&
                    position == person.position;
        }

        @Override
        public String toString () {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", birthDate=" + birthDate +
                    ", pesel='" + pesel + '\'' +
                    ", position=" + position +
                    '}';
        }
    }
