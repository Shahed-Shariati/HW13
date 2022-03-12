package exception;

public class ValidationLengthNationalCode extends RuntimeException{
    private String message = "National code length not valid";
    public ValidationLengthNationalCode(String message) {
        super(message);

    }

    public ValidationLengthNationalCode() {
    }
    public String getMessage(){
        return message;
    }
}
