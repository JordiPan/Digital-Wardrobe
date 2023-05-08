import java.util.ArrayList;
import java.util.Date;

public class Categorie {
    private String naam;
    private ArrayList<Kledingstuk> kleding = new ArrayList<>();

    public Categorie(String naam) {
        this.naam = naam;
    }

    public ArrayList<Kledingstuk> getKleding() {
        return kleding;
    }

    public String getNaam() {
        return naam;
    }

    public void voegKledingToeInCategorie(Kledingstuk kledingstuk) {
        kleding.add(kledingstuk);
    }

    //type Date is vervelend om te checken dus voor nu geen type date, maar String
    public Kledingstuk maakKledingstukAan(String naam, String beschrijving, double prijs, Date datum) {
        return new Kledingstuk(naam, beschrijving, prijs, datum);
    }
    //gaat het een error geven als ik maat niet meegeef voor oorbel??? we zien wel
    public Oorbel maakOorbelAan(String naam, String beschrijving, double prijs, Date datum, String vorm, String materiaal, double karaat) {
        return new Oorbel(naam, beschrijving, prijs, datum, vorm, materiaal, karaat);
    }
    public Bril maakBrilAan(String naam, String beschrijving, double prijs, Date datum, boolean isGetint, double sterkte, String maker) {
        return new Bril(naam, beschrijving, prijs, datum, isGetint, sterkte, maker);
    }
    //ik weet niet of dit gaat werken door object mee te geven aan arraylist LET EROP
    public boolean verwijderKledingstuk(String kledingstukNaam) {
        for (Kledingstuk kledingstuk: kleding) {
            if (kledingstuk.getNaam().equals(kledingstukNaam)) {
                kleding.remove(kledingstuk);
                return true;
            }
        }
        return false;
    }
}
