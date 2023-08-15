package Controller;

import Model.Book;
import Model.Document;
import Model.Magazine;
import Model.Newspaper;
import View.DOCUMENT;
import View.MENU;

import java.util.Scanner;

public class UserView {
    /**********************************
     *            Attribute           *
     **********************************/
    private DocumentsManager userView;

    /*********************************
     *            Constructor        *
     *********************************/
    public UserView() {
        this.userView = new DocumentsManager();
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu(){
        int menuOp;
        boolean condition = true;
        while (condition){
            printMenu();
            menuOp = new Scanner(System.in).nextInt();
            MENU menu = MENU.getEnumMenu(menuOp);
            switch (menu){
                case ADD_DOC:
                    System.out.println("Please import the document type you want to add: ");
                    addDoc(this.userView);
                    break;
                case DELETE_DOC:
                    System.out.println("Please import the document ID you want to delete: ");
                    String docID = new Scanner(System.in).nextLine();
                    this.userView.removeDoc(docID);
                    break;
                case SHOW_DOC:
                    this.userView.showDocument();
                    break;
                case SEARCH_DOC:
                    System.out.println("Please import the document type you want to search: ");
                    searchDoc();
                    break;
                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

    /*********************************
     *            printMenu        *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add Document");
        System.out.println("\t2: Delete Document");
        System.out.println("\t3: Show Document");
        System.out.println("\t4: Search by Type");
        System.out.println("\t5: Exit");
    }

    /*********************************
     *            printDoc           *
     *********************************/
    public void printDoc(){
        System.out.println("\t1: Book");
        System.out.println("\t2: Magazine");
        System.out.println("\t3: Newspaper");
    }

    /*********************************
     *            addDoc          *
     *********************************/
    public void addDoc(DocumentsManager docList){
        printDoc();
        int docOp = new Scanner(System.in).nextInt();
        DOCUMENT doc = DOCUMENT.getEnumDocument(docOp);
        System.out.println("Please import some information about document:");
        System.out.println("ID: ");
        String docID = new Scanner(System.in).nextLine();

        System.out.println("Publishing Company: ");
        String publishingCompany = new Scanner(System.in).nextLine();

        System.out.println("Release Number: ");
        int releaseNumber = new Scanner(System.in).nextInt();

        switch (doc) {
            case BOOK:
                String type1 = "Book";
                System.out.println("Author: ");
                String author = new Scanner(System.in).nextLine();

                System.out.println("Number of Page: ");
                int pageNumber = new Scanner(System.in).nextInt();

                Document doc1 = new Book(docID,publishingCompany,releaseNumber,type1,author,pageNumber);
                docList.addDoc(doc1);
                break;
            case MAGAZINE:
                String type2 = "Magazine";
                System.out.println("Issue Number: ");
                int issueNumber = new Scanner(System.in).nextInt();

                System.out.println("Release Month: ");
                int releaseMonth = new  Scanner(System.in).nextInt();

                Document doc2 = new Magazine(docID,publishingCompany,releaseNumber,type2,issueNumber,releaseMonth);
                docList.addDoc(doc2);
                break;
            case NEWSPAPER:
                String type3 = "Newspaper";
                System.out.println("Release Day: ");
                int releaseDay = new Scanner(System.in).nextInt();

                Document doc3 = new Newspaper(docID,publishingCompany,releaseNumber,type3,releaseDay);
                docList.addDoc(doc3);
                break;
        }
    }

    /*********************************
     *            searchDoc          *
     *********************************/
    public void searchDoc() {
        printDoc();
        int docOp = new Scanner(System.in).nextInt();
        DOCUMENT doc = DOCUMENT.getEnumDocument(docOp);
        switch (doc) {
            case BOOK:
                userView.showType("Book");
                break;
            case MAGAZINE:
                userView.showType("Magazine");
                break;
            case NEWSPAPER:
                userView.showType("Newspaper");
                break;
        }
    }
}
