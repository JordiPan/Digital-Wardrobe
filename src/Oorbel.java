public class Oorbel extends Kledingstuk{
    private String vorm;
    private String materiaal;
    private int karaat;

    Oorbel(String naam, String beschrijving, double prijs, String datum, String vorm, String materiaal, int karaat) {
        super(naam, beschrijving, prijs, datum);
        this.vorm = vorm;
        this.materiaal = materiaal;
        this.karaat = karaat;
    }

    @Override
    public String getNaam() {
        return super.getNaam();
    }

    public String getMateriaal() {
        return materiaal;
    }

    public int getKaraat() {
        return karaat;
    }

    @Override
    public String getDetails() {
        return super.getBeschrijving() + " Daarnaast zijn de oorbellen van " + materiaal + " gemaakt en zijn " + karaat + " karaat";
    }
}
