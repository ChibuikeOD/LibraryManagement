/**
 * Teacher.java
 * Class that represents the teachers of the library
 * @author Chibuike Odibeli
 */
package Members;

public class Teacher extends Member{
    public Teacher(String name) {
        super(name);
        managementPrivileges = true;
        maxResources = 3;
    }
}
