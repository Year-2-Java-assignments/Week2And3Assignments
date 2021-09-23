package nl.inholland.UniversityModel;
import java.time.LocalDate;

public class Student extends User{

    String group;

    public Student(int id, String firstName, String lastName, LocalDate birthday, String group, String username, String password) {
        super(id,firstName,lastName,birthday,username, password);

        this.group = group;
    }

    @Override
    public String toString()
    {
         return String.format("%s %s",super.toString(),group);
    }
}
