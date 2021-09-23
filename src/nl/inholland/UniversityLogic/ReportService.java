package nl.inholland.UniversityLogic;

import nl.inholland.UniversityDAL.ReportDao;
import nl.inholland.UniversityModel.Report;

public class ReportService {
    ReportDao reportDao;

    public ReportService()
    {
        reportDao=new ReportDao();
    }

    public Report getResults (int id){

        for(Report r : reportDao.reportList()) {
            if(id == r.getId()) {
                return r;
            }
        }
        return new Report(id,0,0,0,0);
    }

    public String passed(Report studentReport) {
        if(studentReport.getJava()>=55 && studentReport.getPhp() >=55 && studentReport.getPython()>=55 && studentReport.getCsharp()>=55) {
            return "Passed";
        }
        return "Not passed";
    }
    public int CalculateRetakes(Report studentReport) {
        int retakes = 0;
        if (studentReport.getCsharp()<55) {
            retakes++;
        }
        if(studentReport.getJava()<55) {
            retakes++;
        }
        if(studentReport.getPhp()<55)
        {
            retakes++;
        }
         if(studentReport.getPython()<55)
        {
            retakes++;
        }
         return retakes;
    }

    public void assignNewGrade(Report report) {
        reportDao.assignNewGrade(report);

    }
}