package nl.inholland.UniversityLogic;
import nl.inholland.UniversityDAL.ManagerDao;
import nl.inholland.UniversityDAL.StudentDao;
import nl.inholland.UniversityDAL.TeacherDao;
import nl.inholland.UniversityModel.User;

public class LoginService {

    TeacherDao teacherDao;
    StudentDao studentDao;
    ManagerDao managerDao;

    public LoginService(){
        teacherDao = new TeacherDao();
        studentDao = new StudentDao();
        managerDao = new ManagerDao();
    }


    public User getUser(String username,String password){
        if (teacherDao.getTeacher(username,password)!= null) {

            return teacherDao.getTeacher(username,password);
        }
        else if (studentDao.getStudent(username,password) != null){

            return studentDao.getStudent(username,password);
        }
        else if (managerDao.getManager(username,password) != null){

            return managerDao.getManager(username, password);
        }
        return null;
    }
}
