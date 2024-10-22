package Exception.Handler;
import Exception.ForeignException;

public class ExceptionHandler{
    public Object codeAlreadyExistException(ForeignException e){
        return e.getLocalizedMessage();
    }
}
