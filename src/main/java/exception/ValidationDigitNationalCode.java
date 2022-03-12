package exception;

public class ValidationDigitNationalCode extends RuntimeException{

    private String message = "National not valid";
    public ValidationDigitNationalCode(String message) {

        super(message);
    }

    public ValidationDigitNationalCode() {
    }
    public String getMessage()
    {
        return message;
    }
}
