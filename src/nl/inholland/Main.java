package nl.inholland;

import nl.inholland.UniversityLogic.*;
import nl.inholland.UniversityModel.Report;
import nl.inholland.UniversityModel.Student;
import nl.inholland.UniversityModel.User;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main myMain = new Main();
         myMain.start();
    }

    void start() {
        User user = login();
        loadAccessOptions(user);
    }

    User login(){

        LoginService loginService = new LoginService();
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        User user;
        do {

            System.out.print("Enter username:");
            username = scanner.nextLine();
            System.out.print("Enter password:");
            password = scanner.nextLine();
            user = loginService.getUser(username, password);

        } while (user == null);
        System.out.println();

        return loginService.getUser(username, password);
    }

    void loadAccessOptions(User user)
    {
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        ManagerService managerService = new ManagerService();
        ReportService reportService = new ReportService();


        if(teacherService.getTeacher(user.getUsername(), user.getPassword()) != null) {
            loadEditorAccess(user,studentService,teacherService,reportService);
        }
        else if (managerService.getManager(user.getUsername(), user.getPassword())!= null){
            loadAdminAccess(user,studentService,teacherService,reportService);
        }
        else if (studentService.getStudent(user.getUsername(), user.getPassword()) != null ) {
            loadBasicAccess(studentService,teacherService);
        }
    }

    void loadBasicAccess(StudentService studentService, TeacherService teacherService) {


        String choice;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("S. Display Students | T. Display Teachers | x. Exit |");
            System.out.print("Please, enter a choice: ");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("s")) {

                showListOfStudents(studentService);
            } else if (choice.equalsIgnoreCase("t")) {

                showListOfTeachers(teacherService);
            }

        } while (!choice.equalsIgnoreCase("x"));

    }


    void loadEditorAccess(User user, StudentService studentService, TeacherService teacherService, ReportService reportService) {

        String choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("S. Display Students | T. Display Teachers | A. Add Students | R. Display Reports | x. Exit |");
            System.out.print("Please, enter a choice: ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("s")) {

                showListOfStudents(studentService);
            } else if (choice.equalsIgnoreCase("t")) {

                showListOfTeachers(teacherService);
            } else if (choice.equalsIgnoreCase("a")) {
                showAddStudent(studentService);

            } else if (choice.equalsIgnoreCase("r")) {
                showStudentReport(user, reportService, studentService, teacherService);
            }
        } while (!choice.equalsIgnoreCase("x"));

        System.out.println("Leaving the program ....");
        System.exit(0);


    }

    void loadAdminAccess(User user, StudentService studentService, TeacherService teacherService, ReportService reportService) {

        loadEditorAccess(user, studentService, teacherService, reportService);
    }

    void showListOfStudents(StudentService studentService){
        System.out.println("LIST OF STUDENTS\n");

        String title = "Id firstname lastname Birthdate Age Group";
        String [] titleSplitWord = title.split(" ");
        System.out.printf("%s %10s %9s %10s %4s %7s",titleSplitWord[0],titleSplitWord[1],titleSplitWord[2], titleSplitWord[3],titleSplitWord[4],titleSplitWord[5]);
        System.out.println();
        for (String s: title.split("")) {

            if (!s.equals(" ")) {

                System.out.print("*");
            }
            else {

                System.out.print("  ");
            }
        }
        System.out.println();
        for (User s: studentService.studentList()) {

            System.out.println(s);
        }
        System.out.println();
    }

    void showListOfTeachers(TeacherService teacherService){

        System.out.println("LIST OF TEACHERS\n");
        String title = "Id firstname lastname Birthdate Age";
        String [] titleSplitWord = title.split(" ");
        System.out.printf("%s %10s %9s %10s %4s ",titleSplitWord[0],titleSplitWord[1],titleSplitWord[2], titleSplitWord[3],titleSplitWord[4]);
        System.out.println();
        for (String s: title.split("")) {
            if (!s.equals(" ")) {

                System.out.print("*");
            }
            else {
                System.out.print("  ");
            }
        }
        System.out.println();

        for (User t: teacherService.teacherList()) {

            System.out.println(t);
        }
        System.out.println();
    }

    void showAddStudent(StudentService studentService){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nADD STUDENT");
        System.out.println();
        System.out.print("Choose username: ");
        String username = scanner.nextLine();
        System.out.print("Choose password: ");
        String password = scanner.nextLine();
        System.out.print("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.print("Please enter date of birth in MM/DD/YYYY: ");
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthdate = LocalDate.parse(scanner.next(),dtf);

        System.out.print("Enter group:");
        String group = scanner.next();
        System.out.println();
        studentService.addStudent(firstName,lastName,birthdate,group,username,password);

    }

    void showStudentReport(User user,ReportService reportService, StudentService studentService,TeacherService teacherService) {
        System.out.println("\nSTUDENT RESULTS\n");

        String title = "Id firstname lastname Birthdate Age Group Java CSharp Python PHP";
        String [] titleSplitWord = title.split(" ");
        System.out.printf("%s %10s %9s %10s %4s %7s %4s %4s %4s %4s",titleSplitWord[0],titleSplitWord[1],titleSplitWord[2], titleSplitWord[3],titleSplitWord[4],titleSplitWord[5],
                                                    titleSplitWord[6],titleSplitWord[7],titleSplitWord[8],titleSplitWord[9]);
        System.out.println();
        for (String s: title.split("")) {

            if (!s.equals(" ")) {

                System.out.print("*");
            }
            else {

                System.out.print("  ");
            }
        }
        System.out.println();

        for (User s: studentService.studentList()) {

            System.out.print(s);
            Report report= reportService.getResults(s.getId());
            System.out.print(report.toString());
            System.out.println();
        }
        System.out.println();
        showReportDetails(user,reportService,studentService,teacherService);
    }

    void showReportDetails(User user, ReportService reportService, StudentService studentService, TeacherService teacherService) {
        ManagerService managerService = new ManagerService();
        Scanner scanner = new Scanner(System.in);
        int studentId;
        String choice;

        if (managerService.isAdmin(user)) {
            System.out.print("Enter V. Save Reports | Or I to see more options: ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("V")) {
                printReport(studentService, reportService);
                System.out.println("Reports are saved");
            }
        }

        System.out.print("Enter student id(Report Details) |  Or 0 to back to main menu: ");
        studentId = scanner.nextInt();

        while (studentId != 0) {
            Student student = studentService.getStudent(studentId);
            Report studentReport = reportService.getResults(studentId);
            System.out.print("Report of student " + student.getFirstName() + " " + student.getLastName());
            System.out.println();
            System.out.println("Student Id ......................." + student.getId());
            System.out.println("First Name ......................." + student.getFirstName());
            System.out.println("Last Name ......................." + student.getLastName());
            System.out.println("Age ......................." + student.getAge());
            System.out.println();
            showCourseDetails(studentReport);
            System.out.println();
            showResultsDetails(reportService, studentReport);
            updateReportOptions(user, studentReport, reportService, studentService, teacherService);
        }
        loadEditorAccess(user,studentService,teacherService,reportService);

    }
    void showCourseDetails(Report studentReport) {

        System.out.println("COURSES");
        System.out.println();
        System.out.println("Java ......................." + studentReport.getJava());
        System.out.println("CSharp ......................." + studentReport.getCsharp());
        System.out.println("Python ......................." + studentReport.getPython());
        System.out.println("PHP ......................." + studentReport.getPhp());
    }
    void showResultsDetails(ReportService reportService, Report studentReport) {

        System.out.println("RESULTS");
        System.out.println();
        String result = reportService.passed(studentReport);
        int retakes = reportService.CalculateRetakes(studentReport);
        System.out.println("Results ......................." + result);
        System.out.println("Retakes......................."+ retakes) ;
        System.out.println();
    }

    void updateReportOptions(User user,Report studentReport,ReportService reportService,StudentService studentService,TeacherService teacherService)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("A. Add (Update) Report | R. Display reports | B. Back to Main | X. Exit");

        System.out.println();
        System.out.print("Please enter a choice select a menu: ");
        String choice = scanner.nextLine();
        System.out.println();

        while (!choice.equalsIgnoreCase("x")) {
            if(choice.equalsIgnoreCase("a")) {
                updateReport(studentReport,reportService);
            }
            else if(choice.equalsIgnoreCase("b")) {
                loadEditorAccess(user,studentService,teacherService,reportService);
            }
            else if(choice.equalsIgnoreCase("r")) {
                showStudentReport(user,reportService,studentService,teacherService);
            }
            else if(choice.equalsIgnoreCase("v") ) {
               printReport(studentService,reportService);
            }
            System.out.print("Select a menu: ");
            choice  = scanner.next();
        }
        System.out.println("Leaving the program now ...");
        System.exit(0);

    }

    void updateReport(Report studentReport, ReportService reportService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Current grade Java is "+ studentReport.getJava() + " Enter (new) grade: ");
        int newJavaGrade = scanner.nextInt();

        System.out.print("Current grade CSharp " + studentReport.getCsharp() + " Enter (new) grade: ");
        int newCSharpGrade = scanner.nextInt();

        System.out.print("Current grade Python "+ studentReport.getPython() + " Enter (new) grade: ");
        int newPythonGrade = scanner.nextInt();

        System.out.print("Current grade PHP " + studentReport.getPhp() + " Enter (new) grade: ");
        int newPHPGrade = scanner.nextInt();

        reportService.assignNewGrade(new Report(studentReport.getId(), newJavaGrade, newCSharpGrade, newPythonGrade, newPHPGrade));

    }
    void printReport (StudentService studentService, ReportService reportService) {

        for(User s : studentService.studentList()) {
            try {
                FileWriter writer = new FileWriter(s.getId()+ " "+ s.getFirstName() + " "+ s.getLastName());
                writer.write("Report of " + s.getFirstName() + " " + s.getLastName()+ "\n");
                writer.write("\n");
                writer.write("Student Id .............................." + s.getId());
                writer.write("\nFirst Name ......................." + s.getFirstName());
                writer.write("\nLast Name ........................." + s.getLastName());
                writer.write("\nAge ...................................." + s.getAge());
                Report report = reportService.getResults(s.getId());
                writer.write("\n");
                writer.write("\nCOURSES\n");

                writer.write("\nJava ............................." + report.getJava());
                writer.write("\nCSharp ........................." + report.getCsharp());
                writer.write("\nPython ........................." + report.getPython());
                writer.write("\nPHP ..............................." + report.getPhp());
                writer.write("\n");
                writer.write("\nRESULT\n");
                String result = reportService.passed(report);
                int retakes = reportService.CalculateRetakes(report);
                writer.write("\nResults ......................." + result);
                writer.write("\nRetakes......................."+ retakes) ;
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
