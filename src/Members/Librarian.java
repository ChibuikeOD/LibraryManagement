/**
 * Librarian.java
 * Member of the library with the most permissions
 * @author Chibuike Odibeli
 */
package Members;

public class Librarian extends Member
{

    public Librarian(String name)

    {
        super(name);
        managementPrivileges = true;
        maxResources = 5;
    }
}
