package beetle.exception;

public class CustomWebException extends RuntimeException {
    public  CustomWebException(Exception ex){
        super(ex);
    }
}
