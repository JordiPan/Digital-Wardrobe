public class Kledingstuk {
    private String naam;
    private String beschrijving;
    private double prijs;
    private String datum;
    private int maat;

    public Kledingstuk(String naam, String beschrijving, double prijs, String datum) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.datum = datum;
    }
    public Kledingstuk(String naam, String beschrijving, double prijs, String datum, int maat) {
        this(naam, beschrijving, prijs, datum);
        this.maat = maat;
    }



    public String getNaam() {
        return naam;
    }

    public String getDetails() {
        return beschrijving + " Daarnaast is het ook op maat " + maat;
    }

    public double getPrijs() {
        return prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }
}
