package exception;

public class StudentNotFound extends RuntimeException{
    private String message = "Student not found";


    public StudentNotFound() {
    }
    public String getMessage()
    {
        return message;
    }

}
