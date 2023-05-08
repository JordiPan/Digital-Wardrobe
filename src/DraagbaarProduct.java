import java.util.Date;

public abstract class DraagbaarProduct {
    public String naam;
    protected String beschrijving;
    protected double prijs;
    protected Date datum;

    public DraagbaarProduct(String naam, String beschrijving, double prijs, Date datum) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.datum = datum;
    }

    public abstract String getDetails();
}
