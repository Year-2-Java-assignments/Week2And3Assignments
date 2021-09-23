package nl.inholland.UniversityLogic;

import nl.inholland.UniversityDAL.ManagerDao;
import nl.inholland.UniversityModel.Manager;
import nl.inholland.UniversityModel.User;

public class ManagerService {

    public ManagerDao managerDao;

    public ManagerService() {

        managerDao = new ManagerDao();
    }

    public Manager getManager(String username, String password) {

        return (Manager) managerDao.getManager(username, password);
    }
//    public ArrayList<Manager> managerList(){
//        return managerDao.managerList();
//    }

    public boolean isAdmin(User user) {

        return managerDao.isAdmin(user);
    }
}
