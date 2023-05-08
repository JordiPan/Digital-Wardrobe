import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        //TODO wachtwoord check verbeteren
        boolean ingelogd = false;
        while(!ingelogd) {
            System.out.println("voer wachtwoord in...");
            String gekregenWachtwoord = scanner.nextLine();

            if (gebruiker.checkWachtwoord(gekregenWachtwoord)) {
                ingelogd = true;
            }
            else {
                System.out.println("Verkeerd... probeer opnieuw");
            }
        }

        boolean stoppen = false;
        System.out.println("Welkom: " + gebruiker.getNaam());
        while (!stoppen) {
            System.out.println("Wat wilt u doen? " +
                    "'kleding beheren', 'categorieen beheren', 'kledingkast bekijken', 'categorieen zien', 'budget zien' of 'stoppen'");
            switch (scanner.nextLine()) {
                case "kleding beheren" -> {
                    //extra while loop wordt gebruikt zodat het niet terug gaat naar de eerste optie op een foutief antwoord
                    boolean kledingbeheren = true;
                    while (kledingbeheren) {
                        System.out.println("Kleding 'verwijderen', 'toevoegen' of 'teruggaan'?");
                        String antwoord = scanner.nextLine();

                        switch (antwoord) {
                            case "verwijderen" -> {
                                kledingVerwijderen();
                            }
                            case "toevoegen" -> {
                                kledingToevoegen();

                            }
                            case "teruggaan" -> kledingbeheren = false;
                            default -> System.out.println("Geen optie geselecteerd");
                        }
                    }
                }
                case "categorieen beheren" -> {
                    boolean categorieenBeheren = true;
                    while (categorieenBeheren) {
                        System.out.println("Categorie 'verwijderen' of 'toevoegen'? Of wilt u 'teruggaan'?");
                        String antwoord = scanner.nextLine();

                        switch (antwoord) {
                            case "verwijderen" -> {
                                categorieVerwijderen();
                            }
                            case "toevoegen" -> {
                                categorieToevoegen();
                            }
                            case "teruggaan" -> categorieenBeheren = false;
                            default -> System.out.println("Spellingsfout?");
                        }
                    }
                }
                case "kledingkast bekijken" -> printKledingkast();
                case "categorieen zien" -> printCategorieen();
                case "budget zien" -> printBudget();
                case "stoppen" -> {
                    stoppen = true;
                    System.out.println("Tot de volgende keer!");
                }
                default -> System.out.println("Dat is geen optie :c");
            }
        }
    }
    public void kledingToevoegen() {
        boolean gevonden = false;
        Date datum;
        System.out.println("Bij welke categorie hoort het? (Torso, Hoofd, etc)");
        String gekozenCategorie = scanner.nextLine();
        for (Categorie categorie : kledingkast.getCategorieen()) {
            if (categorie.getNaam().equals(gekozenCategorie)) {
                gevonden = true;
                System.out.println("Is het een 'kledingstuk', 'oorbel' of 'bril'?");
                String gekozenSoort = scanner.nextLine();

                System.out.println("Wat is het naam?");
                String naam = scanner.nextLine();

                System.out.println("Kunt u een beschrijving geven?");
                String beschrijving = scanner.nextLine();

                System.out.println("Wat is het prijs? Formaat: 'XX,XX'");
                double prijs = scanner.nextDouble();
                scanner.nextLine();

                try {
                    System.out.println("Wanneer had u het gekocht/gekregen? Formaat: 'dd/mm/yyyy'");
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String stringDatum = scanner.nextLine();
                    datum = formatter.parse(stringDatum);
                } catch (ParseException e) {
                    e.printStackTrace();
                    break;
                }

                switch (gekozenSoort) {
                    case "kledingstuk" -> {
                        System.out.println("Wat is het maat van het kledingstuk? (alleen cijfers)");
                        int maat = scanner.nextInt();
                        scanner.nextLine();

                        Kledingstuk stuk = categorie.maakKledingstukAan(naam, beschrijving, prijs, datum, maat);
                        categorie.voegKledingToeInCategorie(stuk);
                        System.out.println("Kledingstuk is aangemaakt!");
                        //TODO budget updaten via methode, zodat oorbel en bril methode kan hergebruiken (gebeurt later wel)
                    }
                    case "oorebl" -> {
                        System.out.println("Wat voor vorm heeft het? (rond, ovaal, diamant, etc)");
                        String vorm = scanner.nextLine();
                        System.out.println("Wat is het materiaal van de oorbellen?");
                        String materiaal = scanner.nextLine();
                        System.out.println("Karaat? Als het geen karaat heeft dan kan het 0 zijn");
                        double karaat = scanner.nextDouble();
                        scanner.nextLine();

                        Oorbel oorbel = categorie.maakOorbelAan(naam, beschrijving, prijs, datum, vorm, materiaal, karaat);
                        categorie.voegKledingToeInCategorie(oorbel);
                        System.out.println("Oorbel is aangemaakt!");
                    }
                    case "bril" -> {
                        System.out.println("Is het getint/een zonnebril? true/false");
                        boolean isGetint = scanner.nextBoolean();
                        scanner.nextLine();
                        System.out.println("Wie is de maker van de bril?");
                        String maker = scanner.nextLine();
                        System.out.println("Wat is de sterkte van de bril? Doe 0 als het geen sterkte heeft");
                        double sterkte = scanner.nextDouble();
                        scanner.nextLine();

                        Bril bril = categorie.maakBrilAan(naam, beschrijving, prijs, datum, isGetint, sterkte, maker);
                        categorie.voegKledingToeInCategorie(bril);
                        System.out.println("Bril is aangemaakt!");
                    }
                    default ->
                            System.out.println("Er is iets fouts geschreven, probeer opnieuw...");
                }
//                                        break;
            }
        }
        if (!gevonden) {
            System.out.println("Categorie bestaat niet... Heeft u het goed gespeld? Kijk uit voor hoofdletters!!");
        }
    }

    public void kledingVerwijderen() {
        boolean categorieGevonden = false;
        System.out.println("Uit welke categorie is het?");
        String gekregenCategorie = scanner.nextLine();
        for (Categorie categorie : kledingkast.getCategorieen()) {
            if (categorie.getNaam().equals(gekregenCategorie)) {
                categorieGevonden = true;
                System.out.println("Wat is het naam van het kledingstuk?");
                String gekregenKledingNaam = scanner.nextLine();
                if (categorie.verwijderDraagbaarProduct(gekregenKledingNaam)) {
                    System.out.println("Het was succesvol!!!");
                } else {
                    System.out.println("We konden niets vinden....");
                    break;
                }
            }
        }
        if (!categorieGevonden) {
            System.out.println("Categorie bestaat niet... Heeft u het goed gespeld? Kijk uit voor hoofdletters!!");
        }
    }

    public void categorieToevoegen() {
        System.out.println("Wat zal de naam worden?");
        String categorieNaam = scanner.nextLine();
        kledingkast.voegToe(categorieNaam);
        System.out.println("Het is gedaan volgens mij...");
    }

    public void categorieVerwijderen() {
        System.out.println("Wat is de naam van de categorie?");
        String gekregenCategorie = scanner.nextLine();
        if (kledingkast.verwijderCategorie(gekregenCategorie)) {
            System.out.println("De categorie is verwijdert");
        }
        else {
            System.out.println("Er is iets misgegaan...");
        }
    }
    public void printKledingkast() {
        for (Categorie categorie:
                kledingkast.getCategorieen()) {
            System.out.println("Categorie: " + categorie.getNaam());
            System.out.println();
            if (categorie.getDraagbareProducten().isEmpty()) {
                System.out.println("Geen kledingstukken in dit categorie te vinden...");
                System.out.println();
            } else {
                for (DraagbaarProduct draagbaarProduct :
                        categorie.getDraagbareProducten()) {
                    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Naam: " + draagbaarProduct.naam);
                    //raar genoeg werkt de method overriding hier ook al hoort het niet meer te weten welke subklasse het is... ik kan nog altijd een id variabel toevoegen en if statements als dit niet goed is
                    System.out.println("Details: " + draagbaarProduct.getDetails());
                    System.out.printf("Prijs: %.2f %n", draagbaarProduct.prijs);
                    System.out.println("Datum: " + formatter.format(draagbaarProduct.datum));
                    System.out.println();
                }
            }
        }
    }

    public void printCategorieen() {
        for (Categorie categorie:
                kledingkast.getCategorieen()) {
            System.out.println(categorie.getNaam());
        }
    }

    public void printBudget() {
        System.out.println("Uw budget: " + gebruiker.getBudget());
    }
}
