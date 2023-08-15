package Controller;

import Model.Contestant;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LogicAdmissions {
    /**********************************
     *            Attribute           *
     **********************************/
    Set<Contestant> contestantSet;

    /*********************************
     *            Constructor        *
     *********************************/
    public LogicAdmissions() {
        this.contestantSet = new LinkedHashSet<>();
    }

    /*********************************
     *          Add Contestant       *
     *********************************/
    public void addDoc(Contestant contestant) {
        for (Contestant item : this.contestantSet) {
            if (item.equals(contestant)) {
                System.out.println("This SBD already exists!");
                System.out.println("Do you want to replace?");
                System.out.println("\t1: YES");
                System.out.println("\t2: NO");
                int option = new Scanner(System.in).nextInt();

                switch (option) {
                    case 1:
                        this.contestantSet.remove(item);
                        this.contestantSet.add(contestant);
                    case 2:
                        return;
                }
            }
        }
        this.contestantSet.add(contestant);
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    public void showContestant() {
        this.contestantSet.forEach(Contestant::showInfor);
    }

    /*********************************
     *          searchSBD            *
     *********************************/
    public void searchSBD(String SBD) {
        for (Contestant contestant : this.contestantSet) {
            if (contestant.getSBD().equals(SBD)) {
                contestant.showInfor();
                return;
            }
        }
        System.out.println("Can't find this SBD!");
    }
}
