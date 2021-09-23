package nl.inholland.UniversityDAL;

import nl.inholland.UniversityModel.User;


public class ManagerDao{
    Database database;
    public ManagerDao(){
        database = new Database();
    }


    public User getManager(String username, String password) {

        for (int i = 0; i<database.managerList.size(); i++) {

            if (database.managerList.get(i).getUsername().equals(username) && database.managerList.get(i).getPassword().equals(password)) {
                return database.managerList.get(i);
            }
        }
        return null;
    }
//    public ArrayList<Manager>managerList()
//    {
//        return database.managerList;
//    }

    public boolean isAdmin(User user) {

        for(User u : database.managerList) {

            if (user.getId() == u.getId()) {
                return true;
            }
        }
        return false;
    }
}
