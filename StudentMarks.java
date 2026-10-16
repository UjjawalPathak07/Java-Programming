class InvalidMarksException extends Exception{
    InvalidMarksException(String message){
        super(message);
    }
}
class StudentMarks{
    public static void main(String[] args) {
        int marks = 93;
        try {
            if(marks < 0 || marks > 100){
                throw new InvalidMarksException("Marks should be between 0 and 100");
            }
            System.out.println("Marks: " + marks);
        } catch (InvalidMarksException e) {
            System.out.println(e.getMessage());
        }
    }    
}
