/**
 * Library.java
 * This class holds and handles data of the members and resources of the library
 * @author CHibuike Odibeli
 */
package Library;

import LibResources.InvalidResourceException;
import LibResources.LibraryResource;
import Loans.InvalidLoanException;
import Loans.ResourceLoan;
import Members.Librarian;
import Members.Member;
import Members.Student;
import Members.Teacher;
import Loans.ResourceLoan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    private ArrayList<LibraryResource> resources;
    private static Member activeMember;
    public boolean logout = false;

    /**
     * Constructor that instantiates the library
     */
    public Library() {
        resources = new ArrayList<>();
        LibraryResource Book1 = new LibraryResource("Book1");
        resources.add(Book1);
    }


    /**
     * Returns a list of all the resources of the library
     *
     * @return an Arraylist of all the resources of the library
     */
    public ArrayList<LibraryResource> getAllResources() {
        return resources;
    }

    /**
     * Adds a resource to the library
     */
    public void addResource(LibraryResource newResource) {
        this.resources.add(newResource);
    }

    /**
     * Removes a resource from the library.
     * @param newResource Resource to be removed
     */
    public void removeResource(LibraryResource newResource) {
        this.resources.remove(newResource);
    }

    /**
     * Creates a new ResourceLoan object to handle members borrowing resources from the library
     * @param loanee The member borrowing the resources
     * @param item The resource to be borrowed
     */
    public void loanResource(Member loanee, LibraryResource item) {
        ResourceLoan newLoan = new ResourceLoan(loanee, item);
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(14);
        newLoan.setLoanDue(dueDate);

        loanee.addLoan(newLoan);

    }

    /**
     * Searches the library for a certain resource
     * @param input The name of the resource to be found
     * @return The found resource
     * @throws InvalidResourceException catches if the resource is not in the library
     */
    public LibraryResource searchLibrary(String input) throws InvalidResourceException {
        LibraryResource found = null;
    do {
        for (int i = 0; i <= resources.size() - 1; i++) {
            if (input.equalsIgnoreCase(resources.get(i).getTitle())) {
                found = resources.get(i);
                return found;
            }
        }
        if (found == null) {
            throw new InvalidResourceException();
        }
    }while (found == null);
    return found;
    }


    public static void main(String[] args) throws InvalidResourceException, InvalidLoanException {
        Library lib = new Library(); //Instantiating the library


        System.out.println("Welcome to the library! \n What is your name?"); //Welcome message
        Scanner scan = new Scanner(System.in);
        String nameIn = scan.nextLine();


        System.out.println("What is your role?\n 1. Librarian\n 2. Teacher\n 3. Student");
        int role = scan.nextInt(); //role selection

        if (role == 1) {
            activeMember = new Librarian(nameIn);
            System.out.println("As a librarian, you can have 5 resources checked out");
        } else if (role == 2) {
            activeMember = new Teacher(nameIn);
            System.out.println("As a teacher, you can have 3 resources checked out");
        } else if (role == 3) {
            activeMember = new Student(nameIn);
            System.out.println("As a student, you can have 1 resource checked out");
        }

        System.out.println("Welcome " + activeMember.getName());

do
{
    //Main menu
    System.out.println("What section would you like to visit?");
    System.out.println("1. View Loans");
    System.out.println("2. Search for Books");
    System.out.println("3. Borrow a Book");
    System.out.println("4. Return a Book");
    System.out.println("5. Extend a Loan");
    System.out.println("6. Add a Book");
    System.out.println("7. Remove a Book");
    System.out.println("8. Quit");


    scan = new Scanner(System.in);
    String command = scan.nextLine();
    //Switch to handle main menu
    switch (command) {
        case "1":
        case "view":
        case "loans":
        case "view loans":

            // Views the active user's loans

            ArrayList<ResourceLoan> loanList = activeMember.getAllLoans();
            if (loanList.isEmpty()) {
                System.out.println("You have no resources checked out");
            } else {
                System.out.println("Here is a list of your borrowed resources");


                for (int z = 0; z <= loanList.size()-1; z++) {
                    System.out.println(loanList.get(z).getItem().getTitle());
                }
            }
            break;


        case "2":
        case "search":
        case "books":
        case "search for books":
        case "view books":
            boolean cont = false;

//Searches library for resource ibput
            System.out.println("Input the title of the resource");
            Scanner scanner = new Scanner(System.in);
            String titleIn = scanner.nextLine();
            LibraryResource searched = new LibraryResource();
            searched = lib.searchLibrary(titleIn);
            System.out.println("Your resource has been found!");
            System.out.println("Would you like to borrow it?");
            System.out.println("1. Yes \n 2. No");
            String in2 = scanner.nextLine();
            if (in2.equalsIgnoreCase("yes") || in2.equalsIgnoreCase("1")) {
                lib.loanResource(activeMember, searched);
                System.out.println("YoU have now checked out " + searched.getTitle() + " for 2 weeks.");
                System.out.println("You have the option to extend the loan from the main menu");
            } else {
                System.out.println("Ok. You will now be redirected to the main menu");
            }
            break;
        case "3":
        case "borrow":
        case "borrow a book":
            //Allows a member of the library to borrow  book from the library
            System.out.println("What resource would you like to borrow?");
            scanner = new Scanner(System.in);
            String in = scanner.nextLine();
            searched = new LibraryResource();
            searched = lib.searchLibrary(in);
            lib.loanResource(activeMember, searched);
            System.out.println("YoU have now checked out " + searched.getTitle() + " for 2 weeks.");
            System.out.println("It will be due on " + activeMember.getAllLoans().get(0).getLoanDue().toString());
            System.out.println("You have the option to extend the loan from the main menu");
            break;
        case "4":
        case "return":
            //Allows a member of the library to return a resource to the library
            System.out.println("What resource would you like to return");
            scan = new Scanner(System.in);
            String input = scan.nextLine();
            activeMember.returnResource(input);
            break;
        case "5":
        case "extend":
        case "extend a loan":
        case "extension":
        case "extension request":
        case "request an extension":
            //Allows a member to extend a current loan
            System.out.println("How many extra days would you like?");
            int extend = scan.nextInt();
            if (activeMember.getAllLoans().isEmpty()) {
                throw new InvalidLoanException();
            }
            activeMember.getAllLoans().get(0).extendLoan(activeMember.getAllLoans().get(0), extend);

            System.out.println("Your new due date is " + activeMember.getAllLoans().get(0).getLoanDue().toString());
            break;
        case "6":
        case "add":
        case "add a book":
            //Allows a member of the library with permissions to add resources to the library
            if (activeMember.getManagementPrivileges()) {
                System.out.println("What is the title of this resource?");
                String addIn = scan.nextLine();
                LibraryResource added = new LibraryResource(addIn);
                lib.addResource(added);
                System.out.println("The resource has been added.");

            } else {
                System.out.println("You do not have permission for this action.");
                System.out.println("You will now be redirected to the main menu");
            }
            break;
        case "7":
        case "remove":
        case "remove a book":
            //Allows a member of the library with permissions to remove resources from the library
            if (activeMember.getManagementPrivileges()) {
                System.out.println("What resource would you like to remove?");
                String removeIn = scan.nextLine();
                LibraryResource removed = new LibraryResource();
                removed = lib.searchLibrary(removeIn);
                lib.removeResource(removed);
                System.out.println("The resource has been removed");

            } else {
                System.out.println("You do not have permission for this action.");
                System.out.println("You will now be redirected to the main menu");
            }
            break;
        case "8":
        case "quit":
            System.out.println("Thank you for visiting the library. Have a nice day");
            lib.logout = true;

    }
}while(!lib.logout);
        }

    }


