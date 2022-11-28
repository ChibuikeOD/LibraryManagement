/**
 * ResourceLoan.java
 * Handles borrowing and retuning objects to the library
 * @author Chibuike Odibeli
 */
package Loans;

import LibResources.LibraryResource;
import Members.Member;

import java.time.LocalDate;


public class ResourceLoan
{
    protected Member loanee;
    protected LibraryResource item;
    protected LocalDate loanDue;


    public ResourceLoan(Member loanee, LibraryResource item)
    {
        this.loanee = loanee;
        this.item = item;
    }
    /**
     * Returns the member that borrowed the resource
     * @return  member that borrowed the resource
     */
    public Member getLoanee()
    {
    return this.loanee;
    }

    /**
     *
     * @return The resource that was borrowed
     */
    public LibraryResource getItem()
    {
    return this.item;
    }

    /**
     *
     * @return The due date of the loan
     */
    public LocalDate getLoanDue() {
        return loanDue;
    }

    public void setLoanDue(LocalDate loanDue) {
        this.loanDue = loanDue;
    }

    /**
     *
     * @return The date the resource was borrowed
     */


    /**
     * Extends the loan by a specified amount of time
     */
    public void extendLoan(ResourceLoan loanObject, Integer extension) throws InvalidLoanException
    {

        if(extension < 0 )
        {

            throw new InvalidLoanException();
        }

        
        LocalDate CurrentDueDate = loanObject.getLoanDue();

        long extensionValue = extension.longValue();


        CurrentDueDate = CurrentDueDate.plusDays(extensionValue);


    }


}
