/**
 * Student.java
 * Class that represents the students. They are the member with the least permissions
 * @author Chibuike Odibeli
 */
package Members;

public class Student extends Member
{

    public Student(String name) {
        super(name);
        managementPrivileges = false;
        maxResources = 1;
    }
}
