package nl.inholland.UniversityDAL;
import java.util.ArrayList;

import nl.inholland.UniversityModel.Teacher;
import nl.inholland.UniversityModel.User;

public class TeacherDao {
    Database database;

    public TeacherDao(){
        database = new Database();

    }

    public User getTeacher(String username, String password) {

        for (int i = 0; i<database.teacherList.size(); i++) {

            if (database.teacherList.get(i).getUsername().equals(username) && database.teacherList.get(i).getPassword().equals(password)){

                return database.teacherList.get(i);
            }
        }
        return null;
    }
    public ArrayList<Teacher> teacherList()
    {
        return database.teacherList;
    }

}
