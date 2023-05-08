import java.util.Date;

public class Bril extends Kledingstuk{
    private boolean isGetint;
    private double sterkte;
    private String maker;

    public Bril(String naam, String beschrijving, double prijs, Date datum, boolean isGetint, double sterkte, String maker) {
        super(naam, beschrijving, prijs, datum);
        this.isGetint = isGetint;
        this.sterkte = sterkte;
        this.maker = maker;
    }
//    @Override
//    public String getNaam() {
//        return super.getNaam();
//    }

    @Override
    public String getDetails() {
        return super.getDetails() + " Ook is de bril " + ((isGetint) ? "getint" : "niet getint") + " met een sterkte van " + sterkte + " en het is gemaakt door: " + maker;
    }
}
