package nl.inholland.UniversityDAL;
import nl.inholland.UniversityModel.Report;
import java.util.ArrayList;

public class ReportDao {
    Database database;
       public ReportDao(){
        database = new Database();
    }

    public ArrayList<Report> reportList() {

        return database.reportList;
    }

    public void assignNewGrade(Report report) {

        database.reportList.add(report);
    }


}
