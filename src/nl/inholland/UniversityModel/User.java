package nl.inholland.UniversityModel;
import java.time.LocalDate;
import java.time.Period;


public abstract class User {
    final private String username;
    final private String password;
    final private int id;
    final private String firstName;
    final private String lastName;
    final private LocalDate birthday;
    private int age;

    public User(int id, String firstName, String lastName, LocalDate birthday, String username, String password){
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        setAge();
    }


    private void setAge() {

        Period ageDiff = Period.between(birthday, LocalDate.now());
        if (LocalDate.now().getDayOfYear() < birthday.getDayOfYear()) {
            this.age = ageDiff.getYears() - 1;
        }
        this.age = ageDiff.getYears();
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString()
    {
        return String.format("%s %10s %9s %10s %4s",id ,firstName , lastName , birthday,age) ;
    }
}
