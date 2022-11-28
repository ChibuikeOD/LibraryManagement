/**
 * Member.java
 * Abstract class that holds general data for members of the library
 * @author Chibuike Odibeli
 */
package Members;

import LibResources.InvalidResourceException;
import LibResources.LibraryResource;
import Loans.ResourceLoan;

import java.util.ArrayList;
import java.util.Scanner;

public class Member
{
    protected String name;
    protected ArrayList<ResourceLoan> loans;
    protected int maxResources;
    protected boolean managementPrivileges;


    Member(String name)
    {
        this.name = name;
        loans = new ArrayList<ResourceLoan>();
    }
    /**
     *
     * @return The name of the member
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @return An arraylist of the active loans a member has
     */
    public ArrayList<ResourceLoan> getAllLoans()
    {
        return loans;
    }

    /**
     *
     * @return The maximum number of resources a member can have
     */
    public int getMaxResources()
    {
        return maxResources;
    }

    /**
     * Lets the member borrow a resource from the library
     * @return A loan object to keep track of the resource
     */


    /**
     * Lets the member return a previously borrowed resource to the library
     */
    public void returnResource(String input) throws InvalidResourceException {
        LibraryResource found = null;
        do {
            for (int i = 0; i <= loans.size() - 1; i++) {
                if (input.equalsIgnoreCase(loans.get(i).getItem().getTitle())) {
                    found = loans.get(i).getItem();
                    System.out.println("Your resource has been found");
                    loans.remove(loans.get(i));

                }
            }
            if (found == null) {
                throw new InvalidResourceException();
            }
        }while (found == null);


        System.out.println("Your resource has been returned");
    }


    public boolean getManagementPrivileges()
    {
        return managementPrivileges;
    }

    public void addLoan(ResourceLoan newLoan)
    {
        loans.add(newLoan);
    }




}
