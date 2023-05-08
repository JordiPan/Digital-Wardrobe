import java.awt.dnd.DragGestureRecognizer;
import java.util.ArrayList;
import java.util.Date;

public class Categorie {
    private String naam;
    private ArrayList<DraagbaarProduct> draagbareProducten = new ArrayList<>();

    public Categorie(String naam) {
        this.naam = naam;
    }

    public ArrayList<DraagbaarProduct> getDraagbareProducten() {
        return draagbareProducten;
    }

    public String getNaam() {
        return naam;
    }

    public void voegKledingToeInCategorie(DraagbaarProduct draagbaarProduct) {
        draagbareProducten.add(draagbaarProduct);
    }

    //type Date is vervelend om te checken dus voor nu geen type date, maar String
    public Kledingstuk maakKledingstukAan(String naam, String beschrijving, double prijs, Date datum, int maat) {
        return new Kledingstuk(naam, beschrijving, prijs, datum, maat);
    }
    //gaat het een error geven als ik maat niet meegeef voor oorbel??? we zien wel
    public Oorbel maakOorbelAan(String naam, String beschrijving, double prijs, Date datum, String vorm, String materiaal, double karaat) {
        return new Oorbel(naam, beschrijving, prijs, datum, vorm, materiaal, karaat);
    }
    public Bril maakBrilAan(String naam, String beschrijving, double prijs, Date datum, boolean isGetint, double sterkte, String maker) {
        return new Bril(naam, beschrijving, prijs, datum, isGetint, sterkte, maker);
    }

    public boolean verwijderDraagbaarProduct(String kledingstukNaam) {
        for (DraagbaarProduct draagbaarProduct: draagbareProducten) {
            if (draagbaarProduct.naam.equals(kledingstukNaam)) {
                draagbareProducten.remove(draagbaarProduct);
                return true;
            }
        }
        return false;
    }
}
