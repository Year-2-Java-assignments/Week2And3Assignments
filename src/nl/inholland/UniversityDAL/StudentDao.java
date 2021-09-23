package nl.inholland.UniversityDAL;
import java.time.LocalDate;
import java.util.ArrayList;

import nl.inholland.UniversityModel.Student;
import nl.inholland.UniversityModel.User;

public class StudentDao {

    Database database;
    public StudentDao(){
        database = new Database();
    }



    public User getStudent(String username, String password) {

        for (int i = 0; i<database.studentList.size(); i++) {

            if (database.studentList.get(i).getUsername().equals(username) && database.studentList.get(i).getPassword().equals(password)) {
                return database.studentList.get(i);
            }
        }
        return null;
    }
    public ArrayList<Student> studentList()
    {
        return database.studentList;
    }

    public void addStudent(String firstName, String lastName, LocalDate birthday, String group, String username, String password){
        Student student = new Student(database.studentList.size()+1,firstName,lastName,birthday,group,username,password);
        database.studentList.add(student);
    }

    public Student getStudent(int id)
    {
        for(Student student: database.studentList){
            if(student.getId() == id)
            {
                return student;
            }
        }
        return null;
    }
}
