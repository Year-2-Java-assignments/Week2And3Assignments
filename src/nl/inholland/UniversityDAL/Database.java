package nl.inholland.UniversityDAL;

import nl.inholland.UniversityModel.*;



import java.time.LocalDate;

import java.util.ArrayList;

public class Database {
   public ArrayList<Manager> managerList;
    public ArrayList<Student> studentList;
    public ArrayList<Teacher> teacherList;
    public ArrayList<Report>reportList;

    public Database() {
        managerList = new ArrayList<>();
        studentList = new ArrayList<>();
        teacherList=new ArrayList<>();
        reportList= new ArrayList<>();
        DatabaseInfo();

    }

    private void DatabaseInfo() {

        teacherList.add(new Teacher(11,"David","Taylor",LocalDate.of(1965,6,15),"david","david06"));
        teacherList.add(new Teacher(12,"Sophy","Anderson", LocalDate.of(1987,1,6),"sophy","sophie01"));
        teacherList.add(new Teacher(13,"James","Jordon",LocalDate.of(1956,3,19),"james","james03"));
        teacherList.add(new Teacher(14,"Susan","Jackson", LocalDate.of(1978, 12, 25),"susan","susan12"));
        teacherList.add(new Teacher(15,"Mary","Lee",LocalDate.of(1971, 9, 4),"mary","mary09"));

        studentList.add(new Student(1,"Emma","Smith",LocalDate.of(1997,12,4), "IT-02-A","emma","emma12"));
        studentList.add(new Student(2,"Jack","Brown",LocalDate.of(1993,8,7), "IT-02-A","jack","jack08"));
        studentList.add(new Student(3,"Michael","Garcia",LocalDate.of(1999,11,1), "IT-02-A","michael","michael11"));
        studentList.add(new Student(4,"Lisa","Jones",LocalDate.of(2000,4,29), "IT-02-A","lisa","lisa04"));
        studentList.add(new Student(5,"John","Miller",LocalDate.of(2001,10,27), "IT-02-A","john","john10"));
        studentList.add(new Student(6,"Linda","Martinez",LocalDate.of(2002,1,17), "IT-02-A","linda","linda01"));
        studentList.add(new Student(7,"Richard","Davis",LocalDate.of(1997,9,22), "IT-02-A","richard","richard09"));
        studentList.add(new Student(8,"Mark","Lopez",LocalDate.of(1996,12,9), "IT-02-A","mark","mark12"));
        studentList.add(new Student(9,"Deborah","Hernandez",LocalDate.of(1995,2,25), "IT-02-A","deborah","deborah02"));
        studentList.add(new Student(10,"Rick","Moore",LocalDate.of(2000,3,16), "IT-02-A","rick","rick03"));

        reportList.add(new Report(1,54,66,54,54 ));
        reportList.add(new Report(2,72,68,43,95 ));
        reportList.add(new Report(3,45,71,55,84 ));
        reportList.add(new Report(4,98,64,81,72 ));
        reportList.add(new Report(5,100,94,99,93 ));
        reportList.add(new Report(6,55,79,81,55 ));
        reportList.add(new Report(7,51,64,39,59 ));
        reportList.add(new Report(8,78,98,89,99 ));
        reportList.add(new Report(9,59,55,67,99 ));
        reportList.add(new Report(10,96,87,55,82 ));


        managerList.add(new Manager(20,"Donny","Lopez",LocalDate.of(2000,1,21),"donny","donny01"));


    }
}
