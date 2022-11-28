/**
 * LibraryResource.java
 * Class that represents the resources of the library
 * @author Chibuike Odibeli
 */
package LibResources;

import Loans.ResourceLoan;

import java.util.UUID;

public class LibraryResource
{
    protected final String classification;
    protected ResourceLoan loan;
    protected String title;

    /**
     * Constructor for LibraryResource class
     * Generates a random identification
     */
    public LibraryResource()
    {
        UUID randomString = UUID.randomUUID();
        this.classification = randomString.toString();
    }
    public LibraryResource(String name)
    {
        UUID randomString = UUID.randomUUID();
        this.classification = randomString.toString();
        title = name;
    }

    /**
     * Returns the classification ID of a resource
     * @return the classification ID of a resource
     */
    public String getClassification()
    {
        return this.classification;
    }

    /**
     * Checks the loan status of a resource
     * @return The loan object attached to the resource
     */
    public ResourceLoan getLoan()
    {
        return this.loan;
    }

    /**
     * Returns the title of a library resource
     * @return The title of the resource
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the resource
     * @param title New title of the resource
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
