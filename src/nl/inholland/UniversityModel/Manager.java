package nl.inholland.UniversityModel;
import java.time.LocalDate;

public class Manager extends User {

    public Manager(int id, String firstName, String lastName, LocalDate birthday, String username, String password) {
        super(id,firstName,lastName,birthday,username, password);
    }
}
