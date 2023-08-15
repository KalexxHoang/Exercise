package Controller;

import Model.BorrowNote;
import Model.Card;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import Model.Student;
import View.MENU;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Card> cardList;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.cardList = new LinkedHashSet<>();
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
                case ADD_NOTE:
                    addNote();
                    break;

                case DELETE_NOTE:
                    deleteNote();
                    break;

                case SHOW_CARD:
                    showCard();
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

    /*********************************
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add Borrow note");
        System.out.println("\t2: Delete Borrow note");
        System.out.println("\t3: Show Card information");
        System.out.println("\t4: Exit");
    }

    /*********************************
     *            addNote            *
     *********************************/
    public void checkCardID(String cardID, BorrowNote borrowNote) {
        Optional<Card> check = this.cardList.stream()
                .filter(item -> item.equals(new Card(cardID)))
                .findFirst();

        if (check.isPresent()) {
            check.get().addNote(borrowNote);
        }else {
            System.out.println("This card don't exists!");
            System.out.println("You need to create a new card. Please enter information about this card:");
            System.out.println("Full name: ");
            String fullName = new Scanner(System.in).nextLine();

            System.out.println("Age: ");
            int age = new Scanner(System.in).nextInt();

            System.out.println("Class: ");
            String classs = new Scanner(System.in).nextLine();

            Student student = new Student(fullName,age,classs);
            Card card = new Card(cardID,student);

            card.addNote(borrowNote);
            this.cardList.add(card);
        }
    }

    public void addNote() {
        System.out.println("Please enter borrow note you want to add: ");
        System.out.println("Card ID: ");
        String cardID = new Scanner(System.in).nextLine();

        System.out.println("Borrow code: ");
        String borrowCode = new Scanner(System.in).nextLine();

        System.out.println("Borrow day: ");
        int borrowDay = new Scanner(System.in).nextInt();

        System.out.println("Deadline: ");
        int deadLine = new Scanner(System.in).nextInt();

        System.out.println("Book ID: ");
        String bookID = new Scanner(System.in).nextLine();

        BorrowNote borrowNote = new BorrowNote(borrowCode,borrowDay,deadLine,bookID);
        checkCardID(cardID,borrowNote);
    }

    /*********************************
     *           deleteNote          *
     *********************************/
    public void deleteNote() {
        System.out.println("Please enter borrow code you want to delete: ");
        String borrowCode = new Scanner(System.in).nextLine();

        this.cardList.forEach(item -> item.deleteNote(borrowCode));
    }

    /*********************************
     *           showCard            *
     *********************************/
    public void showCard() {
        this.cardList.forEach(Card::showCard);
    }
}
