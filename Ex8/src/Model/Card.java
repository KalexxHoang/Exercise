package Model;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Card {
    /**********************************
     *            Attribute           *
     **********************************/
    private String cardID;
    private Set<BorrowNote> noteList;
    private Student student;

    /*********************************
     *            Constructor        *
     *********************************/
    public Card(String cardID) {
        this.cardID = cardID;
    }

    public Card(String cardID, Student student) {
        this.cardID = cardID;
        this.student = student;
        this.noteList = new LinkedHashSet<>();
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public LinkedHashSet<BorrowNote> getNoteList() {
        return (LinkedHashSet<BorrowNote>) noteList;
    }

    public void setNoteList(Set<BorrowNote> noteList) {
        this.noteList = noteList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.cardID.equals(((Card) obj).getCardID());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + cardID.hashCode();

        return result;
    }

    /*********************************
     *          addNote              *
     *********************************/
    public void addNote(BorrowNote borrowNote) {
        Optional<BorrowNote> check = this.noteList.stream()
                .filter(item -> item.equals(borrowNote))
                .findFirst();
        if (check.isPresent()) {
            System.out.println("This note already exists!");
            System.out.println("Do you want to replace?");
            System.out.println("\t1: YES");
            System.out.println("\t2: NO");
            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    this.noteList.remove(check.get());
                    this.noteList.add(borrowNote);
                case 2:
                    return;
            }
        }
        this.noteList.add(borrowNote);
    }

    /*********************************
     *          deleteNote           *
     *********************************/
    public void deleteNote(String borrowCode) {
        this.noteList.remove(new BorrowNote(borrowCode));
    }


    /*********************************
     *          showCard             *
     *********************************/
    public void showCard() {
        System.out.println("CardID: " + cardID);
        System.out.println("Student:");
        this.student.showInfor();
        System.out.println("Borrow list:");
        this.noteList.forEach(BorrowNote::showInfor);
        System.out.println("====================================================");
    }
}
