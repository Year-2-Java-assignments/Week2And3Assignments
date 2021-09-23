package nl.inholland.UniversityModel;


import java.time.LocalDate;

public class Teacher extends User{

    public Teacher(int id, String firstName, String lastName, LocalDate birthday, String username, String password) {
        super(id,firstName,lastName,birthday,username, password);

    }

    @Override
    public String toString() {
        return String.format("%s",super.toString());
    }
}
