import java.util.Date;

public class Oorbel extends DraagbaarProduct{
    private String vorm;
    private String materiaal;
    private double karaat;


    Oorbel(String naam, String beschrijving, double prijs, Date datum, String vorm, String materiaal, double karaat) {
        super(naam, beschrijving, prijs, datum);
        this.vorm = vorm;
        this.materiaal = materiaal;
        this.karaat = karaat;
    }

//    @Override
//    public String getNaam() {
//        return super.getNaam();
//    }
//
//    public String getMateriaal() {
//        return materiaal;
//    }
//
//    public double getKaraat() {
//        return karaat;
//    }

    @Override
    public String getDetails() {
        return beschrijving + " Daarnaast zijn de oorbellen van " + materiaal + " gemaakt en zijn " + ((karaat == 0) ? "oorbellen zonder karaat" : karaat + " karaat");
    }
}
