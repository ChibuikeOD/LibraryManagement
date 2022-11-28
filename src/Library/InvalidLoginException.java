package Library;

public class InvalidLoginException extends Exception
{
    public InvalidLoginException()
    {
        super("Unable to log in. Please try again ");
    }
}
