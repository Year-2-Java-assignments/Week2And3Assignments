package nl.inholland.UniversityLogic;
import nl.inholland.UniversityDAL.StudentDao;
import nl.inholland.UniversityModel.Student;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentService {
    StudentDao studentDao;
    public StudentService() {
        studentDao = new StudentDao();
    }

    public Student getStudent(String username, String password) {
        return (Student) studentDao.getStudent(username,password);
    }

    public ArrayList<Student> studentList(){
        return studentDao.studentList();
    }

    public void addStudent (String firstName, String lastName, LocalDate birthday, String group, String username, String password) {
        studentDao.addStudent(firstName,lastName,birthday,group,username,password);

    }

    public Student getStudent (int id) {
        return studentDao.getStudent(id);
    }
}
