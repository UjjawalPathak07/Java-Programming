class Student {
    String stuid;
    String stuname;
    String depart;
    void displayStudentDetails(String s, String sn, String dep) {
        stuid = s;
        stuname = sn;
        depart = dep;
        System.out.println("Student ID: " + stuid);
        System.out.println("Student Name: " + stuname);
        System.out.println("Department: " + depart);
    }
}
class UndergraduateStu extends Student {
    int semester;
    double cgpa;
    void displayUndergraduateDetails(int sem, double cg) {
        semester = sem;
        cgpa = cg;
        System.out.println("Semester: " + semester);
        System.out.println("CGPA: " + cgpa);
    }
}
class PostgraduateStu extends Student {
    String specialization;
    String researchTopic;
    void displayPostgraduateDetails(String sp, String re) {
        specialization = sp;
        researchTopic = re;
        System.out.println("Specialization: " + specialization);
        System.out.println("Research Topic: " + researchTopic);
    }
}
public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.displayStudentDetails("123", "Kevin", "CSE");
        System.out.println();
        UndergraduateStu undergraduate = new UndergraduateStu();
        undergraduate.displayStudentDetails("124", "Rahul", "CSE");
        undergraduate.displayUndergraduateDetails(3, 8.5);
        System.out.println();
        PostgraduateStu postgraduate = new PostgraduateStu();
        postgraduate.displayStudentDetails("125", "Aman", "CSE");
        postgraduate.displayPostgraduateDetails("Machine Learning", "AI");
    }
}