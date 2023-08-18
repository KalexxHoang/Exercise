package Controller;

import Model.BorrowNote;
import Model.Card;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import Model.Student;
import View.MENU;
import View.View;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Card> cardList;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.view = new View();
        this.cardList = new LinkedHashSet<>();
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu(){
        int menuOp;
        boolean condition = true;
        while (condition){
            view.printMenu();
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
     *            addNote            *
     *********************************/
    public void checkCardID(String cardID, BorrowNote borrowNote) {
        Optional<Card> check = this.cardList.stream()
                .filter(item -> item.equals(new Card(cardID)))
                .findFirst();

        if (check.isPresent()) {
            check.get().addNote(borrowNote);
        }else {
            view.showNoExistCard();

            Student student = view.createStudent();
            Card card = new Card(cardID,student);

            card.addNote(borrowNote);
            this.cardList.add(card);
        }
    }

    public void addNote() {
        String cardID = view.inputCardID();

        BorrowNote borrowNote = view.createNote();
        checkCardID(cardID,borrowNote);
    }

    /*********************************
     *           deleteNote          *
     *********************************/
    public void deleteNote() {
        String borrowCode = view.inputBorrowCode();

        this.cardList.forEach(item -> item.deleteNote(borrowCode));
    }

    /*********************************
     *           showCard            *
     *********************************/
    public void showCard() {
        this.cardList.forEach(Card::showCard);
    }
}
