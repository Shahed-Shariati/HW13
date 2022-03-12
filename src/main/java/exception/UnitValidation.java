package exception;

public class UnitValidation extends RuntimeException{
    private String message = "Unit out of range";


    public UnitValidation() {
    }
    public String getMessage()
    {
        return message;
    }
}
