package Model;

import View.View;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Person> hotel;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Hotel() {
        this.view = new View();
        this.hotel = new LinkedHashSet<>();
    }

    /*********************************
     *            addPerson          *
     *********************************/
    public void addPerson(Person person) {
        Optional<Person> check = this.hotel.stream().filter(item -> item.equals(person)).findFirst();
        if (check.isPresent()) {
            view.showReplaceOption();
            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    this.hotel.remove(check.get());
                    this.hotel.add(person);
                case 2:
                    return;
            }
        }
        this.hotel.add(person);
    }

    /*********************************
     *         deletePerson          *
     *********************************/
    public void deletePerson(int CCCD) {
        this.hotel.remove(new Person(CCCD));
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    public void showInfor() {
        this.hotel.forEach(Person::showInfor);
    }

    /*********************************
     *          computeRent          *
     *********************************/
    public void computeRent(int CCCD) {
        Optional<Person> check = this.hotel.stream().filter(item -> item.equals(new Person(CCCD))).findFirst();
        view.showRent(check);
    }
}
