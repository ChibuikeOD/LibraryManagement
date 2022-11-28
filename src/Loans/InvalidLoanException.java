package Loans;

public class InvalidLoanException extends Exception
{
   public InvalidLoanException()
   {
       super("Invalid loan. Please try again");
   }

}
