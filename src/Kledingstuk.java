import java.util.Date;

public class Kledingstuk extends DraagbaarProduct{
    private int maat;

    public Kledingstuk(String naam, String beschrijving, double prijs, Date datum, int maat) {
        super(naam, beschrijving, prijs, datum);
        this.maat = maat;
    }


//    public String getNaam() {
//        return naam;
//    }

    public String getDetails() {
        return beschrijving + " Het heeft ook een maat van: " + maat;
    }
//
//    public double getPrijs() {
//        return prijs;
//    }
//
//    public Date getDatum() {
//        return datum;
//    }
}
