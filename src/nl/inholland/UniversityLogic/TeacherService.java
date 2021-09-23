package nl.inholland.UniversityLogic;
import nl.inholland.UniversityDAL.TeacherDao;
import nl.inholland.UniversityModel.Teacher;

import java.util.ArrayList;

public class TeacherService {
    TeacherDao teacherdao;
    public TeacherService()
    {
        teacherdao = new TeacherDao();
    }

    public Teacher getTeacher(String username, String password) {
        return (Teacher) teacherdao.getTeacher(username,password);
    }

    public ArrayList<Teacher> teacherList(){
        return teacherdao.teacherList();
    }
}
