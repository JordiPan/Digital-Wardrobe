import java.util.ArrayList;

public class Categorie {
    private String naam;
    private ArrayList<Kledingstuk> kleding = new ArrayList<>();

    public ArrayList<Kledingstuk> getKleding() {
        return kleding;
    }

    public Categorie(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void voegKledingToeInCategorie(Kledingstuk kledingstuk) {
        kleding.add(kledingstuk);
    }

    //type Date is vervelend om te checken dus voor nu geen type date, maar String
    public Kledingstuk maakKledingstukAan(String naam, String beschrijving, double prijs, String date, int maat) {
        return new Kledingstuk(naam, beschrijving, prijs, date, maat);
    }
    //gaat het een error geven als ik maat niet meegeef voor oorbel??? we zien wel
    public Oorbel maakOorbelAan(String naam, String beschrijving, double prijs, String date, String vorm, String materiaal, int karaat) {
        return new Oorbel(naam, beschrijving, prijs, date, vorm, materiaal, karaat);
    }
    public Bril maakBrilAan(String naam, String beschrijving, double prijs, String date, boolean isGetint, int sterkte, String maker) {
        return new Bril(naam, beschrijving, prijs, date, isGetint, sterkte, maker);
    }
}
