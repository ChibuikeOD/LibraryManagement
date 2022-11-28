/**
 * InvalidResourceType.java
 * Exception that handles invalid resource types
 * @author Chibuike Odibeli
 */
package LibResources;


public class InvalidResourceException extends Exception
{
    public InvalidResourceException()
    {
        super("Invalid Resource. Please try again.");
    }
}
