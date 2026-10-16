class StudentMarks {
    void CalculateTotal(int m1, int m2) {
        int t=m1+m2;
        System.out.println("Total: " + t);
    }
    void CalculateTotal(int m1, int m2, int m3) {
        int t=m1+m2+m3;
        System.out.println("Total: " + t);
    }
    void CalculateTotal(int m1, int m2, int m3, int m4) {
        int t=m1+m2+m3+m4;
        System.out.println("Total: " + t);
    }
}

public class Student {
    public static void main(String[] args) {
        StudentMarks sm = new StudentMarks();
        sm.CalculateTotal(10, 20);
        sm.CalculateTotal(10, 20, 30);
        sm.CalculateTotal(10, 20, 30, 40);
    }
}