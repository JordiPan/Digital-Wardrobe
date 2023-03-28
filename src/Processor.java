import java.util.ArrayList;
import java.util.Scanner;

public class Processor {
    private ArrayList<Kledingkast> kledingkast = new ArrayList<>();
    private Gebruiker gebruiker;
    private Scanner scanner = new Scanner(System.in);

    //doe variabel onthouden (voor alle variabelen van kledingstukken) binnen de methode wanneer de user kleding wilt aanmaken,
    // niet hier buiten of anders zijn er volgens mij teveel variabelen in UML
    Processor(String naam, String wachtwoord, double budget) {
        gebruiker = new Gebruiker(naam, wachtwoord, budget);
    }

    public void start() {

    }
}
