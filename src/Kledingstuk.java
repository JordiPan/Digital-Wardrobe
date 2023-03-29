import java.util.Date;

public class Kledingstuk {
    private String naam;
    private String beschrijving;
    private double prijs;
    private Date datum;

    public Kledingstuk(String naam, String beschrijving, double prijs, Date datum) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.datum = datum;
    }


    public String getNaam() {
        return naam;
    }

    public String getDetails() {
        return beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public Date getDatum() {
        return datum;
    }
}
