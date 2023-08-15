package View;

import Controller.Admissions;
import View.BLOCK;
import View.MENU;

public class Main {
    public static void main(String[] args) {
        Admissions userView = new Admissions();
        userView.userMenu();
    }
}