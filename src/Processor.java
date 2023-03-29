import java.util.ArrayList;
import java.util.Scanner;

public class Processor {
    private Kledingkast kledingkast;
    private Gebruiker gebruiker;
    private Scanner scanner = new Scanner(System.in);

    //doe variabel onthouden (voor alle variabelen van kledingstukken) binnen de methode wanneer de user kleding wilt aanmaken,
    // niet hier buiten of anders zijn er volgens mij teveel variabelen in UML
    Processor(String naam, String wachtwoord, double budget) {
        // standaard categorieen toevoegen
        ArrayList<Categorie> categorieen = new ArrayList<>();
        categorieen.add(new Categorie("Hoofd"));
        categorieen.add(new Categorie("Torso"));
        categorieen.add(new Categorie("Benen"));
        categorieen.add(new Categorie("Voeten"));
        kledingkast = new Kledingkast(categorieen);

        gebruiker = new Gebruiker(naam, wachtwoord, budget);
    }

    public void start() {
        boolean stoppen = false;
        //TODO wachtwoord check komt wel later tho
        System.out.println("Welkom: " + gebruiker.getNaam());
        while (!stoppen) {
            System.out.println("Wat wilt u doen? " +
                    "'kleding beheren', 'categorieen beheren', 'kledingkast bekijken', 'categorieen zien', 'budget zien', 'stoppen'");
            switch (scanner.nextLine()) {
                case "kleding beheren":
                    //while loop wordt gebruikt zodat het niet terug gaat naar de eerste optie op een foutief antwoord
                    boolean kledingbeheren = true;
                    while (kledingbeheren) {
                        System.out.println("Kledingstuk 'verwijderen' of 'toevoegen'");

                        if (scanner.nextLine().equals("verwijderen")) {
                            System.out.println("geef het naam van de kledingstuk");
                        }
                        else if (scanner.nextLine().equals("toevoegen")) {

                        }
                        else {

                        }
                    }

                    break;
                case "categorieen beheren":
                    break;
                case "kledingkast bekijken":
                    for (Categorie categorie:
                            kledingkast.getCategorieen()) {
                        System.out.println("Categorie: " + categorie.getNaam());
                        if (categorie.getKleding().isEmpty()) {
                            System.out.println("Geen kledingstukken in dit categorie te vinden...");
                        }
                        else {
                            for (Kledingstuk kledingstuk:
                                    categorie.getKleding()) {
                                System.out.println("Naam:" + kledingstuk.getNaam());
                                System.out.println("Details: " + kledingstuk.getDetails());
                                System.out.println("Prijs: " + kledingstuk.getPrijs());
                                System.out.println();
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "categorieen zien":
                    for (Categorie categorie:
                            kledingkast.getCategorieen()) {
                        System.out.println(categorie);
                    }

                    break;
                case "budget zien":
                    System.out.println("Uw budget: " + gebruiker.getBudget());
                    break;
                case "stoppen":
                    stoppen = true;
                    System.out.println("Tot de volgende keer!");
                    break;
                default:
                    System.out.println("Dat is geen optie :c");
            }
        }

    }
}
