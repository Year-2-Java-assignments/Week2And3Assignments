package nl.inholland.UniversityModel;

public class Report {
    final private int id;
    private int java;
    private int csharp;
    private int python;
    private int php;
    public Report(int id, int java, int csharp, int python, int php ){
        this.id = id;
        this.csharp = csharp;
        this.java = java;
        this.python = python;
        this.php = php;
    }

    public int getId() {
        return id;
    }

    public int getCsharp() {
        return csharp;
    }

    public int getJava() {
        return java;
    }

    public int getPhp() {
        return php;
    }

    public int getPython() {
        return python;
    }

//    public void setCsharp(int csharp) {
//        this.csharp = csharp;
//    }
//
//    public void setJava(int java) {
//        this.java = java;
//    }
//
//    public void setPhp(int php) {
//        this.php = php;
//    }
//
//    public void setPython(int python) {
//        this.python = python;
//    }


    @Override
    public String toString() {
        return String.format("%10d %10d %10d %10d",java,csharp,python,php);
    }
}
