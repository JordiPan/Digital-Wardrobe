public class Gebruiker {
    private String naam;
    private String wachtwoord;
    private double budget;

    public Gebruiker(String naam, String wachtwoord, double budget) {
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.budget = budget;
    }

    public String getNaam() {
        return naam;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    //verbeter later beveiliging van dit met encryptie etc
    public boolean checkWachtwoord(String wachtwoord) {
        return this.wachtwoord.equals(wachtwoord);
    }

    public double getBudget() {
        return budget;
    }

    public void updateBudget(double nieuwKledingPrijs) {
        budget -= nieuwKledingPrijs;
    }
}
