package beetle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@ControllerAdvice
public class HandleExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomWebException.class)
    public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request){
        WebErrorResponse error = new WebErrorResponse();
            error.setMessage("something goes wrong");
            error.setError(getStackTrace(ex));
            error.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
            error.setErrorTime(new Date());
            error.setUrl(request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
    public static String getStackTrace(Exception ex) {
        String message = null;
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        message = sw.toString();
        return message;
    }
}
