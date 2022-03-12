package exception;

public class UserNotFound extends RuntimeException{
    private String message = "User not found";


    public UserNotFound() {
    }
    public String getMessage()
    {
        return message;
    }
}
